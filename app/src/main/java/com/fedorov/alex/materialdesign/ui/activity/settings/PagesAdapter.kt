package com.fedorov.alex.materialdesign.ui.activity.settings

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.fedorov.alex.materialdesign.presentation.presenter.SettingsPresenter

class PagesAdapter(fm: FragmentManager, val presenter:SettingsPresenter) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {



    override fun getItem(position: Int): Fragment = presenter.getItem(position) as Fragment

    override fun getCount(): Int = presenter.getCount()

    override fun getPageTitle(position: Int): CharSequence? = presenter.getPageTitle(position)
}