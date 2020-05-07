package com.example.acalculator.data.local.list

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ListStorage private constructor(){

    private val storage = mutableListOf<Operation>()

    companion object {

        private var instance: ListStorage? = null

        fun getInstance(): ListStorage {
            synchronized(this) {
                if(instance == null) {
                    instance =
                        ListStorage()
                }
                return instance as ListStorage
            }
        }
    }

    suspend fun insert(operation: Operation) {
        withContext(Dispatchers.IO) {
            storage.add(operation)
        }

    }

    fun getAll(): List<Operation> {
        return storage.toList()
    }
}