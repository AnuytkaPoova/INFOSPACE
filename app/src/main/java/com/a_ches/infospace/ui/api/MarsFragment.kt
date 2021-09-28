package com.a_ches.infospace.ui.api

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.a_ches.infospace.R
import com.google.android.material.bottomsheet.BottomSheetBehavior
import androidx.lifecycle.Observer
import coil.api.load
import com.a_ches.infospace.ui.picture.mars.PictureOfTheMarsData
import com.a_ches.infospace.ui.picture.mars.PictureOfTheMarsViewModel
import kotlinx.android.synthetic.main.fragment_mars.*

class MarsFragment : Fragment() {


    //private lateinit var bottomSheetBehavior: BottomSheetBehavior<ConstraintLayout>
    private val viewModel: PictureOfTheMarsViewModel by lazy {
        ViewModelProviders.of(this).get(PictureOfTheMarsViewModel::class.java)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.getData()
                .observe(viewLifecycleOwner, Observer<PictureOfTheMarsData> { renderData(it) }) // PictureOfTheDayData
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_mars, container, false) //
    }

     private fun renderData(data: PictureOfTheMarsData) { //PictureOfTheDayData
        when (data) {
            is PictureOfTheMarsData.Success -> { //PictureOfTheDayData
                val serverResponseData2 = data.serverResponseData2
                val url = serverResponseData2.photos?.get(0)?.imgSrc
                if (url.isNullOrEmpty()) {
                    //showError("Сообщение, что ссылка пустая")
                    toast("Link is empty")
                } else {
                    //showSuccess()
                    println(url)
                    val respImage = image_view_mars.load(url) {
                        lifecycle(this@MarsFragment)
                        error(R.drawable.ic_load_error_vector)
                        placeholder(R.drawable.ic_no_photo_vector)
                    }
                    println()
                }
            }
            is PictureOfTheMarsData.Loading -> { //PictureOfTheDayData
                //showLoading()
            }
            is PictureOfTheMarsData.Error -> { //PictureOfTheDayData
                //showError(data.error.message)
                toast(data.error.message)
            }
        }
    }

    private fun Fragment.toast(string: String?) {
        Toast.makeText(context, string, Toast.LENGTH_SHORT).apply {
            setGravity(Gravity.BOTTOM, 0, 250)
            show()
        }
    }

}