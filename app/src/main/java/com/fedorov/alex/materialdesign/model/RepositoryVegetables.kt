package com.fedorov.alex.materialdesign.model

class RepositoryVegetables : IRepository<List<String>> {
    private val items = listOf("Огурец", "Редис", "Помидор", "Томат", "Патисон")

    override fun items() = items
}