package com.example.acalculator.domain.calculator

import com.example.acalculator.data.local.list.ListStorage
import com.example.acalculator.data.local.list.Operation

class HistoryLogic {

    private var storage =
        ListStorage.getInstance()

    fun getHistory(): List<Operation> {
        return storage.getAll()
        /*var list = listOf<Operation>()
        CoroutineScope(Dispatchers.IO).launch {
            list = storage.getAll()
        }
        return list*/
    }
}