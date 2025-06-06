<cfscript>
// Application.cfc for OpenAI Java integration
THIS.name = "OpenAIJavaCFScriptApp";
THIS.javaSettings = {
    loadPaths = [ expandPath("./lib") ],
    loadColdFusionClassPath = true,
    reloadOnChange = true // disable in production
};
</cfscript>
