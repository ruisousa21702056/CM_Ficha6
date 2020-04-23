package com.example.acalculator

import androidx.lifecycle.ViewModel

class CalculatorViewModel : ViewModel() {

    private var listener: OnDisplayChanged? = null

    private val calculatorLogic = CalculatorLogic()
    var display = "0"
    var list_historic_historic = ArrayList<Operation>()

    private fun notifyOnDisplayChanged(){
        listener?.onDisplayChanged(display)
    }

    fun registerListener(listener: OnDisplayChanged){
        this.listener = listener
        listener?.onDisplayChanged(display)
    }

    fun unregisterListener() {
        listener = null
    }

    fun onClickSymbol(symbol: String) {
        display = calculatorLogic.insertSymbol(display,symbol)
        notifyOnDisplayChanged()
    }

    fun onClickEquals() {
        display = calculatorLogic.performOperation(display).toString()
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


}