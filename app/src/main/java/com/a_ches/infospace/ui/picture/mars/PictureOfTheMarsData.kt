package com.a_ches.infospace.ui.picture.mars

sealed class PictureOfTheMarsData {

    data class Success(val serverResponseData2: PODServerResponseDataOfMars) : PictureOfTheMarsData()
    data class Error(val error: Throwable) : PictureOfTheMarsData()
    data class Loading(val progress: Int?) : PictureOfTheMarsData()

}