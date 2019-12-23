package com.fedorov.alex.materialdesign.presentation

import com.fedorov.alex.materialdesign.ui.activity.settings.fragment.Fragment

interface FPAdapter {
    fun getItem(position: Int): Fragment
    fun getCount(): Int
    fun getPageTitle(position: Int): CharSequence?
}