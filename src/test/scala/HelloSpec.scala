import org.specs2.mutable._

class HelloWorldSpec extends Specification {

  "The test" should {
    "connect to Titan, pull Saturn's keys out and shutdown cleanly" in {
      import org.apache.commons.configuration.BaseConfiguration
      val conf = new BaseConfiguration()
      conf.setProperty("storage.backend","cassandrathrift")
      import com.thinkaurelius.titan.core.TitanFactory
      val g = TitanFactory.open(conf)
      val isOpen = g.isOpen
      isOpen must_=== true

      val saturn: com.tinkerpop.blueprints.Vertex = g.query.has("name", "saturn").vertices.iterator.next()

      import scala.collection.JavaConversions._
      val keys = saturn.getPropertyKeys.toSet

      keys must_=== Set("name", "age")

      import com.tinkerpop.blueprints.Graph
      import scala.collection.JavaConverters._
      g.asInstanceOf[Graph].getVertices.asScala.toIterator.size must_=== 12

      g.shutdown

      g.isClosed must beTrue
    }
  }
}