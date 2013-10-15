name := "MungingData"

version := "0.0.1"

scalaVersion := "2.10.2"

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "1.9.2" % "test",
  "org.scalaz" %% "scalaz-core" % "7.0.0",
  "org.scalaz" %% "scalaz-effect" % "7.0.0",
  "org.scalaz" %% "scalaz-typelevel" % "7.0.0",
  "org.scalaz" %% "scalaz-scalacheck-binding" % "7.0.0" % "test"
)

scalacOptions += "-feature"

initialCommands in console := "import scalaz._, Scalaz._"
