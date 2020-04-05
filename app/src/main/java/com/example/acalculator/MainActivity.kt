package com.example.acalculator

import android.content.Intent
import android.content.res.Configuration
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.ListView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class MainActivity : AppCompatActivity() {

    private val TAG = MainActivity::class.java.simpleName
    private var lastCalc = ""
    private val VISOR_KEY = "visor"
    var myListView: ListView? = null
    var operationList = ArrayList<Operation>()
    var operationListAux = ArrayList<Operation>()

    fun onClickEquals(symbol: String) {
        Log.i(TAG, "Click no botão $symbol")
        lastCalc = text_visor.text.toString()
        val expression = ExpressionBuilder(text_visor.text.toString()).build()
        text_visor.text = expression.evaluate().toString()
        Log.i(TAG, "O resultado da expressão é ${text_visor.text}")
        var operationAux = Operation(lastCalc,expression.evaluate().toString())
        operationList.add(operationAux)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("hh:mm:ss")
        val formatted = current.format(formatter)
        Toast.makeText(this, "onCreate $formatted", Toast.LENGTH_SHORT).show()
        Log.i(TAG, "O método onCreate foi invocado")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            myListView = findViewById<ListView>(R.id.list_historic)
            var adapter = HistoryAdapter(this, R.layout.item_expression, operationList)
            myListView?.adapter = adapter
            adapter.notifyDataSetChanged()
            button_equals.setOnClickListener {
                onClickEquals("=")
                adapter.notifyDataSetChanged()
            }
        }
        else{
            button_equals.setOnClickListener {
                onClickEquals("=")
            }
        }


        fun onClickSymbol(symbol: String) {
            Log.i(TAG, "Click no botão $symbol")
            if (text_visor.text.toString() == "0") {
                text_visor.text = "$symbol"
            } else {
                text_visor.append("$symbol")
            }
        }

        fun onClickReset() {
            text_visor.text = "0"
        }

        fun onClickDeleteLast() {
            if (text_visor.text.length > 1) {
                text_visor.text =
                    text_visor.text.toString().substring(0, text_visor.text.length - 1)
            } else {
                text_visor.text = "0"
            }
        }

        fun onClickLastCalc() {
            text_visor.text = lastCalc
        }

        fun onClickHistoric() {
            val intent = Intent(this, HistoricActivity::class.java)
            startActivity(intent)
            finish()
        }

        button_0.setOnClickListener { onClickSymbol("0") }
        button_00?.setOnClickListener { onClickSymbol("00") }
        button_1.setOnClickListener { onClickSymbol("1") }
        button_2.setOnClickListener { onClickSymbol("2") }
        button_2_1?.setOnClickListener { onClickSymbol("2") }
        button_3.setOnClickListener { onClickSymbol("3") }
        button_4.setOnClickListener { onClickSymbol("4") }
        button_5.setOnClickListener { onClickSymbol("5") }
        button_6.setOnClickListener { onClickSymbol("6") }
        button_7?.setOnClickListener { onClickSymbol("7") }
        button_8?.setOnClickListener { onClickSymbol("8") }
        button_9?.setOnClickListener { onClickSymbol("9") }
        button_lastCalc?.setOnClickListener { onClickLastCalc() }
        button_point.setOnClickListener { onClickSymbol(".") }
        button_adition.setOnClickListener { onClickSymbol("+") }
        button_minus?.setOnClickListener { onClickSymbol("-") }
        button_multiply?.setOnClickListener { onClickSymbol("*") }
        button_division?.setOnClickListener { onClickSymbol("/") }
        button_C.setOnClickListener { onClickReset() }
        button_back.setOnClickListener { onClickDeleteLast() }
        button_historic?.setOnClickListener { onClickHistoric() }

    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onStart() {
        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("hh:mm:ss")
        val formatted = current.format(formatter)
        super.onStart()
        Toast.makeText(this, "onStart $formatted", Toast.LENGTH_SHORT).show()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onResume() {
        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("hh:mm:ss")
        val formatted = current.format(formatter)
        super.onResume()
        Toast.makeText(this, "onResume $formatted", Toast.LENGTH_SHORT).show()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onPause() {
        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("hh:mm:ss")
        val formatted = current.format(formatter)
        super.onPause()
        Toast.makeText(this, "onPause $formatted", Toast.LENGTH_SHORT).show()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onStop() {
        val current = LocalDateTime.now()

        val formatter = DateTimeFormatter.ofPattern("hh:mm:ss")

        val formatted = current.format(formatter)
        super.onStop()
        Toast.makeText(this, "onStop $formatted", Toast.LENGTH_SHORT).show()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onRestart() {
        val current = LocalDateTime.now()

        val formatter = DateTimeFormatter.ofPattern("hh:mm:ss")

        val formatted = current.format(formatter)
        super.onRestart()
        Toast.makeText(this, "onRestart $formatted", Toast.LENGTH_SHORT).show()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onDestroy() {
        val current = LocalDateTime.now()

        val formatter = DateTimeFormatter.ofPattern("hh:mm:ss")

        val formatted = current.format(formatter)
        super.onDestroy()
        Toast.makeText(this, "onDestroy $formatted", Toast.LENGTH_SHORT).show()
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        text_visor.text = savedInstanceState?.getString(VISOR_KEY)

    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.run { putString(VISOR_KEY, text_visor.text.toString()) }
        super.onSaveInstanceState(outState)
    }

}