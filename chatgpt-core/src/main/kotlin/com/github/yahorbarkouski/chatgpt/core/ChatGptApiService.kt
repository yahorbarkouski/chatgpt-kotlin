package com.github.yahorbarkouski.chatgpt.core

import com.github.yahorbarkouski.chatgpt.core.request.ChatRequest
import com.github.yahorbarkouski.chatgpt.core.response.ChatResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

internal interface ChatGptApiService {

    @Headers("Content-Type: application/json")
    @POST("chat/completions")
    fun complete(@Body request: ChatRequest): Call<ChatResponse>
}
