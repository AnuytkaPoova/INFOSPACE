package com.a_ches.infospace.ui.picture.mars

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PictureOfTheMarsAPI {

    @GET("mars-photos/api/v1/rovers/{rover}/photos")
    fun getPictureOfMars(
            @Path("rover") rover: String,
            @Query("sol") earthDate: String,
            @Query("camera") camera: String,
            @Query("api_key") apiKey: String
    ) : Call<PODServerResponseDataOfMars>
}