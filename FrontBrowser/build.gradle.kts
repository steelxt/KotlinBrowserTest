import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val kotlin_version = "1.3.50"
val kotlinx_html_version = "0.6.12"

val react_version = "16.9.0-pre.83-kotlin-$kotlin_version"
val react_dom_version = "16.9.0-pre.83-kotlin-$kotlin_version"
val serialization_version = "0.12.0"
val kotlin_styled_version = "1.0.0-pre.83-kotlin-$kotlin_version"
val react_router_dom_version = "4.3.1-pre.83-kotlin-$kotlin_version"

plugins {
    kotlin("js") version "1.3.50"
    id("kotlin-dce-js") version "1.3.50"
   // id("kotlinx-serialization") version "1.3.50"
    idea
}


repositories {
    mavenLocal()
    mavenCentral()
    maven("https://kotlin.bintray.com/kotlin-js-wrappers")
    maven("https://kotlin.bintray.com/ktor")
    maven { setUrl("https://jcenter.bintray.com/") }
    maven { setUrl("https://dl.bintray.com/kotlin/kotlin-eap") }
    maven { setUrl("https://kotlin.bintray.com/kotlinx") }
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

kotlin{
    target {
        browser {
            val main by compilations.getting {
                kotlinOptions {
                    sourceMap = true
                    moduleKind = "commonjs"
                    sourceMapEmbedSources = "always"
                    main="call"
                    outputFile = "${project.buildDir.path}/js/${project.name}.js"
                }
            }

            webpackTask {
                runTask {
                    println("$projectDir/src/main/resources")
                    devServer = devServer?.copy(
                        port = 3000,
                       // proxy =  mapOf("/dashboard" to  "http://0.0.0.0:8080"),
                        contentBase = listOf("$projectDir/src/main/resources")


                    )


                }

                archiveFileName = "frontbrowser.js"
                report = true
                saveEvaluatedConfigFile = true
                sourceMaps = true
            }
        }
    }

    sourceSets["main"].dependencies {
        implementation(kotlin("stdlib-js"))
        implementation("org.jetbrains.kotlinx:kotlinx-html-js:$kotlinx_html_version")
        implementation("org.jetbrains:kotlin-react:$react_version")
        implementation("org.jetbrains:kotlin-react-dom:$react_dom_version")
        implementation("org.jetbrains:kotlin-styled:$kotlin_styled_version")
        implementation("org.jetbrains:kotlin-react-router-dom:$react_router_dom_version")
        implementation(npm("core-js"))
        implementation(npm("text-encoding"))
        implementation(npm("css-loader"))
        implementation(npm("style-loader"))
        implementation(npm("react"))
        implementation(npm("react-dom"))
        implementation(npm("react-router-dom"))
    }


}