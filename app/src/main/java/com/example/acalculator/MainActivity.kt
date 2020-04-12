package com.example.acalculator

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    private val TAG = MainActivity::class.java.simpleName
    private var lastCalc = ""
    private val VISOR_KEY = "visor"
    var myListView: ListView? = null
    var operationList = ArrayList<Operation>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            myListView = findViewById<ListView>(R.id.list_historic)
            var adapter = HistoryAdapter(this, R.layout.item_expression, operationList)
            myListView?.adapter = adapter
            adapter.notifyDataSetChanged()
            /*button_equals.setOnClickListener {
                onClickEquals()
                adapter.notifyDataSetChanged()
            }*/
        }

    }

    /*
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
     */

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        text_visor.text = savedInstanceState?.getString(VISOR_KEY)
        operationList = ArrayList(savedInstanceState?.getParcelableArrayList(EXTRA_HISTORY))
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.run { putString(VISOR_KEY, text_visor.text.toString()) }
        outState.run { putParcelableArrayList(EXTRA_HISTORY, ArrayList(operationList)) }
        super.onSaveInstanceState(outState)
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
        val intent = Intent(this, HistoryActivity::class.java)
        intent.apply { putParcelableArrayListExtra(EXTRA_HISTORY, ArrayList(operationList)) }
        startActivity(intent)
        finish()
    }

}