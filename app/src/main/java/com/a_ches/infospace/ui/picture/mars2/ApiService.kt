package com.a_ches.infospace.ui.picture.mars2

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {


    @GET("mars-photos/api/v1/rovers/curiosity/photos?sol=1000&page=1")
    suspend fun getPhotosFromMars(
        @Query("api_key") apiKey: String
    ): PhotosFromMarsDTO


}