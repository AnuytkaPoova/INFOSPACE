package com.a_ches.infospace.ui.apibottom

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.a_ches.infospace.R
import com.a_ches.infospace.ui.api.EarthFragment
import com.a_ches.infospace.ui.api.MarsFragment
import com.a_ches.infospace.ui.api.WeatherFragment
import kotlinx.android.synthetic.main.activity_api_bottom.*

class ApiBottomActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_api_bottom)
        bottom_navigation_view.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.bottom_view_earth -> {
                    supportFragmentManager.beginTransaction()
                            .replace(R.id.activity_api_bottom_container, EarthFragment())
                            .commitAllowingStateLoss()
                    true
                }
                R.id.bottom_view_mars -> {
                    supportFragmentManager.beginTransaction()
                            .replace(R.id.activity_api_bottom_container, MarsFragment())
                            .commitAllowingStateLoss()
                    true
                }
                R.id.bottom_view_weather -> {
                    supportFragmentManager.beginTransaction()
                            .replace(R.id.activity_api_bottom_container, WeatherFragment())
                            .commitAllowingStateLoss()
                    true

                }
                else -> {
                    supportFragmentManager.beginTransaction()
                            .replace(R.id.activity_api_bottom_container, EarthFragment())
                            .commitAllowingStateLoss()
                    true
                }

            }
        }

        bottom_navigation_view.selectedItemId = R.id.bottom_view_earth
        bottom_navigation_view.getOrCreateBadge(R.id.bottom_view_earth)
        val badge = bottom_navigation_view.getBadge(R.id.bottom_view_earth)
        badge?.maxCharacterCount = 2
        badge?.number = 999

        bottom_navigation_view.setOnNavigationItemReselectedListener { item ->
            when (item.itemId) {
                R.id.bottom_view_earth -> {
                    //Item tapped
                }
                R.id.bottom_view_mars -> {
                    //Item tapped
                }
                R.id.bottom_view_weather -> {
                    //Item tapped
                }
            }
        }





    }
}