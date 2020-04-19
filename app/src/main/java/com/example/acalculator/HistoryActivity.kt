package com.example.acalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

const val EXTRA_HISTORY = "com.example.intent.NAME"

class HistoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_historic)
        NavigationManager.goToHistoryFragment(supportFragmentManager)
        val operations = intent.getParcelableArrayListExtra<Operation>(EXTRA_HISTORY)

    }
}



