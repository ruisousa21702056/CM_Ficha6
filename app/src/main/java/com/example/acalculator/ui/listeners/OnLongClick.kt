package com.example.acalculator.ui.listeners

import android.view.View

interface OnLongClick {
    fun onLongClick(position: Int, view: View): Boolean
}