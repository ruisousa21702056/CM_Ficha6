package com.example.acalculator

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import butterknife.ButterKnife
import butterknife.OnClick
import butterknife.Optional
import kotlinx.android.synthetic.main.fragment_calculator.*
import kotlinx.android.synthetic.main.fragment_calculator.view.*
import net.objecthunter.exp4j.ExpressionBuilder

class CalculatorFragment : Fragment(), OnDisplayChanged {

    private var lastCalc = ""
    var operationList = ArrayList<Operation>()
    private lateinit var viewModel: CalculatorViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        /*val view = inflater.inflate(R.layout.fragment_calculator, container, false)
        viewModel = ViewModelProviders.of(this).get(CalculatorViewModel::class.java)
        viewModel.display.let {view.text_visor.text = it}
        ButterKnife.bind(this, view)
        list_historic?.layoutManager = LinearLayoutManager(activity as Context)
        return view*/
        viewModel.display.let {view.text_visor.text = it}
    }

    override fun onStart() {
        viewModel.registerListener(this)
        super.onStart()
    }

    override fun onDisplayChanged(value: String?) {
        value.let { text_visor.text = it }
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    @Optional
    @OnClick(R.id.button_0, R.id.button_00, R.id.button_1, R.id.button_2, R.id.button_2_1,
        R.id.button_3, R.id.button_4, R.id.button_5, R.id.button_6, R.id.button_7, R.id.button_8,
    R.id.button_adition, R.id.button_division, R.id.button_minus, R.id.button_multiply, R.id.button_point )
    fun onClickSymbol(view: View) {
        text_visor.text = viewModel.onClickSymbol(view.tag.toString())
    }

    @Optional
    @OnClick(R.id.button_C)
    fun onClickReset() {
        text_visor.text = "0"
    }

    @Optional
    @OnClick(R.id.button_back)
    fun onClickDeleteLast() {
        if (text_visor.text.length > 1) {
            text_visor.text =
                text_visor.text.toString().substring(0, text_visor.text.length - 1)
        } else {
            text_visor.text = "0"
        }
    }

    @OnClick(R.id.button_equals)
    fun onClickEquals() {
        text_visor.text = viewModel.onClickEquals()
    }

    @Optional
    @OnClick(R.id.button_lastCalc)
    fun onClickLastCalc() {
        text_visor.text = lastCalc
    }

    /*
    @Optional
    @OnClick(R.id.button_historic)
    fun onClickHistory(view: View) {
        //NavigationManager.goToHistoryFragment(supportFragmentManager)


        val intent = Intent(this, HistoricActivity::class.java)
        intent.apply { putParcelableArrayListExtra(EXTRA_HISTORY,ArrayList(operations)) }
        startActivity(intent)
        finish()
    }*/

    /*
    override fun onSaveInstanceState(outState: Bundle) {
        outState.run { putString(VISOR_KEY, text_visor.text.toString()) }
        outState.run { putParcelableArrayList(EXTRA_HISTORY, ArrayList(operationList)) }
        super.onSaveInstanceState(outState)
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        text_visor.text = savedInstanceState?.getString(VISOR_KEY)
        operationList = ArrayList(savedInstanceState?.getParcelableArrayList(EXTRA_HISTORY))
        super.onViewStateRestored(savedInstanceState)
    }

     */
}
