name := "KarateChop"

organization := "com.joker1007"

version := "0.1.0-SNAPSHOT"

scalaVersion := "2.10.3"

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "1.9.2" % "test"
)

parallelExecution in Test := false

