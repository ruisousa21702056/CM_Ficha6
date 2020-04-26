package com.example.acalculator

import androidx.lifecycle.ViewModel

class HistoryViewModel : ViewModel() {

    private var listener_onLongClick: OnLongClick? = null
    private val historyLogic = HistoryLogic()

    private fun notifyOnLongClick(){
        listener_onLongClick?.OnLongClick()
    }

    fun getHistory(): List<Operation> {
        return historyLogic.getHistory()
    }
}