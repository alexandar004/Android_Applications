package com.example.retrofit

import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {

    fun getRandomQuote(apiListener: ApiListener) {
        service?.getRandomQuote()?.enqueue()
        fun onResponse(call: Call<Quote>, response: Response<Quote>) {
            if (response.isSuccessful) {
                apiListener.onQuoteReceived(response.body()?.getText())
            } else {
                apiListener.onFailure()
            }
        }

        fun onFailure(call: Call<Quote>, t: Throwable) {
            apiListener.onFailure()
        }
    }

    companion object {

        private var service: QuoteService? = null
        private var instance: ApiClient? = null

        private fun apiClient(): ApiClient? {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://programming-quotes-api.herokuapp.com/")
                .build()
            service = retrofit.create(QuoteService::class.java)

            return null
        }

        fun getInstance(): ApiClient? {
            if (instance == null) {
                instance = apiClient()
            }
            return instance
        }
    }
}

private fun <T> Call<T>?.enqueue() {
    TODO("Not yet implemented")
}

interface ApiListener {
    fun onQuoteReceived(quote: String?)
    fun onFailure()
}