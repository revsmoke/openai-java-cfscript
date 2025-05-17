/*
 * Plan: Methods to add in this CFScript wrapper
 *
 * 1. listModels - Retrieve list of available models
 * 2. retrieveModel - Get details of a specific model
 * 3. createCompletion - Wrap openAIClient.completions().create(...)
 * 4. createEdit - Wrap openAIClient.edits().create(...)
 * 5. createEmbedding - Wrap openAIClient.embeddings().create(...)
 * 6. createModeration - Wrap openAIClient.moderations().create(...)
 * 7. generateImage - Wrap openAIClient.images().generate(...)
 * 8. editImage - Wrap openAIClient.images().edit(...)
 * 9. createImageVariation - Wrap openAIClient.images().variation(...)
 * 10. transcribeAudio - Wrap openAIClient.audio().transcribe(...)
 * 11. translateAudio - Wrap openAIClient.audio().translate(...)
 * 12. createFineTune - Wrap openAIClient.fineTunes().create(...)
 * 13. listFineTunes / retrieveFineTune / cancelFineTune - Fine-tune management
 * 14. retrieveFile / deleteFile - File management endpoints
 * 15. retrieveUsage - Wrap openAIClient.usage().list(...) if supported
 *
 */
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
    public array function listFiles(numeric page = 1, numeric pageSize = 20) {
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

      /* ---------------------------------------------------------------------
     *  MODEL ENDPOINTS
     * -------------------------------------------------------------------*/

    public array function listModels() {
        try {
            var models = this.openAIClient.models().list(); // Java List<Model>  [oai_citation:0‡openai-java-sdk.devlive.org](https://openai-java-sdk.devlive.org/reference/openai/models.html?utm_source=chatgpt.com) [oai_citation:1‡GitHub](https://github.com/xrom888/openai-java-client?utm_source=chatgpt.com)
            var out = [];
            models.stream().forEach(function(m){
                arrayAppend(out,{
                    id        : m.getId(),
                    object    : m.getObject(),
                    created   : m.getCreated(),   // epoch
                    ownedBy   : m.getOwnedBy(),
                    root      : m.getRoot(),
                    parent    : m.getParent()
                });
            });
            return out;
        } catch (any e) {
            throw(type="APIError",
                  message="Unable to list OpenAI models: #e.message#",
                  detail=e);
        }
    }

    public struct function retrieveModel(required string modelId){
        try {
            var m = this.openAIClient.models().retrieve(arguments.modelId);  [oai_citation:2‡GitHub](https://github.com/xrom888/openai-java-client?utm_source=chatgpt.com)
            return {
                id       : m.getId(),
                object   : m.getObject(),
                created  : m.getCreated(),
                ownedBy  : m.getOwnedBy(),
                root     : m.getRoot(),
                parent   : m.getParent(),
                permission : m.getPermission() // returns Java List<Permission>
            };
        } catch (any e) {
            throw(type="APIError",
                  message="Unable to retrieve model #arguments.modelId#: #e.message#",
                  detail=e);
        }
    }

    /* ---------------------------------------------------------------------
     *  COMPLETIONS – legacy /text completions endpoint
     * -------------------------------------------------------------------*/

    public struct function createCompletion(required string prompt,
                                            string model="text-davinci-003",
                                            numeric maxTokens=256,
                                            numeric temperature=0.7){
        // load param builder class once
        if (!structKeyExists(variables,"CompletionCreateParamsClass")){
            variables.CompletionCreateParamsClass = createObject(
                    "java","com.openai.models.completions.CompletionCreateParams");  [oai_citation:3‡openai-java-sdk.devlive.org](https://openai-java-sdk.devlive.org/reference/openai/completions.html?utm_source=chatgpt.com)
        }

        var params = variables.CompletionCreateParamsClass.builder()
                        .prompt(arguments.prompt)
                        .model(arguments.model)
                        .maxTokens(arguments.maxTokens)
                        .temperature(javaCast("double",arguments.temperature))
                        .build();

        try {
            var comp = this.openAIClient.completions().create(params);  [oai_citation:4‡openai-java-sdk.devlive.org](https://openai-java-sdk.devlive.org/reference/openai/completions.html?utm_source=chatgpt.com)
            // map Java response to CF struct
            var choicesArr = [];
            comp.getChoices().stream().forEach(function(c){
                arrayAppend(choicesArr,{
                    index   : c.getIndex(),
                    text    : c.getText(),
                    logprobs: c.getLogprobs(),
                    finishReason : c.getFinishReason()
                });
            });
            return {
                id      : comp.getId(),
                created : comp.getCreated(),
                model   : comp.getModel(),
                usage   : comp.getUsage(),  // token counts
                choices : choicesArr
            };
        } catch (any e){
            throw(type="APIError",
                  message="Completion failed: #e.message#",
                  detail=e);
        }
    }

    /* ---------------------------------------------------------------------
     *  EMBEDDINGS
     * -------------------------------------------------------------------*/

    public struct function createEmbedding(required any input,
                                           string model="text-embedding-ada-002"){
        if (!structKeyExists(variables,"EmbeddingCreateParamsClass")){
            variables.EmbeddingCreateParamsClass = createObject(
                "java","com.openai.models.embeddings.EmbeddingCreateParams");  [oai_citation:5‡GitHub](https://github.com/ai-for-java/openai4j?utm_source=chatgpt.com) [oai_citation:6‡GitHub](https://github.com/openai/openai-java?utm_source=chatgpt.com)
        }

        // ensure input is a Java List<String>
        var jInput = createObject("java","java.util.ArrayList").init();
        if (isArray(input)){
            arrayEach(input,function(i){ jInput.add(i); });
        } else {
            jInput.add(input);
        }

        var params = variables.EmbeddingCreateParamsClass.builder()
                       .model(arguments.model)
                       .input(jInput)
                       .build();

        try{
            var emb = this.openAIClient.embeddings().create(params);  [oai_citation:7‡GitHub](https://github.com/ai-for-java/openai4j?utm_source=chatgpt.com)
            var vecs = [];
            emb.getData().stream().forEach(function(d){
                arrayAppend(vecs,{
                    index: d.getIndex(),
                    vector: d.getEmbedding().toArray() // double[]
                });
            });
            return {
                object : emb.getObject(),
                model  : emb.getModel(),
                usage  : emb.getUsage(),
                data   : vecs
            };
        } catch (any e){
            throw(type="APIError",
                  message="Embedding generation error: #e.message#",
                  detail=e);
        }
    }

    /* ---------------------------------------------------------------------
     *  MODERATIONS
     * -------------------------------------------------------------------*/

    public struct function createModeration(required any input,
                                            string model="text-moderation-latest"){
        if (!structKeyExists(variables,"ModerationCreateParamsClass")){
            variables.ModerationCreateParamsClass = createObject(
                "java","com.openai.models.moderations.ModerationCreateParams");  [oai_citation:8‡GitHub](https://github.com/ai-for-java/openai4j?utm_source=chatgpt.com)
        }

        var jInput = createObject("java","java.util.ArrayList").init();
        if (isArray(input)){
            arrayEach(input,function(i){ jInput.add(i); });
        } else {
            jInput.add(input);
        }

        var params = variables.ModerationCreateParamsClass.builder()
                       .model(arguments.model)
                       .input(jInput)
                       .build();

        try{
            var mod = this.openAIClient.moderations().create(params);  [oai_citation:9‡GitHub](https://github.com/ai-for-java/openai4j?utm_source=chatgpt.com)
            return {
                id     : mod.getId(),
                model  : mod.getModel(),
                results: mod.getResults().toArray()
            };
        } catch (any e){
            throw(type="APIError",
                  message="Moderation request failed: #e.message#",
                  detail=e);
        }
    }

    /* ---------------------------------------------------------------------
     *  IMAGE GENERATION
     * -------------------------------------------------------------------*/

    public struct function generateImage(required string prompt,
                                         numeric n=1,
                                         string size="1024x1024"){
        if (!structKeyExists(variables,"ImageGenerateParamsClass")){
            variables.ImageGenerateParamsClass = createObject(
                "java","com.openai.models.images.ImageGenerateParams");  [oai_citation:10‡GitHub](https://github.com/ai-for-java/openai4j?utm_source=chatgpt.com)
        }

        var params = variables.ImageGenerateParamsClass.builder()
                       .prompt(arguments.prompt)
                       .n(javaCast("int",arguments.n))
                       .size(arguments.size)
                       .build();

        try{
            var imgResp = this.openAIClient.images().generate(params);  [oai_citation:11‡GitHub](https://github.com/xrom888/openai-java-client?utm_source=chatgpt.com)
            var out = [];
            imgResp.getData().stream().forEach(function(d){
                arrayAppend(out,d.getUrl());
            });
            return {
                created : imgResp.getCreated(),
                urls    : out
            };
        } catch (any e){
            throw(type="APIError",
                  message="Image generation failed: #e.message#",
                  detail=e);
        }
    }

    /* ---------------------------------------------------------------------
     *  IMAGE EDIT & VARIATION
     * -------------------------------------------------------------------*/

    /**
     * Edit an existing image using an optional mask.
     * Wraps Java SDK:
     *   com.openai.models.images.ImageEditParams
     *   openAIClient.images().edit(params)
     *
     * @param imagePath (string): Path to the source image file.
     * @param maskPath  (string): Path to the mask image file (transparent areas show the original image).
     * @param prompt    (string): Instruction for editing the image.
     * @param n         (numeric): Number of images to generate (default 1).
     * @param size      (string): Image size, e.g. "1024x1024" (default).
     * @return Struct with created timestamp and array of URLs.
     */
    public struct function editImage(required string imagePath,
                                     required string maskPath,
                                     required string prompt,
                                     numeric n=1,
                                     string size="1024x1024"){ 
        // Load builder class for image edit parameters
        if (!structKeyExists(variables,"ImageEditParamsClass")){
            variables.ImageEditParamsClass = createObject(
                "java","com.openai.models.images.ImageEditParams");
        }

        // Build Java SDK ImageEditParams with file and mask paths
        var params = variables.ImageEditParamsClass.builder()
                       .image(createObject("java","java.nio.file.Paths")
                              .get(arguments.imagePath))
                       .mask(createObject("java","java.nio.file.Paths")
                             .get(arguments.maskPath))
                       .prompt(arguments.prompt)
                       .n(javaCast("int",arguments.n))
                       .size(arguments.size)
                       .build();

        try{
            // Invoke the Java SDK image edit endpoint
            var resp = this.openAIClient.images().edit(params);
            var urls = [];
            resp.getData().stream().forEach(function(d){
                arrayAppend(urls,d.getUrl());
            });
            return {
                created : resp.getCreated(),
                urls    : urls
            };
        } catch(any e){
            throw(type="APIError",
                  message="Image edit failed: #e.message#",
                  detail=e);
        }
    }

    /**
     * Create variations of an existing image.
     * Wraps Java SDK:
     *   com.openai.models.images.ImageCreateVariationParams
     *   openAIClient.images().variation(params)
     *
     * @param imagePath (string): Path to the source image file.
     * @param n         (numeric): Number of variations to generate.
     * @param size      (string): Image size, e.g. "1024x1024".
     * @return Struct with created timestamp and array of variation URLs.
     */
    public struct function createImageVariation(required string imagePath,
                                               numeric n=1,
                                               string size="1024x1024"){ 
        // Load builder class for image variation parameters
        if (!structKeyExists(variables,"ImageCreateVariationParamsClass")){
            variables.ImageCreateVariationParamsClass = createObject(
                "java","com.openai.models.images.ImageCreateVariationParams");
        }

        // Build Java SDK ImageCreateVariationParams with file path, count, and size
        var params = variables.ImageCreateVariationParamsClass.builder()
                       .image(createObject("java","java.nio.file.Paths")
                              .get(arguments.imagePath))
                       .n(javaCast("int",arguments.n))
                       .size(arguments.size)
                       .build();

        try{
            // Invoke the Java SDK image variation endpoint
            var resp = this.openAIClient.images().variation(params);
            var urls = [];
            resp.getData().stream().forEach(function(d){
                arrayAppend(urls,d.getUrl());
            });
            return {
                created : resp.getCreated(),
                urls    : urls
            };
        } catch(any e){
            throw(type="APIError",
                  message="Image variation failed: #e.message#",
                  detail=e);
        }
    }

    /* ---------------------------------------------------------------------
     *  AUDIO – Transcription & Translation
     * -------------------------------------------------------------------*/

    /**
     * Transcribe audio file using Whisper.
     * Wraps Java SDK:
     *   com.openai.models.audio.transcriptions.TranscriptionCreateParams
     *   openAIClient.audio().transcribe(params)
     *
     * @param filePath (string): Path to the audio file to transcribe.
     * @param model    (string): Whisper model to use (default "whisper-1").
     * @return Struct with transcription text.
     */
    public struct function transcribeAudio(required string filePath,
                                           string model="whisper-1"){ 
        // Load builder class for transcription parameters
        if (!structKeyExists(variables,"TranscriptionCreateParamsClass")){
            variables.TranscriptionCreateParamsClass = createObject(
                "java","com.openai.models.audio.transcriptions.TranscriptionCreateParams");
        }

        // Build Java SDK TranscriptionCreateParams with file path and model
        var params = variables.TranscriptionCreateParamsClass.builder()
                       .file(createObject("java","java.nio.file.Paths")
                             .get(arguments.filePath))
                       .model(arguments.model)
                       .build();

        try{
            // Invoke the Java SDK transcription endpoint
            var resp = this.openAIClient.audio().transcribe(params);
            return {
                transcription : resp.asTranscription().getText()
            };
        } catch(any e){
            throw(type="APIError",
                  message="Audio transcription failed: #e.message#",
                  detail=e);
        }
    }

    /**
     * Translate audio file to English.
     * Wraps Java SDK:
     *   com.openai.models.audio.translations.TranslationCreateParams
     *   openAIClient.audio().translate(params)
     *
     * @param filePath (string): Path to the audio file to translate.
     * @param model    (string): Whisper model to use for translation (default "whisper-1").
     * @return Struct with translated text.
     */
    public struct function translateAudio(required string filePath,
                                          string model="whisper-1"){ 
        // Load builder class for translation parameters
        if (!structKeyExists(variables,"TranslationCreateParamsClass")){
            variables.TranslationCreateParamsClass = createObject(
                "java","com.openai.models.audio.translations.TranslationCreateParams");
        }

        // Build Java SDK TranslationCreateParams with file path and model
        var params = variables.TranslationCreateParamsClass.builder()
                       .file(createObject("java","java.nio.file.Paths")
                             .get(arguments.filePath))
                       .model(arguments.model)
                       .build();

        try{
            // Invoke the Java SDK translation endpoint
            var resp = this.openAIClient.audio().translate(params);
            return {
                translation : resp.getText()
            };
        } catch(any e){
            throw(type="APIError",
                  message="Audio translation failed: #e.message#",
                  detail=e);
        }
    }

    /* ---------------------------------------------------------------------
     *  FINE-TUNING
     * -------------------------------------------------------------------*/

    /**
     * Create a fine-tuning job.
     * Wraps Java SDK:
     *   com.openai.models.finetuning.jobs.JobCreateParams
     *   openAIClient.fineTuning().create(params)
     *
     * @param trainingFile (string): ID of the training file.
     * @param model        (string): Base model to fine-tune (e.g., "davinci").
     * @return Struct with fine-tuning job metadata.
     */
    public struct function createFineTune(required string trainingFile,
                                         string model="davinci"){ 
        // Load builder class for fine-tune creation
        if (!structKeyExists(variables,"JobCreateParamsClass")){
            variables.JobCreateParamsClass = createObject(
                "java","com.openai.models.finetuning.jobs.JobCreateParams");
        }

        // Build Java SDK JobCreateParams with training file and model
        var params = variables.JobCreateParamsClass.builder()
                       .trainingFile(arguments.trainingFile)
                       .model(arguments.model)
                       .build();

        try{
            // Invoke the Java SDK fine-tuning create endpoint
            var job = this.openAIClient.fineTuning().create(params);
            return {
                id        : job.getId(),
                model     : job.getModel(),
                status    : job.getStatus(),
                createdAt : job.getCreatedAt()
            };
        } catch(any e){
            throw(type="APIError",
                  message="Fine-tune creation failed: #e.message#",
                  detail=e);
        }
    }

    /**
     * List fine-tuning jobs with pagination.
     * Wraps Java SDK:
     *   com.openai.models.finetuning.jobs.JobListParams
     *   openAIClient.fineTuning().list(params)
     *
     * @param after (string): cursor for pagination.
     * @param limit (numeric): how many records per page.
     * @return Array of job summaries.
     */
    public array function listFineTunes(string after, 
                                       numeric limit){ 
        // Load builder class for fine-tune listing
        if (!structKeyExists(variables,"JobListParamsClass")){
            variables.JobListParamsClass = createObject(
                "java","com.openai.models.finetuning.jobs.JobListParams");
        }
        var builder = variables.JobListParamsClass.builder();
        if (structKeyExists(arguments,"after")) builder.after(arguments.after);
        if (structKeyExists(arguments,"limit")) builder.limit(javaCast("int",arguments.limit));
        var params = builder.build();

        try{
            // Invoke the Java SDK fine-tuning list endpoint
            var page = this.openAIClient.fineTuning().list(params);
            var out = [];
            page.getData().stream().forEach(function(j){
                arrayAppend(out,{ 
                    id        : j.getId(),
                    model     : j.getModel(),
                    status    : j.getStatus(),
                    createdAt : j.getCreatedAt()
                });
            });
            return out;
        } catch(any e){
            throw(type="APIError",
                  message="Listing fine-tunes failed: #e.message#",
                  detail=e);
        }
    }

    /**
     * Retrieve a specific fine-tuning job.
     * Wraps Java SDK:
     *   com.openai.models.finetuning.jobs.JobRetrieveParams
     *   openAIClient.fineTuning().retrieve(params)
     *
     * @param jobId (string): ID of the fine-tune job.
     * @return Struct with job details.
     */
    public struct function retrieveFineTune(required string jobId){ 
        if (!structKeyExists(variables,"JobRetrieveParamsClass")){
            variables.JobRetrieveParamsClass = createObject(
                "java","com.openai.models.finetuning.jobs.JobRetrieveParams");
        }
        var params = variables.JobRetrieveParamsClass.builder()
                       .fineTuningJobId(arguments.jobId)
                       .build();
        try{
            var job = this.openAIClient.fineTuning().retrieve(params);
            return { 
                id            : job.getId(),
                model         : job.getModel(),
                status        : job.getStatus(),
                createdAt     : job.getCreatedAt(),
                fineTunedModel: job.getFineTunedModel().orElse(null)
            };
        } catch(any e){
            throw(type="APIError",
                  message="Retrieve fine-tune failed: #e.message#",
                  detail=e);
        }
    }

    /**
     * Cancel a fine-tuning job.
     * Wraps Java SDK:
     *   com.openai.models.finetuning.jobs.JobCancelParams
     *   openAIClient.fineTuning().cancel(params)
     *
     * @param jobId (string): ID of the fine-tune job to cancel.
     * @return Struct with updated job status.
     */
    public struct function cancelFineTune(required string jobId){ 
        if (!structKeyExists(variables,"JobCancelParamsClass")){
            variables.JobCancelParamsClass = createObject(
                "java","com.openai.models.finetuning.jobs.JobCancelParams");
        }
        var params = variables.JobCancelParamsClass.builder()
                       .fineTuningJobId(arguments.jobId)
                       .build();
        try{
            var job = this.openAIClient.fineTuning().cancel(params);
            return { 
                id     : job.getId(),
                status : job.getStatus()
            };
        } catch(any e){
            throw(type="APIError",
                  message="Cancel fine-tune failed: #e.message#",
                  detail=e);
        }
    }

    /* ---------------------------------------------------------------------
     *  FILE MANAGEMENT – retrieve & delete
     * -------------------------------------------------------------------*/

    /**
     * Retrieve metadata for an uploaded file.
     * Wraps Java SDK:
     *   com.openai.models.files.FileRetrieveParams
     *   openAIClient.files().retrieve(params)
     *
     * @param fileId (string): The ID of the file.
     * @return Struct with file metadata.
     */
    public struct function retrieveFile(required string fileId){ 
        if (!structKeyExists(variables,"FileRetrieveParamsClass")){
            variables.FileRetrieveParamsClass = createObject(
                "java","com.openai.models.files.FileRetrieveParams");
        }
        var params = variables.FileRetrieveParamsClass.builder()
                       .fileId(arguments.fileId)
                       .build();
        try{
            var f = this.openAIClient.files().retrieve(params);
            return { 
                id         : f.getId(),
                bytes      : f.getBytes(),
                createdAt  : f.getCreatedAt(),
                filename   : f.getFilename(),
                object     : f.getObject(),
                purpose    : f.getPurpose(),
                status     : f.getStatus(),
                expiresAt  : f.getExpiresAt().orElse(null)
            };
        } catch(any e){
            throw(type="APIError",
                  message="Retrieve file failed: #e.message#",
                  detail=e);
        }
    }

    /**
     * Delete a file.
     * Wraps Java SDK:
     *   com.openai.models.files.FileDeleteParams
     *   openAIClient.files().delete(params)
     *
     * @param fileId (string): The ID of the file to delete.
     * @return Boolean indicating deletion success.
     */
    public boolean function deleteFile(required string fileId){ 
        if (!structKeyExists(variables,"FileDeleteParamsClass")){
            variables.FileDeleteParamsClass = createObject(
                "java","com.openai.models.files.FileDeleteParams");
        }
        var params = variables.FileDeleteParamsClass.builder()
                       .fileId(arguments.fileId)
                       .build();
        try{
            var resp = this.openAIClient.files().delete(params);
            return resp.getDeleted();
        } catch(any e){
            throw(type="APIError",
                  message="Delete file failed: #e.message#",
                  detail=e);
        }
    }

    /**
     * Retrieve usage statistics (not yet supported by upstream Java SDK).
     */
    public any function retrieveUsage(){
        throw(type="APIError",
              message="Usage API not supported by current Java SDK");
    }
}
