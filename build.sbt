name := """titan-scala-sandbox"""

version := "1.0"

scalaVersion := "2.11.4"

libraryDependencies += "org.specs2" %% "specs2" % "2.4.11" % "test"

libraryDependencies ++= Seq(
	"com.thinkaurelius.titan" % "titan-cassandra" % "0.5.2",
	"com.thinkaurelius.titan" % "titan-es" % "0.5.2"
)