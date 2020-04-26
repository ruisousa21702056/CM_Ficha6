package com.example.acalculator

import androidx.lifecycle.ViewModel

class CalculatorViewModel : ViewModel() {

    private var listener_display: OnDisplayChanged? = null

    private val calculatorLogic = CalculatorLogic()
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
        display = calculatorLogic.performOperation(display).toString()
        list_historic_land = calculatorLogic.getHistory()
        notifyOnDisplayChanged()
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