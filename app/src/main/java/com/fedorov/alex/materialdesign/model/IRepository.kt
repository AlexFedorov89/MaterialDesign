package com.fedorov.alex.materialdesign.model

interface IRepository<T : List<*>> {
    fun items(): T
}