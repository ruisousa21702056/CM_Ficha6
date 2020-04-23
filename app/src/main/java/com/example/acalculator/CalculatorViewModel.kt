package com.example.acalculator

import androidx.lifecycle.ViewModel

class CalculatorViewModel : ViewModel() {

    private var listener: OnDisplayChanged? = null

    private val calculatorLogic = CalculatorLogic()
    var display = ""

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

    fun onClickSymbol(symbol: String): String {
        display = calculatorLogic.insertSymbol(display,symbol)
        return display
    }

    fun onClickEquals(): String {
        val result = calculatorLogic.performOperation(display)
        display = result.toString()
        return display
    }
}