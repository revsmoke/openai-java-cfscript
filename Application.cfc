<cfscript>
// Application.cfc for OpenAI Java integration
THIS.name = "OpenAIJavaCFScriptApp";
THIS.javaSettings = {
    loadPaths = [expandPath("./java_lib")],
    loadColdFusionClassPath = true,
    reloadOnChange = true // set to false in production
};
</cfscript>
