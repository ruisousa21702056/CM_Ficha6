package com.example.acalculator

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_calculator.*

class MainActivity : AppCompatActivity() {

    private val TAG = MainActivity::class.java.simpleName
    private var lastCalc = ""
    private val VISOR_KEY = "visor"
    var myListView: ListView? = null
    var operationList = ArrayList<Operation>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        NavigationManager.goToCalculatorFragment(supportFragmentManager)
        this.list_historic?.layoutManager = LinearLayoutManager(activity as Context)

            /*if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            this.list_historic?.layoutManager = LinearLayoutManager(this)
            this.list_historic?.adapter = HistoryAdapter(this, R.layout.item_expression,
                operationList)
            *//*button_equals.setOnClickListener {
                onClickEquals()
                adapter.notifyDataSetChanged()
            }*//*
        }*/
        }

    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        text_visor.text = savedInstanceState?.getString(VISOR_KEY)
        operationList = ArrayList(savedInstanceState?.getParcelableArrayList(EXTRA_HISTORY))
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.run { putString(VISOR_KEY, text_visor.text.toString()) }
        outState.run { putParcelableArrayList(EXTRA_HISTORY, ArrayList(operationList)) }
        super.onSaveInstanceState(outState)
    }

}