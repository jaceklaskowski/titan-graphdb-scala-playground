import org.specs2.mutable._

class HelloWorldSpec extends Specification {

  "The test" should {
    "connect to Titan" in {
      import org.apache.commons.configuration.BaseConfiguration
      val conf = new BaseConfiguration()
      conf.setProperty("storage.backend","cassandrathrift")
      import com.thinkaurelius.titan.core.TitanFactory
      val g = TitanFactory.open(conf)
      val isOpen = g.isOpen
      g.shutdown()
      isOpen must_=== true
    }
  }
}