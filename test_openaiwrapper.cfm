<cfscript>
// Edit this with your actual OpenAI API key
apiKey = "YOUR_OPENAI_API_KEY_HERE";

// Include the wrapper
wrapper = new OpenAIWrapper(apiKey=apiKey);

// Initialize result variables
modelsResult = "";
completionResult = "";
errorMsg = "";

if (structKeyExists(form, "action")) {
    try {
        if (form.action == "listModels") {
            if (structKeyExists(wrapper, "listModels")) {
                modelsResult = wrapper.listModels();
            } else {
                errorMsg = "listModels() is not implemented in the wrapper.";
            }
        } else if (form.action == "createCompletion") {
            if (structKeyExists(wrapper, "createCompletion")) {
                completionResult = wrapper.createCompletion(
                    prompt=form.prompt,
                    model="text-davinci-003",
                    maxTokens=50
                );
            } else {
                errorMsg = "createCompletion() is not implemented in the wrapper.";
            }
        }
    } catch (any e) {
        errorMsg = e.message & "<br>" & e.detail;
    }
}
</cfscript>

<html>
<head>
    <title>OpenAIWrapper.cfc Test Page</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 2em; }
        .result { background: #f4f4f4; padding: 1em; border-radius: 6px; margin-top: 1em; }
        .error { color: #b00; font-weight: bold; }
    </style>
</head>
<body>
    <h1>Test OpenAIWrapper.cfc</h1>
    <form method="post">
        <input type="hidden" name="action" value="createCompletion" />
        <label>Prompt for Completion:<br>
            <textarea name="prompt" rows="3" cols="60">Say hello from ColdFusion!</textarea>
        </label><br>
        <button type="submit">Test createCompletion</button>
    </form>
    <form method="post" style="margin-top:2em;">
        <input type="hidden" name="action" value="listModels" />
        <button type="submit">Test listModels</button>
    </form>

    <cfif len(errorMsg)>
        <div class="error">#errorMsg#</div>
    </cfif>

    <cfif isStruct(completionResult)>
        <div class="result">
            <h2>Completion Result</h2>
            <pre>#serializeJSON(completionResult)#</pre>
        </div>
    </cfif>

    <cfif isArray(modelsResult) || isStruct(modelsResult)>
        <div class="result">
            <h2>Models Result</h2>
            <pre>#serializeJSON(modelsResult)#</pre>
        </div>
    </cfif>
</body>
</html>
