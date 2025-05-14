component accessors="true" output="false" {
    // Java Classes
    private any openAIClient;
    private string apiKey;

    // Constructor
    public OpenAIWrapper function init(required string apiKey) {
        this.apiKey = arguments.apiKey;

        // Load Java SDK classes
        variables.OpenAIServiceClass = createObject("java", "com.theokanning.openai.service.OpenAiService");
        variables.RequestClass = createObject("java", "com.theokanning.openai.completion.CompletionRequest");

        // Initialize OpenAI client
        this.openAIClient = variables.OpenAIServiceClass.init(apiKey);

        return this;
    }

    /**
     * Call OpenAI Completion API
     * @param prompt (string): The input prompt for generating a response.
     * @param model (string): The model to use (e.g., "text-davinci-003").
     * @param maxTokens (numeric): The maximum number of tokens to generate.
     * @return Struct: OpenAI API response
     */
    public struct function getCompletion(required string prompt, string model = "text-davinci-003", numeric maxTokens = 100) {
        // Create a CompletionRequest
        var request = variables.RequestClass.init();
        request.setPrompt(arguments.prompt);
        request.setModel(arguments.model);
        request.setMaxTokens(arguments.maxTokens);

        // Call OpenAI API
        var response = this.openAIClient.createCompletion(request);

        // Return the result as a CFML struct
        return {
            id: response.getId(),
            created: response.getCreated(),
            model: response.getModel(),
            choices: response.getChoices().toArray()
        };
    }
}
