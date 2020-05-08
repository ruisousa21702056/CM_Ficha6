package com.example.acalculator.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.example.acalculator.data.local.list.Operation
import com.example.acalculator.domain.calculator.HistoryLogic
import com.example.acalculator.ui.listeners.OnLongClick

class HistoryViewModel : ViewModel() {

    private val historyLogic =
        HistoryLogic()

    fun getHistory(): List<Operation> {
        return historyLogic.getHistory()
    }
}