plugins {
    id("openai.kotlin")
    id("openai.publish")
}

dependencies {
    api(project(":openai-java-client-okhttp"))
}
