package com.pdt.blockchainid.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

// Sington Pattern
object RetrofitClient {
    // lay token trong bo nho
    private const val TOKEN = "7T5YAtqPI8e642k0bwyPpTy2j6TsCm7l"
    private const val BASE_URL = "https://api.fpt.ai/"
//    private const val BASE_URL = "https://mocki.io/"
    // create logger
    private val logger = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    // create OkHttpClient
    //Cu
    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(logger)
        .addInterceptor { chain ->
            val original = chain.request()
            val requestBuilder = original.newBuilder()
                .addHeader("api_key", TOKEN)
            val request = requestBuilder.build()
            chain.proceed(request)
        }.build()

    val instance: ApiServices by lazy{
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .build()
        retrofit.create(ApiServices::class.java)
    }
}

object RetrofitServer {
    // lay token trong bo nho
//    private const val TOKEN = "Client-ID ${Constant.TOKEN_UNSPLASH}"
    private const val BASE_URL = "http://192.168.1.12:3000/"
    // create logger
    private val logger = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    // create OkHttpClient
    //Cu
    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(logger)
        .connectTimeout(30, TimeUnit.SECONDS) // Thời gian chờ kết nối (30 giây)
        .readTimeout(30, TimeUnit.SECONDS)    // Thời gian chờ đọc dữ liệu (30 giây)
        .writeTimeout(30, TimeUnit.SECONDS)
        .addInterceptor { chain ->
            val original = chain.request()
            val requestBuilder = original.newBuilder()
//                .addHeader("Authorization", TOKEN)
            val request = requestBuilder.build()
            chain.proceed(request)
        }.build()

    // lazy: Khi nao can moi tao
    val instance: ApiServices by lazy{
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .build()
        retrofit.create(ApiServices::class.java)
    }
}

