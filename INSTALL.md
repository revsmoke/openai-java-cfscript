# Installation Guide

This document explains how to integrate the OpenAI Java SDK into a ColdFusion application using the provided CFScript wrapper.

## Requirements

* **Java 17 or higher** – Adobe ColdFusion 2021/2023 and Lucee 6+ work best with a modern JDK.
* **Internet access** to download dependencies or the pre-built JAR.

## Option 1 – Auto-compile from Source

1. Clone this repository and open a terminal in the project root.
2. Run the Gradle build to assemble the SDK:

   ```bash
   ./gradlew :openai-java-client-okhttp:jar
   ```

   The compiled `openai-java-client-okhttp-<version>.jar` will be found under `openai-java-client-okhttp/build/libs/`.
3. Copy that JAR into either:
   * your ColdFusion installation's `cfusion/lib` directory, or
   * an application-specific `lib/` folder referenced in `this.javaSettings.loadPaths`.

## Option 2 – Use the Pre-built JAR

Download the latest stable release directly from Maven Central:

```
https://repo1.maven.org/maven2/com/openai/openai-java-client-okhttp/1.6.1/openai-java-client-okhttp-1.6.1.jar
```

Save this file into your chosen `lib/` directory.

## ColdFusion Administrator Settings

1. **Java & JVM → Java Virtual Machine Path** – point to your Java 17 (or newer) JDK installation.
2. **Java & JVM → Class Path** – add the path to the downloaded JAR if you place it in `cfusion/lib`. Alternatively, configure `this.javaSettings.loadPaths` in `Application.cfc`:

   ```cfml
   this.javaSettings = {
       loadPaths = [ expandPath("./lib") ],
       loadColdFusionClassPath = true
   };
   ```
3. No special JVM flags are required, but you may adjust heap memory to handle large requests.

## One‑Minute Setup Script

Place the snippet below inside a `.cfm` file and run it once. It downloads the JAR, updates the application load path and performs a simple API call.

```cfml
<cfscript>
url = "https://repo1.maven.org/maven2/com/openai/openai-java-client-okhttp/1.6.1/openai-java-client-okhttp-1.6.1.jar";
jarPath = expandPath("./lib/openai-java-client-okhttp-1.6.1.jar");

if (!fileExists(jarPath)) {
    fileWrite(jarPath, binaryDecode( toBinary( httpGet(url).filecontent ), "hex" ));
}

this.javaSettings = {
    loadPaths = [ getDirectoryFromPath(jarPath) ],
    loadColdFusionClassPath = true
};

wrapper = new OpenAIWrapper(apiKey="YOUR_OPENAI_KEY");
writeDump( wrapper.listModels() );
</cfscript>
```

If you see a structured list of models, the installation succeeded.

## Rollback

Simply remove the JAR from your `lib/` directory and restart ColdFusion.
