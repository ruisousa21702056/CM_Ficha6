package com.example.acalculator

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import kotlinx.android.synthetic.main.activity_historic.*
import kotlinx.android.synthetic.main.activity_main.*

class HistoricActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_historic)

        button_backHistoric.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }



    }
}



