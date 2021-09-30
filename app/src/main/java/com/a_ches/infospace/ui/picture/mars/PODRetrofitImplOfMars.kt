package com.a_ches.infospace.ui.picture.mars

import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

class PODRetrofitImplOfMars {

          private val baseUrl = "https://api.nasa.gov/"

        fun getRetrofitImpl2(): PictureOfTheMarsAPI {
            val podRetrofit2 = Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
                    .client(createOkHttpClient2(PODInterceptor2()))
                    .build()
            return podRetrofit2.create(PictureOfTheMarsAPI::class.java)
        }

        private fun createOkHttpClient2(interceptor2: Interceptor): OkHttpClient {
            val httpClient2 = OkHttpClient.Builder()
            httpClient2.addInterceptor(interceptor2)
            httpClient2.addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            return httpClient2.build()
        }

        inner class PODInterceptor2 : Interceptor {

            @Throws(IOException::class)
            override fun intercept(chain2: Interceptor.Chain): okhttp3.Response {
                return chain2.proceed(chain2.request())
            }
        }
    }
