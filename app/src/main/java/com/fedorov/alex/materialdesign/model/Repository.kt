package com.fedorov.alex.materialdesign.model

interface Repository<T : List<*>> {
    fun items(): T
}