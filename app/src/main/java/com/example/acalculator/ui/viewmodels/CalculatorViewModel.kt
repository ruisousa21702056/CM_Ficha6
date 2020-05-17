package com.example.acalculator.ui.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.acalculator.data.local.entities.Operation
import com.example.acalculator.data.local.room.CalculatorDatabase
import com.example.acalculator.domain.calculator.CalculatorLogic
import com.example.acalculator.ui.listeners.OnDisplayChanged
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CalculatorViewModel(application: Application) : AndroidViewModel(application) {

    private val storage = CalculatorDatabase.getInstance(application).operationDao()

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

    fun onClickSymbol(symbol: String) {
        display = calculatorLogic.insertSymbol(display,symbol)
        notifyOnDisplayChanged()
    }

    fun onClickEquals() {
        CoroutineScope(Dispatchers.Main).launch {
            display = calculatorLogic.performOperation(display).toString()
            list_historic_land = calculatorLogic.getHistory()
            notifyOnDisplayChanged()
        }
    }

    fun onClickReset() {
        display = "0"
        notifyOnDisplayChanged()
    }

    fun onDeleteLastCharacter() {
        display = calculatorLogic.deleteLastCharacter(display)
        notifyOnDisplayChanged()
    }

    fun onClickLastOperation() {
        display = list_historic_land.get(list_historic_land.size -1).expression
        notifyOnDisplayChanged()
    }
}