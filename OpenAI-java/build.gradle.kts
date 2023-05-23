plugins {
    id("openai.kotlin")
    id("openai.publish")
}

dependencies {
    api(project(":OpenAI-java-client-okhttp"))
}
