package com.fedorov.alex.materialdesign.presentation

import com.fedorov.alex.materialdesign.ui.items.ItemsRowConcarent

interface IAdapter {
    fun onBindRepositoryRowViewAtPosition(position: Int, rowConcarent: ItemsRowConcarent)
    fun getRepositoriesRowsCount(): Int
}