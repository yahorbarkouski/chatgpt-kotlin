package com.github.yahorbarkouski.chatgpt.boot.config

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "openai.chatgpt")
data class ChatGptProperties(
    val token: String,
)
