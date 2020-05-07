package com.example.acalculator.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.example.acalculator.data.local.list.Operation
import com.example.acalculator.domain.calculator.HistoryLogic
import com.example.acalculator.ui.listeners.OnLongClick

class HistoryViewModel : ViewModel() {

    private var listener_onLongClick: OnLongClick? = null
    private val historyLogic =
        HistoryLogic()

    private fun notifyOnLongClick(){
        listener_onLongClick?.OnLongClick()
    }

    fun getHistory(): List<Operation> {
        return historyLogic.getHistory()
    }
}