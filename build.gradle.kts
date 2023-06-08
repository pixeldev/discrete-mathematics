import com.diffplug.gradle.spotless.FormatExtension

plugins {
  `java-library`
  id("net.kyori.indra") version "3.0.1"
  id("net.kyori.indra.checkstyle") version "3.0.1"
  id("com.diffplug.spotless") version "6.18.0"
}

indra {
  javaVersions {
    target(17)
    minimumToolchain(17)
  }

  checkstyle("10.8.0")
}

dependencies {
  checkstyle("ca.stellardrift:stylecheck:0.2.0")
  compileOnly("org.jetbrains:annotations:24.0.0")
}

spotless {
  fun FormatExtension.applyCommon() {
    trimTrailingWhitespace()
    indentWithSpaces(2)
    endWithNewline()
  }
  java {
    importOrder("", "\\#")
    removeUnusedImports()
    applyCommon()
  }
  kotlinGradle {
    applyCommon()
  }
}

repositories {
  mavenLocal()
  mavenCentral()
}

tasks {
  compileJava {
    dependsOn("spotlessApply")
    options.compilerArgs.add("-parameters")
  }

  jar {
    manifest {
      attributes["Main-Class"] = "com.pixeldv.discretes.Relations"
    }
  }
}
