name := "ptbtrees"

scalaVersion := "2.11.7"

version := "0.1"

fork in run := true

parallelExecution in Test := false

crossPaths := false

scalacOptions ++= Seq("-deprecation", "-feature")

libraryDependencies ++= Seq(
  "org.scala-lang.modules" %% "scala-xml" % "1.0.5",
  "org.scalatest" %% "scalatest" % "2.2.6" % "test",
  "edu.stanford.nlp" % "stanford-corenlp" % "3.6.0"
)
