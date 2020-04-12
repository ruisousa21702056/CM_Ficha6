package com.example.acalculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_calculator.*
import net.objecthunter.exp4j.ExpressionBuilder

class CalculatorFragment : Fragment() {

    private val TAG = MainActivity::class.java.simpleName
    private var lastCalc = ""
    private val VISOR_KEY = "visor"
    var myListView: ListView? = null
    var operationList = ArrayList<Operation>()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calculator, container, false)
    }

    fun onClickSymbol(view: View) {
        val symbol = view.tag.toString()
        if (text_visor.text.toString() == "0") {
            text_visor.text = "$symbol"
        } else {
            text_visor.append("$symbol")
        }
    }

    fun onClickReset(view: View) {
        text_visor.text = "0"
    }

    fun onClickDeleteLast(view: View) {
        if (text_visor.text.length > 1) {
            text_visor.text =
                text_visor.text.toString().substring(0, text_visor.text.length - 1)
        } else {
            text_visor.text = "0"
        }
    }

    fun onClickEquals(view: View) {
        lastCalc = text_visor.text.toString()
        val expression = ExpressionBuilder(text_visor.text.toString()).build()
        text_visor.text = expression.evaluate().toString()
        val operationAux = Operation(lastCalc,expression.evaluate())
        operationList.add(operationAux)
    }

    fun onClickLastCalc(view: View) {
        text_visor.text = lastCalc
    }

    fun onClickHistory(view: View) {

    }
}
