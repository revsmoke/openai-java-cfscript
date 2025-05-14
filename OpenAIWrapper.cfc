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
        variables.FileCreateParamsClass = createObject("java", "com.openai.models.files.FileCreateParams");

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
     */
    public struct function getResponse(required string input, string model = "gpt-4") {
        var responseParams = variables.ResponseCreateParamsClass.builder()
            .input(arguments.input)
            .model(variables.ChatModelClass.of(arguments.model))
            .build();

        try {
            var response = this.openAIClient.responses().create(responseParams);
        } catch (any e) {
            throw(type="APIError", message="Error calling OpenAI Response API: " & e.message, detail=e);
        }

        return {
            id: response.getId(),
            model: response.getModel(),
            output: response.getOutput().toArray()
        };
    }

    /**
     * Upload a file to OpenAI
     *
     * @param filePath (string): The local file path to upload.
     * @param purpose (string): The purpose of the file (e.g., "fine-tune").
     * @return Struct: OpenAI API response including file details.
     */
    public struct function uploadFile(required string filePath, required string purpose) {
        var fileParams = variables.FileCreateParamsClass.builder()
            .file(createObject("java", "java.nio.file.Paths").get(arguments.filePath))
            .purpose(arguments.purpose)
            .build();

        try {
            var response = this.openAIClient.files().create(fileParams);
        } catch (any e) {
            throw(type="APIError", message="Error uploading file: " & e.message, detail=e);
        }

        return {
            id: response.getId(),
            object: response.getObject(),
            purpose: response.getPurpose()
        };
    }

    /**
     * Call OpenAI Response API asynchronously
     *
     * @param input (string): The input prompt for generating a response.
     * @param model (string): The model to use (default is "gpt-4").
     * @return java.util.concurrent.CompletableFuture: Asynchronous response future.
     */
    public any function getResponseAsync(required string input, string model = "gpt-4") {
        var responseParams = variables.ResponseCreateParamsClass.builder()
            .input(arguments.input)
            .model(variables.ChatModelClass.of(arguments.model))
            .build();

        try {
            return this.openAIClient.responses().createAsync(responseParams);
        } catch (any e) {
            throw(type="APIError", message="Error calling OpenAI Response API asynchronously: " & e.message, detail=e);
        }
    }

    /**
     * Call OpenAI Response API with streaming
     *
     * @param input (string): The input prompt for generating a response.
     * @param model (string): The model to use (default is "gpt-4").
     * @return void: Streams the response chunks to the output.
     */
    public void function getStreamingResponse(required string input, string model = "gpt-4") {
        var responseParams = variables.ResponseCreateParamsClass.builder()
            .input(arguments.input)
            .model(variables.ChatModelClass.of(arguments.model))
            .build();

        try {
            var streamResponse = this.openAIClient.responses().createStreaming(responseParams);
            streamResponse.stream().forEach(function(chunk) {
                writeOutput(chunk.toString());
            });
        } catch (any e) {
            throw(type="APIError", message="Error streaming response: " & e.message, detail=e);
        }
    }

    /**
     * List files with pagination
     *
     * @param page (numeric): The page number to fetch.
     * @param pageSize (numeric): The number of files per page.
     * @return array: List of files.
     */
    public array function listFiles(optional numeric page = 1, optional numeric pageSize = 20) {
        try {
            var files = this.openAIClient.files().list(page, pageSize);
            return files.stream().map(function(file) {
                return {
                    id: file.getId(),
                    name: file.getName(),
                    size: file.getSize()
                };
            }).toArray();
        } catch (any e) {
            throw(type="APIError", message="Error listing files: " & e.message, detail=e);
        }
    }

    /**
     * Fetch raw HTTP response
     *
     * @param input (string): The input prompt for generating a response.
     * @param model (string): The model to use (default is "gpt-4").
     * @return Struct: Raw HTTP response details.
     */
    public struct function getRawResponse(required string input, string model = "gpt-4") {
        var responseParams = variables.ResponseCreateParamsClass.builder()
            .input(arguments.input)
            .model(variables.ChatModelClass.of(arguments.model))
            .build();

        try {
            var rawResponse = this.openAIClient.responses().withRawResponse().create(responseParams);
            return {
                statusCode: rawResponse.statusCode(),
                headers: rawResponse.headers().toMap(),
                body: rawResponse.body()
            };
        } catch (any e) {
            throw(type="APIError", message="Error fetching raw response: " & e.message, detail=e);
        }
    }
}
