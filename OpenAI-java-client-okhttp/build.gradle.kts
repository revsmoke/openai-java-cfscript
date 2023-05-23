plugins {
    id("openai.kotlin")
    id("openai.publish")
}

dependencies {
    api(project(":OpenAI-java-core"))

    implementation("com.google.guava:guava:31.1-jre")
    implementation("com.squareup.okhttp3:okhttp:4.10.0")

    testImplementation(kotlin("test"))
    testImplementation("org.assertj:assertj-core:3.23.1")
    testImplementation("org.slf4j:slf4j-simple:1.7.29")
}
