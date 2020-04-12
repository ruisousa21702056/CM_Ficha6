package com.example.acalculator

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import kotlinx.android.synthetic.main.activity_historic.*

const val EXTRA_HISTORY = "com.example.intent.NAME"

class HistoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_historic)
        val operations = intent.getParcelableArrayListExtra<Operation>(EXTRA_HISTORY)
        list_historic.adapter = HistoryAdapter(this,R.layout.item_expression, operations)

       /*button_backHistoric.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }*/



    }
}



