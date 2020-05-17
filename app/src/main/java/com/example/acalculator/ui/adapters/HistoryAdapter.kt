package com.example.acalculator.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.acalculator.data.local.entities.Operation
import com.example.acalculator.ui.listeners.OnLongClick
import kotlinx.android.synthetic.main.item_expression.view.*

class HistoryAdapter(private val context: Context, private val layout: Int,
                     private val items: List<Operation>, private val listener: OnLongClick) : RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>()/*, View.OnLongClickListener*/ {

    class HistoryViewHolder(view: View,  private val listener: OnLongClick) : RecyclerView.ViewHolder(view) {

        val expression: TextView = view.text_expression
        val result: TextView = view.text_result

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        return HistoryViewHolder(
            LayoutInflater.from(context).inflate(layout, parent, false), listener
        )
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        holder.expression.text = items[position].expression
        holder.result.text = items[position].result.toString()

        holder.itemView.setOnLongClickListener(object: View.OnLongClickListener{
            override fun onLongClick(view: View?): Boolean {
                listener.onLongClick(position, view!!)
                return true
            }
        })
    }

    override fun getItemCount() = items.size

/*
    override fun onLongClick(view: View?): Boolean {
        Log.e("ADAPTER", "LONG CLICK NO ADAPTER")
        return true
    }
*/

}