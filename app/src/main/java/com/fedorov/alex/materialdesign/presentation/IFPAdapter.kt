package com.fedorov.alex.materialdesign.presentation

import com.fedorov.alex.materialdesign.ui.activity.settings.fragment.IFragment

interface IFPAdapter {
    fun getItem(position: Int): IFragment
    fun getCount(): Int
    fun getPageTitle(position: Int): CharSequence?
}