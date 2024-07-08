import org.gradle.api.publish.PublishingExtension
import org.gradle.api.publish.maven.MavenPublication
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.register
import org.gradle.kotlin.dsl.get

plugins {
    `maven-publish`
    `signing`
}

configure<PublishingExtension> {
    publications {
        register<MavenPublication>("maven") {
            from(components["java"])

            pom {
                name.set("OpenAI API")
                description.set("The OpenAI REST API. Please see https://platform.openai.com/docs/api-reference\nfor more details.")
                url.set("https://platform.openai.com/docs")

                licenses {
                    license {
                        name.set("Apache-2.0")
                    }
                }

                developers {
                    developer {
                        name.set("OpenAI")
                        email.set("support@openai.com")
                    }
                }

                scm {
                    connection.set("scm:git:git://github.com/stainless-sdks/openai-java.git")
                    developerConnection.set("scm:git:git://github.com/stainless-sdks/openai-java.git")
                    url.set("https://github.com/stainless-sdks/openai-java")
                }

                versionMapping {
                    allVariants {
                        fromResolutionResult()
                    }
                }
            }
        }
    }
}

signing {
    val signingKeyId = System.getenv("GPG_SIGNING_KEY_ID")?.ifBlank { null }
    val signingKey = System.getenv("GPG_SIGNING_KEY")?.ifBlank { null }
    val signingPassword = System.getenv("GPG_SIGNING_PASSWORD")?.ifBlank { null }
    if (signingKey != null && signingPassword != null) {
        useInMemoryPgpKeys(
            signingKeyId,
            signingKey,
            signingPassword,
        )
        sign(publishing.publications["maven"])
    }
}

tasks.named("publish") {
    dependsOn(":closeAndReleaseSonatypeStagingRepository")
}
