package com.github.yahorbarkouski.chatgpt.boot.config

import com.github.yahorbarkouski.chatgpt.core.ChatGptClient
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Suppress("SpringFacetCodeInspection")
@Configuration
@EnableConfigurationProperties(ChatGptProperties::class)
@ConditionalOnProperty(prefix = "openai.chatgpt", name = ["token"])
class ChatGptAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    fun chatGptClient(properties: ChatGptProperties): ChatGptClient = ChatGptClient(properties.token)
}
