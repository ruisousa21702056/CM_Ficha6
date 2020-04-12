package com.example.acalculator

import android.R.attr.name
import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Operation (val expression: String, val result: Double) : Parcelable