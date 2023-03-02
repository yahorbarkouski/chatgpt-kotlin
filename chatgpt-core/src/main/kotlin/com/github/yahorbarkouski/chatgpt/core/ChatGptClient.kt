package com.github.yahorbarkouski.chatgpt.core

import com.github.yahorbarkouski.chatgpt.core.request.ChatMessage
import com.github.yahorbarkouski.chatgpt.core.request.ChatModel
import com.github.yahorbarkouski.chatgpt.core.request.ChatRequest
import com.github.yahorbarkouski.chatgpt.core.response.ChatResponse
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ChatGptClient(apiKey: String) {

    private val httpClient = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val request = chain.request()
                .newBuilder()
                .addHeader("Authorization", "Bearer $apiKey")
                .build()
            chain.proceed(request)
        }
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.openai.com/v1/")
        .client(httpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val apiService = retrofit.create(ChatGptApiService::class.java)

    fun complete(message: ChatMessage, model: ChatModel = ChatModel.GPT_3_5_TURBO): Response<ChatResponse> {
        return complete(listOf(message), model)
    }

    fun complete(messages: List<ChatMessage>, model: ChatModel = ChatModel.GPT_3_5_TURBO): Response<ChatResponse> {
        val requestBody = ChatRequest(model = model.id, messages = messages)
        return apiService.complete(requestBody).execute()
    }
}
