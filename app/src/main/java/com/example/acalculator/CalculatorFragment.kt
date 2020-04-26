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

class CalculatorFragment : Fragment(), OnDisplayChanged{

    private lateinit var viewModel: CalculatorViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_calculator, container, false)
        viewModel = ViewModelProviders.of(this).get(CalculatorViewModel::class.java)
        ButterKnife.bind(this, view)
        return view
    }

    override fun onStart() {
        viewModel.registerListener(this)
        super.onStart()
    }

    override fun onDisplayChanged(value: String?, list: List<Operation>) {
        value.let { text_visor.text = it }
        list_historic?.layoutManager = LinearLayoutManager(activity as Context)
        list_historic?.adapter = HistoryAdapter(activity as Context,R.layout.item_expression, list)
    }

    override fun onDestroy() {
        viewModel.unregisterListener()
        super.onDestroy()
    }

    @Optional
    @OnClick(R.id.button_0, R.id.button_00, R.id.button_1, R.id.button_2, R.id.button_2_1,
        R.id.button_3, R.id.button_4, R.id.button_5, R.id.button_6, R.id.button_7, R.id.button_8,
    R.id.button_adition, R.id.button_division, R.id.button_minus, R.id.button_multiply, R.id.button_point )
    fun onClickSymbol(view: View) {
        viewModel.onClickSymbol(view.tag.toString())
    }

    @Optional
    @OnClick(R.id.button_C)
    fun onClickReset() {
        viewModel.onClickReset()
    }

    @Optional
    @OnClick(R.id.button_back)
    fun onClickDeleteLast() {
        viewModel.onDeleteLastCharacter()
    }

    @OnClick(R.id.button_equals)
    fun onClickEquals() {
        viewModel.onClickEquals()
    }

    @Optional
    @OnClick(R.id.button_lastCalc)
    fun onClickLastOperation() {
        viewModel.onClickLastOperation()
    }
}
