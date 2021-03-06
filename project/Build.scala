import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

  val appName = "play-blog"
  val appVersion = "1.0-SNAPSHOT"

  val appDependencies = Seq("org.scalacheck" %% "scalacheck" % "1.9" % "test")

  val main = PlayProject(appName, appVersion, appDependencies, mainLang = SCALA).settings(
    routesImport ++= Seq("events.PostId", "support.Binders._"),
    templatesImport ++= Seq("events._"),
    lessEntryPoints <<= (sourceDirectory in Compile)(base => (
      (base / "assets" / "stylesheets" / "bootstrap" / "bootstrap.less") +++
      (base / "assets" / "stylesheets" / "bootstrap" / "responsive.less"))))

}
