# ChatGPT Kotlin SDK

> This SDK provides a Kotlin API for the OpenAI Chat API powered by GPT. With this SDK, you can easily integrate OpenAI chat capabilities into your Kotlin applications.

## Requirements

- JDK 11 or later
- API key from OpenAI 

## Installation

The SDK can be installed using Gradle or Maven.

### Gradle
Add the following to your build.gradle file:

```gradle
dependencies {
    implementation 'com.github.yahorbarkouski:chatgpt-kotlin:1.0.0'
}
```

### Maven
Add the following to your pom.xml file:
```maven
<dependency>
    <groupId>com.github.yahorbarkouski</groupId>
    <artifactId>chatgpt-kotlin/artifactId>
    <version>1.0.0</version>
</dependency>
```

## Usage

The SDK provides a ChatGptClient class that can be used to interact with the OpenAI chat API. Here is an example of how to use the SDK:

```kotlin
import com.github.yahorbarkouski.chatgpt.ChatGptClient
import com.github.yahorbarkouski.chatgpt.ChatModel
import com.github.yahorbarkouski.chatgpt.ChatMessage

fun main() {
    val apiKey = "your-api-key-here"
    val client = ChatGptClient(apiKey)

    val messages = listOf(
        ChatMessage("user", "Hello!"),
        ChatMessage("system", "Hi, how can I help you today?")
    )

    val response = client.complete(messages, ChatModel.GPT_3_5_TURBO)

    if (response.isSuccessful) {
        val result = response.body()!!.choices.first().text
        println("Response: $result")
    } else {
        println("Error: ${response.message()}")
    }
}
```

## Contributing

Contributions to this project are welcome. If you find a bug or want to add a feature, please open an issue or submit a pull request.

## License

This project is licensed under the MIT License.