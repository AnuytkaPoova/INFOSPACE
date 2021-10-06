package com.a_ches.infospace.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.a_ches.infospace.R
import com.a_ches.infospace.ui.picture.ofday.PictureOfTheDayFragment


class MainActivity : AppCompatActivity() {
     //БЫЛО
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, PictureOfTheDayFragment.newInstance())
                    .commitAllowingStateLoss()
        }

    }
}
     /*
    private var _binding: MainActivityBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = MainActivityBinding.inflate(layoutInflater)

        setContentView(binding.root)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(binding.container.id, PictureOfTheDayFragment.newInstance())
                .commitNow()
        }
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }


      */