<!--- Simple tag-based example using OpenAIWrapper --->
<cfset wrapper = createObject("component", "OpenAIWrapper").init(apiKey="YOUR_KEY")>

<cftry>
    <cfset result = wrapper.createChatCompletion([
        {role="user", content="Say hello"}
    ])>
    <cfdump var="#result#">
    <cfcatch>
        <cfdump var="#cfcatch#" label="Error">
    </cfcatch>
</cftry>
