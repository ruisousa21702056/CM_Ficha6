package com.example.acalculator

import androidx.lifecycle.ViewModel

class HistoryViewModel : ViewModel() {

    private val historyLogic = HistoryLogic()

    fun getHistory(): MutableList<Operation> {
        return historyLogic.getHistory()
    }


}