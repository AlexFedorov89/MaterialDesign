package com.fedorov.alex.materialdesign.interactor

import com.fedorov.alex.materialdesign.model.IRepository

class ListInteractor<T>(private val repository: IRepository<List<T>>) {
    fun getItems() = repository.items()
}