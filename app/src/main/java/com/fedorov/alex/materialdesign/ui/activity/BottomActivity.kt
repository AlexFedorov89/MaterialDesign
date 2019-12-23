package com.fedorov.alex.materialdesign.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.fedorov.alex.materialdesign.App
import com.fedorov.alex.materialdesign.R
import com.fedorov.alex.materialdesign.ui.activity.settings.fragment.Fragment1Impl
import com.fedorov.alex.materialdesign.ui.activity.settings.fragment.Fragment2Impl
import com.fedorov.alex.materialdesign.ui.activity.settings.fragment.Fragment3Impl
import kotlinx.android.synthetic.main.activity_bottom.*

// only for example without presenter and view.
// TODO Delete this activity.

class BottomActivity : AppCompatActivity() {
    companion object {
        fun newInstance(context: Context): Intent {
            return Intent(
                context,
                BottomActivity::class.java
            )
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme((application as App).currentTheme)
        setContentView(R.layout.activity_bottom)

        navigation_view.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_fruits -> {
                    replaceFragment(Fragment1Impl())
                    true
                }
                R.id.navigation_vegetables -> {
                    replaceFragment(Fragment2Impl())
                    true
                }
                R.id.navigation_nature -> {
                    replaceFragment(Fragment3Impl())
                    true
                }
                else -> false
            }
        }

        replaceFragment(Fragment1Impl())
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame_layout, fragment)
            .commit()
    }
}