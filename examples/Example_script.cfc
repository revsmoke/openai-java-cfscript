component {
    public void function run() {
        var wrapper = new OpenAIWrapper(apiKey="YOUR_KEY");
        try {
            var result = wrapper.createChatCompletion([
                {role="user", content="Hello from script"}
            ]);
            writeDump(result);
        } catch(any e) {
            writeDump(e);
        }
    }
}
