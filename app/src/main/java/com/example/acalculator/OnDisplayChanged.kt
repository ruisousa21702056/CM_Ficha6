package com.example.acalculator

interface OnDisplayChanged {
    fun onDisplayChanged(value: String?, list: List<Operation>)
}