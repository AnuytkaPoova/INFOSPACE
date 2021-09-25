package com.a_ches.infospace.ui.picture.mars

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.a_ches.infospace.BuildConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PictureOfTheMarsViewModel (
        private val liveDataForViewToObserver: MutableLiveData<PictureOfTheMarsData> = MutableLiveData(), // PictureOfTheDayData
        private val retrofitImplOfMars: PODRetrofitImplOfMars = PODRetrofitImplOfMars() // PODRetrofitImplOfMars  PODRetrofitImpl
) :
        ViewModel() {
    fun getData(): LiveData<PictureOfTheMarsData> { // PictureOfTheDayData
        sendServerRequest()
        return liveDataForViewToObserver
    }

    private fun sendServerRequest() {
        liveDataForViewToObserver.value = PictureOfTheMarsData.Loading(null) // PictureOfTheDayData
        val apiKey: String = BuildConfig.NASA_API_KEY
        if (apiKey.isBlank()) {
            PictureOfTheMarsData.Error(Throwable("You need API key")) // PictureOfTheDayData
        } else {
            retrofitImplOfMars.getRetrofitImpl2().getPictureOfMars( // retrofitImpl
                    "curiosity",
                    "1000",
                    "fhaz",
                    apiKey)
                    .enqueue(object :
                    Callback<PODServerResponseDataOfMars> { // PODServerResponseData
                override fun onResponse(
                        call: Call<PODServerResponseDataOfMars>, // PODServerResponseData
                        response: Response<PODServerResponseDataOfMars> // PODServerResponseData
                ) {
                    if (response.isSuccessful && response.body() != null) {
                        liveDataForViewToObserver.value =
                                PictureOfTheMarsData.Success(response.body()!!) // PictureOfTheDayData
                    } else {
                        val message = response.message()
                        if (message.isNullOrEmpty()) {
                            liveDataForViewToObserver.value =
                                    PictureOfTheMarsData.Error(Throwable("Unidentified error")) //PictureOfTheDayData
                        } else {
                            liveDataForViewToObserver.value =
                                    PictureOfTheMarsData.Error(Throwable(message)) //PictureOfTheDayData
                        }
                    }
                }

                override fun onFailure(call: Call<PODServerResponseDataOfMars>, t: Throwable) { //PODServerResponseData
                    liveDataForViewToObserver.value = PictureOfTheMarsData.Error(t) //PODServerResponseData
                }

            }

            )
        }
    }
}