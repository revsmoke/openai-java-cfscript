component displayname="OpenAIWrapper" hint="CFML stub for IDE autocompletion" {
    /**
     * @hint Initializes the wrapper
     * @param apiKey The OpenAI API key
     */
    function init(string apiKey) returns OpenAIWrapper {}

    /** @hint Create a chat completion */
    function createChatCompletion(array messages) returns struct {}

    /** @hint Moderate content */
    function createModeration(any input) returns struct {}
}
