package com.example.acalculator.ui.listeners

import com.example.acalculator.data.local.entities.Operation

interface OnDisplayChanged {
    fun onDisplayChanged(value: String?, list: List<Operation>)
}