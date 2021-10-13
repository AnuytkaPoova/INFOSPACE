package com.a_ches.infospace.ui.picture.ofday

import android.content.Intent
import android.graphics.Typeface
import android.net.Uri
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import coil.api.load
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.a_ches.infospace.R
import com.a_ches.infospace.databinding.FragmentMainBinding
import com.a_ches.infospace.databinding.FragmentMainStartBinding
import com.a_ches.infospace.ui.MainActivity
import com.a_ches.infospace.ui.api.ApiActivity
import com.a_ches.infospace.ui.apibottom.ApiBottomActivity
import com.a_ches.infospace.ui.picture.BottomNavigationDrawerFragment
import com.a_ches.infospace.ui.settings.SettingsFragment
import kotlinx.android.synthetic.main.bottom_sheet_layout.*
import kotlinx.android.synthetic.main.fragment_main.*


class PictureOfTheDayFragment : Fragment() {


    var _binding: FragmentMainStartBinding? = null
    val binding get() = _binding!!

    private lateinit var bottomSheetBehavior: BottomSheetBehavior<ConstraintLayout>
    private val viewModel: PictureOfTheDayViewModel by lazy {
        ViewModelProviders.of(this).get(PictureOfTheDayViewModel::class.java)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.getData()
            .observe(viewLifecycleOwner, Observer<PictureOfTheDayData> { renderData(it) })
    }


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        //return inflater.inflate(R.layout.fragment_main_start, container, false)
        _binding = FragmentMainStartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setBottomSheetBehavior(binding.bottomSheetContainer.root, BottomSheetBehavior.STATE_COLLAPSED)  // setbottomSheetBehavior(view.findViewById(R.id.bottom_sheet_container)
        /*activity?.let {

            bottom_sheet_description.typeface = Typeface.createFromAsset(it.assets,"angeles-rough-font.zip")
        }*/
        input_layout.setEndIconOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse("https://en.wikipedia.org/wiki/${input_edit_text.text.toString()}")
            })
        }
        setbottomAppBar(view)

        binding.imageView.setOnClickListener {
            hideOrShowBottomSheet()
        }
    }
    /*activity?.let {
        text_view.typeface = Typeface.createFromAsset(it.assets, "Niceyear.ttf")//

    }*/


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_bottom_bar, menu)

    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.app_bar_fav -> activity?.let { startActivity(Intent(it, ApiBottomActivity::class.java)) }
            R.id.app_bar_settings -> activity?.supportFragmentManager?.beginTransaction()
                    ?.add(R.id.container, SettingsFragment())?.addToBackStack(null)?.commit()
            android.R.id.home -> {
                activity?.let {
                    BottomNavigationDrawerFragment().show(it.supportFragmentManager, "tag")
                }
            }
            R.id.app_bar_api -> activity?.let { startActivity(Intent(it, ApiActivity::class.java)) }
        }
         return super.onOptionsItemSelected(item)
    }

    private fun renderData(data: PictureOfTheDayData?) {
        when(data) {
            is PictureOfTheDayData.Success -> {


                val serverResponseData = data.serverResponseData

                val url = serverResponseData.url

                if (url.isNullOrEmpty()) {
                    //showError("Сообщение, что ссылка пустая")
                    toast("Link is empty")
                } else {
                    //showSuccess()
                        image_view.load(url) {
                        lifecycle(this@PictureOfTheDayFragment)
                        error(R.drawable.ic_load_error_vector)
                        placeholder(R.drawable.ic_no_photo_vector)

                            //binding.imageDesc.text = "Photo date: ${(data.stateData).date}"

                            //binding.bottomSheetContainer.bottomSheetDescriptionHeader.text = (data.stateData).title
                            //binding.bottomSheetContainer.bottomSheetDescription.text = (data.stateData).explanation
                            //binding.bottomSheetContainer.bottomSheetDescriptionHeader.text = ("This lovely starfield spans some four full moons (about 2 degrees) across the heroic northern constellation of Perseus. In telescopic exposures made during the nights of January 24, 26, and 28 it holds the famous pair of open or galactic star clusters h and Chi Persei")
                            //binding.bottomSheetContainer.bottomSheetDescription.text = (data.stateData).explanation
                    }
                }
            }
             is   PictureOfTheDayData.Loading -> {
                 //showLoading()
             }
            is PictureOfTheDayData.Error -> {
                //showError(data.error.message)
                toast(data.error.message)
            }
        }
    }



    private fun setbottomAppBar(view: View) {
        val context = activity as MainActivity
        context.setSupportActionBar(view.findViewById(R.id.bottom_app_bar))
        setHasOptionsMenu(true)
        fab.setOnClickListener {
            if (isMain) {
                isMain = false
                bottom_app_bar.navigationIcon = null
                bottom_app_bar.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_END
                fab.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_back_fab))
                bottom_app_bar.replaceMenu(R.menu.menu_bottom_bar_other_screen)
            } else {
                isMain = true
                bottom_app_bar.navigationIcon =
                        ContextCompat.getDrawable(context, R.drawable.ic_hamburger_menu_bottom_bar)
                bottom_app_bar.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_CENTER
                fab.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_plus_fab))
                bottom_app_bar.replaceMenu(R.menu.menu_bottom_bar)
            }
        }
    }


    private fun setBottomSheetBehavior(bottomSheet: ConstraintLayout, state: Int) { // private fun setbottomSheetBehavior(bottomSheet: ConstraintLayout)
        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet)
        bottomSheetBehavior.state = state  //bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
    }

    private fun hideOrShowBottomSheet() {
        if (bottomSheetBehavior.state != BottomSheetBehavior.STATE_COLLAPSED) {
            setBottomSheetBehavior(
                binding.bottomSheetContainer.root,
                BottomSheetBehavior.STATE_COLLAPSED
            )
        } else {
            setBottomSheetBehavior(
                binding.bottomSheetContainer.root,
                BottomSheetBehavior.STATE_HALF_EXPANDED
            )
        }
    }

    private fun Fragment.toast(string: String?) {
        Toast.makeText(context, string, Toast.LENGTH_SHORT).apply {
            setGravity(Gravity.BOTTOM, 0, 250)
            show()
        }
    }

    companion object {
    fun newInstance() = PictureOfTheDayFragment()
    private var isMain = true
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}







