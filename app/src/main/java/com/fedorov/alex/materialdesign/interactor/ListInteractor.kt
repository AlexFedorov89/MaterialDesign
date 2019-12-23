package com.fedorov.alex.materialdesign.interactor

import com.fedorov.alex.materialdesign.model.Repository

class ListInteractor<T>(private val repository: Repository<List<T>>) {
    fun getItems() = repository.items()
}