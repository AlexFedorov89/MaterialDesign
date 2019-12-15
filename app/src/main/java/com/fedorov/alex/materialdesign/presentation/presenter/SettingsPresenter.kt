package com.fedorov.alex.materialdesign.presentation.presenter

import com.fedorov.alex.materialdesign.presentation.IFPAdapter
import com.fedorov.alex.materialdesign.presentation.view.SettingsView
import com.fedorov.alex.materialdesign.ui.activity.settings.fragment.Fragment1
import com.fedorov.alex.materialdesign.ui.activity.settings.fragment.Fragment2
import com.fedorov.alex.materialdesign.ui.activity.settings.fragment.Fragment3
import com.fedorov.alex.materialdesign.ui.activity.settings.fragment.IFragment
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class SettingsPresenter : MvpPresenter<SettingsView>(), IFPAdapter {
    private val fragments: List<IFragment> = listOf(
        Fragment1(),
        Fragment2(),
        Fragment3()
    )

    private val tabTitles = listOf("One", "Two", "Three")

    override fun getItem(position: Int): IFragment = fragments[position]
    override fun getCount(): Int = fragments.size
    override fun getPageTitle(position: Int): CharSequence? = tabTitles[position]
}