package com.example.retrofit

import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {


    private var service: QuoteService? = null
    private var instance: ApiClient? = null

    private fun apiClient(): Quote? {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://programming-quotes-api.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        service = retrofit.create(QuoteService::class.java)
        return service?.getRandomQuote()?.execute()?.body()
    }

    fun getInstance(): ApiClient? {
        if (instance == null) {
            instance = ApiClient()
        }
        return instance
    }


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


    private fun <T> Call<T>?.enqueue() {
        TODO("Not yet implemented")
    }
}
interface ApiListener {
    fun onQuoteReceived(quote: String?)
    fun onFailure()
}