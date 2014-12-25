name         := """titan-graphdb-scala-playground"""
organization := "pl.japila"
version      := "1.0"
scalaVersion := Version.scala

libraryDependencies ++= Seq(
	Library.gremlinScala,
	Library.titanCassandra,
	Library.titanCore,
	Library.titanEs,
	Library.specs2Core % "test"
)
