name := "solver"

version := "1.0"

scalaVersion := "2.12.2"

libraryDependencies ++= Seq(
  "org.typelevel" %% "cats" % "0.9.0",
  "org.scalacheck" %% "scalacheck" % "1.13.4"
)

scalacOptions ++= Seq(
  "-Ypartial-unification"
)
