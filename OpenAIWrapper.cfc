component accessors="true" output="false" {

    // Java Classes
    private any openAIClient;
    private string apiKey;

    /**
     * Constructor
     * Initializes the OpenAI client using the provided API key.
     *
     * @param apiKey (string): Your OpenAI API key.
     * @return OpenAIWrapper: The initialized instance of the wrapper.
     */
    public OpenAIWrapper function init(required string apiKey) {
        this.apiKey = arguments.apiKey;

        // Load Java SDK classes
        variables.OpenAIClientClass = createObject("java", "com.openai.client.OpenAIClient");
        variables.OpenAIOkHttpClientClass = createObject("java", "com.openai.client.okhttp.OpenAIOkHttpClient");
        variables.ResponseCreateParamsClass = createObject("java", "com.openai.models.responses.ResponseCreateParams");
        variables.ChatModelClass = createObject("java", "com.openai.models.ChatModel");

        // Initialize OpenAI client
        try {
            this.openAIClient = variables.OpenAIOkHttpClientClass.fromEnv();
        } catch (any e) {
            throw(type="InitializationError", message="Failed to initialize OpenAI client: " & e.message, detail=e);
        }

        return this;
    }

    /**
     * Call OpenAI Response API
     * Generates a response based on the given input.
     *
     * @param input (string): The input prompt for generating a response.
     * @param model (string): The model to use (default is "gpt-4").
     * @return Struct: OpenAI API response including id, output, and other details.
     *
     * @throws APIError: If the API call fails.
     */
    public struct function getResponse(required string input, string model = "gpt-4") {
        // Create a ResponseCreateParams object
        var responseParams = variables.ResponseCreateParamsClass.builder()
            .input(arguments.input)
            .model(variables.ChatModelClass.of(arguments.model))
            .build();

        // Call OpenAI Response API and handle errors
        try {
            var response = this.openAIClient.responses().create(responseParams);
        } catch (any e) {
            throw(type="APIError", message="Error calling OpenAI Response API: " & e.message, detail=e);
        }

        // Convert the response to a CFML struct
        return {
            id: response.getId(),
            model: response.getModel(),
            output: response.getOutput().toArray()
        };
    }
}
