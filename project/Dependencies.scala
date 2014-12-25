import sbt._

object Version {
  val gremlinScala = "3.0.0.M6c"
  val scala        = "2.11.4"
  val specs2       = "2.4.15"
  val titan        = "0.9.0-M1"
}

object Library {
  val gremlinScala   = "com.michaelpollmeier"    %% "gremlin-scala"   % Version.gremlinScala
  val specs2Core     = "org.specs2"              %% "specs2-core"     % Version.specs2
  val titanCassandra = "com.thinkaurelius.titan" %  "titan-cassandra" % Version.titan
  val titanCore      = "com.thinkaurelius.titan" %  "titan-core"      % Version.titan
  val titanEs        = "com.thinkaurelius.titan" %  "titan-es"        % Version.titan
}
