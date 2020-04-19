package com.example.acalculator

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import butterknife.ButterKnife
import kotlinx.android.synthetic.main.fragment_history.*

class HistoryFragment : Fragment() {

    val operations = ArrayList<Operation>();

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        list_historic.layoutManager = LinearLayoutManager(activity as Context)
        list_historic.adapter = HistoryAdapter(activity as Context,R.layout.item_expression, operations)
        val view = inflater.inflate(R.layout.fragment_history, container, false)
        //ButterKnife.bind(this, view)
        return view
    }

}
