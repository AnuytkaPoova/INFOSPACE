package com.a_ches.infospace.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.a_ches.infospace.R
import com.a_ches.infospace.ui.picture.ofday.PictureOfTheDayFragment


class MainActivity : AppCompatActivity() {
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