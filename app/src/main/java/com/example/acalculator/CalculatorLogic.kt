package com.example.acalculator

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import net.objecthunter.exp4j.ExpressionBuilder

class CalculatorLogic {

    private var storage = ListStorage.getInstance()

    fun insertSymbol(display: String, symbol: String): String {
        return if(display == "0") {
            symbol
        } else {
            display + symbol
        }
    }

    fun getHistory(): MutableList<Operation> {
        val list: MutableList<Operation> = storage.getAll() as MutableList<Operation>
        return list
    }

    fun deleteLastCharacter(display: String): String {
        return if (display.length > 1) {
            display.substring(0, display.length - 1)
        } else {
            "0"
        }
    }

    fun performOperation(expression: String): Double {
        val expressionBuilder = ExpressionBuilder(expression).build()
        val result = expressionBuilder.evaluate()
        CoroutineScope(Dispatchers.IO).launch {
            storage.insert(Operation(expression, result))
        }
        return result
    }
}