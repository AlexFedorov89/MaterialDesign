package com.fedorov.alex.materialdesign.presentation

import com.fedorov.alex.materialdesign.ui.activity.profile.ItemsRowConcarent

interface IRVAdapter {
    fun onBindRepositoryRowViewAtPosition(position: Int, rowConcarent: ItemsRowConcarent)
    fun getRepositoriesRowsCount(): Int
}