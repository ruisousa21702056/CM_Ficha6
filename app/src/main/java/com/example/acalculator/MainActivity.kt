package com.example.acalculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        NavigationManager.goToCalculatorFragment(supportFragmentManager)

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