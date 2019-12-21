package com.fedorov.alex.materialdesign.presentation.presenter

import com.fedorov.alex.materialdesign.presentation.FPAdapter
import com.fedorov.alex.materialdesign.presentation.view.SettingsView
import com.fedorov.alex.materialdesign.ui.activity.settings.fragment.Fragment1Impl
import com.fedorov.alex.materialdesign.ui.activity.settings.fragment.Fragment2Impl
import com.fedorov.alex.materialdesign.ui.activity.settings.fragment.Fragment3Impl
import com.fedorov.alex.materialdesign.ui.activity.settings.fragment.Fragment
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class SettingsPresenter : MvpPresenter<SettingsView>(), FPAdapter {
    private val fragments: List<Fragment> = listOf(
        Fragment1Impl(),
        Fragment2Impl(),
        Fragment3Impl()
    )

    private val tabTitles = listOf("One", "Two", "Three")

    // RV functions.
    override fun getItem(position: Int): Fragment = fragments[position]
    override fun getCount(): Int = fragments.size
    override fun getPageTitle(position: Int): CharSequence? = tabTitles[position]
}