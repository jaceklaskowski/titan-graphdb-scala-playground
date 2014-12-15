import com.thinkaurelius.titan.core.util.TitanCleanup
import com.tinkerpop.gremlin.process.T
import com.tinkerpop.gremlin.scala.{ScalaEdge, ScalaVertex, GremlinScala}
import org.specs2._

class CassandraSpec extends Specification { def is = s2"""

  This is a specification to check Titan+Cassandra setup

  Titan+Cassandra should
    be available to clients   ${graph().e1}
                              """

  case class graph() extends specification.After {
    lazy val (g, gs) = createGraph()
    def after = {
      println("\nafter\n")
      //cleanupDB()
    }

    def e1 = {
      val n0: ScalaVertex = gs.V.has(T.label, "n0").head
      val e7: ScalaEdge = gs.E.has(T.label, "e7").head
      val e8: ScalaEdge = gs.E.has(T.label, "e8").head

      n0.outE("e7").head must_=== e7.edge
      n0.outE("e8").head must_=== e8.edge
      n0.out().count().head() must_=== 2.toLong

      gs.V.count().head must_=== 4.toLong
      gs.close()

      TitanCleanup.clear(g)

      success
    }

    def createGraph() = {
      import com.thinkaurelius.titan.core.TitanFactory
      val g = TitanFactory.build()
        .set("storage.backend", "cassandra")
        .set("storage.hostname", "127.0.0.1")
        .open()

      val gs = GremlinScala(g)

      val n0  = gs.addVertex(label = "n0",  properties = Map("name" -> "ORac"))
      val n1  = gs.addVertex(label = "n1",  properties = Map("name" -> "OrSO"))
      val n11 = gs.addVertex(label = "n11", properties = Map("name" -> "ele1"))
      val n12 = gs.addVertex(label = "n12", properties = Map("name" -> "gal1"))

      val e7 = n0.addEdge("e7", n11, Map.empty)
      val e8 = n0.addEdge("e8", n12, Map.empty)
      val e9 = n1.addEdge("e9", n0,  Map.empty)

      (g, gs)
    }
  }
}
