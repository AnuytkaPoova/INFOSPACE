package com.a_ches.infospace.ui.picture.mars2

sealed class PhotosFromMarsLoadState {


        object Loading : PhotosFromMarsLoadState()
        data class Success(val response: PhotosFromMarsDTO) : PhotosFromMarsLoadState()
        data class Error(val error: Throwable) : PhotosFromMarsLoadState()
    }
