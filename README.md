# OpenAI Java API Library

[![Maven Central](https://img.shields.io/maven-central/v/com.openai.api/openai-java)](https://central.sonatype.com/artifact/com.openai.api/openai-java/0.0.1)

The OpenAI Java SDK provides convenient access to the OpenAI REST API from applications written in Java. It includes helper classes with helpful types and documentation for every request and response property.

This package is currently in beta (pre-v1.0.0). We expect some breaking changes to rarely-used areas of the SDK, and appreciate your [feedback](mailto:support@openai.com).

The OpenAI Java SDK is similar to the OpenAI Kotlin SDK but with minor differences that make it more ergonomic for use in Java, such as `Optional` instead of nullable values, `Stream` instead of `Sequence`, and `CompletableFuture` instead of suspend functions.

## Documentation

The API documentation can be found [here](https://beta.openai.com/docs/).

---

## Getting started

### Install dependencies

#### Gradle

```kotlin
implementation("com.openai.api:openai-java:0.0.1")
```

#### Maven

```xml
<dependency>
    <groupId>com.openai.api</groupId>
    <artifactId>openai-java</artifactId>
    <version>0.0.1</version>
</dependency>
```

### Configure the client

Use `OpenAiOkHttpClient.builder()` to configure the client. At a minimum you need to set `.apiKey()`:

```java
import com.openai.api.client.OpenAiClient;
import com.openai.api.client.okhttp.OpenAiOkHttpClient;

OpenAiClient client = OpenAiOkHttpClient.builder()
    .apiKey("<your API Key>")
    .build();
```

Alternately, set the environment variable `OPENAI_API_KEY` and use `OpenAiOkHttpClient.fromEnv()`:

```java
OpenAiClient client = OpenAiOkHttpClient.fromEnv();
```

Read the documentation for more configuration options.

---

### Example: creating a resource

To create a new completion, first use the `CompletionCreateParams` builder to specify attributes,
then pass that to the `create` method of the `completions` service.

```java
import com.openai.api.models.Completion;
import com.openai.api.models.CompletionCreateParams;

CompletionCreateParams params = CompletionCreateParams.builder()
    .model("text-davinci-002")
    .prompt("Say this is a test")
    .maxTokens(6)
    .temperature(0)
    .build();
Completion completion = client.completions().create(params);
```

---

## Requests

### Parameters and bodies

To make a request to the OpenAI API, you generally build an instance of the appropriate `Params` class.

In [Example: creating a resource](#example-creating-a-resource) above, we used the `CompletionCreateParams.builder()` to pass to
the `create` method of the `completions` service.

Sometimes, the API may support other properties that are not yet supported in the Java SDK types. In that case,
you can attach them using the `putAdditionalProperty` method.

```java
CompletionCreateParams params = CompletionCreateParams.builder()
    // ... normal properties
    .putAdditionalProperty("secret_param", "4242")
    .build();
```

## Responses

### Response validation

When receiving a response, the OpenAI Java SDK will deserialize it into instances of the typed model classes. In rare cases, the API may return a response property that doesn't match the expected Java type. If you directly access the mistaken property, the SDK will throw an unchecked `OpenAiInvalidDataException` at runtime. If you would prefer to check in advance that that response is completely well-typed, call `.validate()` on the returned model.

```java
Completion completion = client.completions().create().validate();
```

### Response properties as JSON

In rare cases, you may want to access the underlying JSON value for a response property rather than using the typed version provided by
this SDK. Each model property has a corresponding JSON version, with an underscore before the method name, which returns a `JsonField` value.

```java
JsonField field = responseObj._field();

if (field.isMissing()) {
  // Value was not specified in the JSON response
} else if (field.isNull()) {
  // Value was provided as a literal null
} else {
  // See if value was provided as a string
  Optional<String> jsonString = field.asString();

  // If the value given by the API did not match the shape that the SDK expects
  // you can deserialise into a custom type
  MyClass myObj = responseObj._field().asUnknown().orElseThrow().convert(MyClass.class);
}
```

### Additional model properties

Sometimes, the server response may include additional properties that are not yet available in this library's types. You can access them using the model's `_additionalProperties` method:

```java
JsonValue secret = completion._additionalProperties().get("secret_field");
```

---

---

## Error handling

This library throws exceptions in a single hierarchy for easy handling:

- **`OpenAiException`** - Base exception for all exceptions

  - **`OpenAiServiceException`** - HTTP errors with a well-formed response body we were able to parse. The exception message and the `.debuggingRequestId()` will be set by the server.

    | 400    | BadRequestException           |
    | ------ | ----------------------------- |
    | 401    | AuthenticationException       |
    | 403    | PermissionDeniedException     |
    | 404    | NotFoundException             |
    | 422    | UnprocessableEntityException  |
    | 429    | RateLimitException            |
    | 5xx    | InternalServerException       |
    | others | UnexpectedStatusCodeException |

  - **`OpenAiIoException`** - I/O networking errors
  - **`OpenAiInvalidDataException`** - any other exceptions on the client side, e.g.:
    - We failed to serialize the request body
    - We failed to parse the response body (has access to response code and body)

## Network options

### Retries

Requests that experience certain errors are automatically retried 2 times by default, with a short exponential backoff. Connection errors (for example, due to a network connectivity problem), 409 Conflict, 429 Rate Limit, and >=500 Internal errors will all be retried by default.
You can provide a `maxRetries` on the client builder to configure this:

```java
OpenAiClient client = OpenAiOkHttpClient.builder()
    .fromEnv()
    .maxRetries(4)
    .build();
```

### Timeouts

Requests time out after 60 seconds by default. You can configure this on the client builder:

```java
OpenAiClient client = OpenAiOkHttpClient.builder()
    .fromEnv()
    .timeout(Duration.ofSeconds(30))
    .build();
```

### Proxies

Requests can be routed through a proxy. You can configure this on the client builder:

```java
OpenAiClient client = OpenAiOkHttpClient.builder()
    .fromEnv()
    .proxy(new Proxy(
        Type.HTTP,
        new InetSocketAddress("proxy.com", 8080)
    ))
    .build();
```