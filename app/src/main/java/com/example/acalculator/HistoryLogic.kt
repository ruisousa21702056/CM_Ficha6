package com.example.acalculator

class HistoryLogic {

    private var storage = ListStorage.getInstance()

    fun getHistory(): MutableList<Operation> {
        val list: MutableList<Operation> = storage.getAll() as MutableList<Operation>
        return list
    }
}