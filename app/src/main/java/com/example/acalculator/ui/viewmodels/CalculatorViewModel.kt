package com.example.acalculator.ui.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.acalculator.data.local.list.Operation
import com.example.acalculator.data.local.room.dao.CalculatorDatabase
import com.example.acalculator.domain.calculator.CalculatorLogic
import com.example.acalculator.ui.listeners.OnDisplayChanged
import kotlinx.coroutines.InternalCoroutinesApi

class CalculatorViewModel(application: Application) : AndroidViewModel(application) {

    @InternalCoroutinesApi
    private val storage = CalculatorDatabase.getInstance(application).operationDao()

    @InternalCoroutinesApi
    private val calculatorLogic = CalculatorLogic(storage)

    private var listener_display: OnDisplayChanged? = null

    var display = "0"
    var list_historic_land = listOf<Operation>()

    private fun notifyOnDisplayChanged(){
        listener_display?.onDisplayChanged(display,list_historic_land)
    }

    fun registerListener(listener_display: OnDisplayChanged){
        this.listener_display = listener_display
        listener_display.onDisplayChanged(display,list_historic_land)
    }

    fun unregisterListener() {
        listener_display = null
    }

    @InternalCoroutinesApi
    fun onClickSymbol(symbol: String) {
        display = calculatorLogic.insertSymbol(display,symbol)
        notifyOnDisplayChanged()
    }

    @InternalCoroutinesApi
    fun onClickEquals() {
        display = calculatorLogic.performOperation(display).toString()
        list_historic_land = calculatorLogic.getHistory()
        notifyOnDisplayChanged()
    }

    fun onClickReset() {
        display = "0"
        notifyOnDisplayChanged()
    }

    @InternalCoroutinesApi
    fun onDeleteLastCharacter() {
        display = calculatorLogic.deleteLastCharacter(display)
        notifyOnDisplayChanged()
    }

    fun onClickLastOperation() {
        display = list_historic_land.get(list_historic_land.size -1).expression
        notifyOnDisplayChanged()
    }


}