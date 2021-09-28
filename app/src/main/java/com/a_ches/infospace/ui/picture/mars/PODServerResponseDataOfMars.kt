package com.a_ches.infospace.ui.picture.mars

import com.google.gson.annotations.SerializedName

data class PODServerResponseDataOfMars (


        @SerializedName("photos")
        val photos: List<Photo>


)
/*


data class Photo(
        @SerializedName("camera")
        val camera: Camera,
        @SerializedName("earth_date")
        val earthDate: String,
        @SerializedName("id")
        val id: Int,
        @SerializedName("img_src")
        val imgSrc: String,
        @SerializedName("rover")
        val rover: Rover,
        @SerializedName("sol")
        val sol: Int
)

data class Camera(
        @SerializedName("full_name")
        val fullName: String,
        @SerializedName("id")
        val id: Int,
        @SerializedName("name")
        val name: String,
        @SerializedName("rover_id")
        val roverId: Int
)

data class Rover(
        @SerializedName("id")
        val id: Int,
        @SerializedName("landing_date")
        val landingDate: String,
        @SerializedName("launch_date")
        val launchDate: String,
        @SerializedName("name")
        val name: String,
        @SerializedName("status")
        val status: String
)


/*
 @SerializedName("camera")
    val camera: Camera,
    @SerializedName("earth_date")
    val earthDate: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("img_src")
    val imgSrc: String,
    @SerializedName("rover")
    val rover: Rover,
    @SerializedName("sol")
    val sol: Int
 */

/*
    @field:SerializedName("copyright") val copyright: String?,
    @field:SerializedName("date") val date: String?,
    @field:SerializedName("explanation") val explanation: String?,
    @field:SerializedName("media_type") val mediaType: String?,
    @field:SerializedName("title") val title: String?,
    @field:SerializedName("url") val url: String?,
    @field:SerializedName("hdurl") val hdurl: String?
 */

/*
   @field:SerializedName("camera") val camera: String?,
    @field:SerializedName("earth_date") val earth_date: String?,
    @field:SerializedName("id") val id: String?,
    @field:SerializedName("img_src") val img_src: String?,
    @field:SerializedName("rover") val rover: String?,
    @field:SerializedName("sol") val sol: String?,
    @field:SerializedName("url") val url: String?,
    @field:SerializedName("hdurl") val hdurl: String?

 */
*/
