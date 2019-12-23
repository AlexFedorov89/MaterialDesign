package com.fedorov.alex.materialdesign.ui.activity.settings

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.fedorov.alex.materialdesign.App
import com.fedorov.alex.materialdesign.R
import com.fedorov.alex.materialdesign.presentation.presenter.SettingsPresenter
import com.fedorov.alex.materialdesign.presentation.view.SettingsView
import kotlinx.android.synthetic.main.settings_activity.*
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter

class SettingsActivity : MvpAppCompatActivity(), SettingsView {
    companion object {
        fun newInstance(context: Context): Intent {
            return Intent(
                context,
                SettingsActivity::class.java
            )
        }
    }

    @InjectPresenter
    internal lateinit var presenter: SettingsPresenter

    private val adapter by lazy {
        PagesAdapter(supportFragmentManager, presenter)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme((application as App).currentTheme)
        setContentView(R.layout.settings_activity)

        view_pager.adapter = adapter
        tabs.setupWithViewPager(view_pager)
    }

    override fun updateDataSet() {
        adapter.notifyDataSetChanged()
    }
}