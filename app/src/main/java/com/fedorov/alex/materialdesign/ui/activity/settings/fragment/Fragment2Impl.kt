package com.fedorov.alex.materialdesign.ui.activity.settings.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.fedorov.alex.materialdesign.R

class Fragment2Impl : Fragment(),
    com.fedorov.alex.materialdesign.ui.activity.settings.fragment.Fragment {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? { // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_2, container, false)
    }
}