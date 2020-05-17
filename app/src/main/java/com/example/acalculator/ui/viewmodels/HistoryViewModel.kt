package com.example.acalculator.ui.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.acalculator.data.local.entities.Operation
import com.example.acalculator.data.local.room.CalculatorDatabase
import com.example.acalculator.domain.calculator.HistoryLogic

class HistoryViewModel(application: Application) : AndroidViewModel(application) {

    private val storage = CalculatorDatabase.getInstance(application).operationDao()

    private val historyLogic = HistoryLogic(storage)

    fun getHistory(): List<Operation> {
        return historyLogic.getHistory()
    }
}