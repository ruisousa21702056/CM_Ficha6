package com.example.acalculator

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class MainActivity : AppCompatActivity() {

    private val TAG = MainActivity::class.java.simpleName
    private var lastCalc = ""
    private val VISOR_KEY = "visor"

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("hh:mm:ss")
        val formatted = current.format(formatter)
        Toast.makeText(this, "onCreate $formatted", Toast.LENGTH_SHORT).show()
        Log.i(TAG,"O método onCreate foi invocado")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*list_historic.adapter = ArrayAdapter(this,
            android.R.layout.simple_list_item_1, arrayListOf("1+1=1","2p3=5"))*/



        fun onClickSymbol(symbol: String) {
            Log.i(TAG, "Click no botão $symbol")
            if (text_visor.text == "0") {
                text_visor.text = "$symbol"
            } else {
                text_visor.append("$symbol")
            }
        }

        fun onClickEquals(symbol: String) {
            Log.i(TAG, "Click no botão $symbol")
            lastCalc = text_visor.text.toString()
            val expression = ExpressionBuilder(text_visor.text.toString()).build()
            text_visor.text = expression.evaluate().toString()
            Log.i(TAG, "O resultado da expressão é ${text_visor.text}")
        }

        fun onClickReset(symbol: String) {
            text_visor.text = "0"
        }

        fun onClickDeleteLast(symbol: String) {
            if (text_visor.text.length > 1) {
                text_visor.text =
                    text_visor.text.toString().substring(0, text_visor.text.length - 1)
            } else {
                text_visor.text = "0"
            }
        }

        fun onClickLastCalc(symbol: String) {
            text_visor.text = lastCalc
        }

        button_0.setOnClickListener { onClickSymbol("0") }
        button_1.setOnClickListener { onClickSymbol("1") }
        button_2.setOnClickListener { onClickSymbol("2") }
        button_3.setOnClickListener { onClickSymbol("3") }
        button_4.setOnClickListener { onClickSymbol("4") }
        button_5.setOnClickListener { onClickSymbol("5") }
        button_6.setOnClickListener { onClickSymbol("6") }
        button_point.setOnClickListener { onClickSymbol(".") }
        button_adition.setOnClickListener { onClickSymbol("+") }
        button_c.setOnClickListener { onClickReset("C") }
        button_back.setOnClickListener { onClickDeleteLast("<") }
        button_question.setOnClickListener { onClickLastCalc("?") }
        button_equals.setOnClickListener { onClickEquals("=") }

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

    override fun onSaveInstanceState(outState: Bundle?, outPersistentState: PersistableBundle?) {
        outState?.run { putString(VISOR_KEY, text_visor.text.toString()) }
        super.onSaveInstanceState(outState, outPersistentState)
    }

}