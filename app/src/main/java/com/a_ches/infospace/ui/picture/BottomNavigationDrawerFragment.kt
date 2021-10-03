package com.a_ches.infospace.ui.picture

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.a_ches.infospace.R
import com.a_ches.infospace.ui.animations.*
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.bottom_navigation_layout.*

class BottomNavigationDrawerFragment : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.bottom_navigation_layout, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        navigation_view.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.navigation_one -> activity?.let {
                    startActivity(
                        Intent(
                            it,
                            AnimationsActivity::class.java
                        )
                    )
                }
                R.id.navigation_two -> activity?.let {
                    startActivity(
                        Intent(
                            it,
                            AnimationsActivityBonus::class.java
                        )
                    )
                }
                R.id.navigation_three -> activity?.let {
                    startActivity(
                        Intent(
                            it,
                            AnimationsActivityTransitions::class.java
                        )
                    )
                }
                R.id.navigation_four -> activity?.let {
                    startActivity(
                        Intent(
                            it,
                            AnimationsActivityTransitionsRecycler::class.java
                        )
                    )
                }
                R.id.navigation_five -> activity?.let {
                    startActivity(
                        Intent(
                            it,
                            AnimationsActivityTransitionsRecyclerSet::class.java
                        )
                    )
                }
                R.id.navigation_six -> activity?.let {
                    startActivity(
                        Intent(
                            it,
                            AnimationsActivityEnlarge::class.java
                        )
                    )
                }
                R.id.navigation_seven -> activity?.let {
                    startActivity(
                        Intent(
                            it,
                            AnimationsActivityPath::class.java
                        )
                    )
                }


            }
            dismiss()
            true
        }
    }
}
