package com.example.acalculator

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HistoryLogic {

    private var storage = ListStorage.getInstance()

    fun getHistory(): List<Operation> {
        return storage.getAll()
        /*var list = listOf<Operation>()
        CoroutineScope(Dispatchers.IO).launch {
            list = storage.getAll()
        }
        return list*/
    }
}