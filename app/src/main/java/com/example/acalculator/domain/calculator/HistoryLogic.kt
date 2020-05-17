package com.example.acalculator.domain.calculator

import com.example.acalculator.data.local.entities.Operation
import com.example.acalculator.data.local.room.dao.OperationDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HistoryLogic(private val storage: OperationDao) {

    fun getHistory(): List<Operation> {
        var list = listOf<Operation>()
        CoroutineScope(Dispatchers.IO).launch {
            list =  storage.getAll()
        }
        return list
    }
}