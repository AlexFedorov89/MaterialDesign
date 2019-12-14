package com.fedorov.alex.materialdesign.model

class RepositoryNature : IRepository<List<String>> {
    private val items = listOf("Береза", "Сосна", "Ель", "Лиственница", "Клён")

    override fun items() = items
}