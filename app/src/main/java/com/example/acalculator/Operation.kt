package com.example.acalculator

import android.R.attr.name
import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize data class Operation (val expression: String, val result: String) : Parcelable{
    constructor(source: Parcel) : this(
        source.readString(),
        source.readString()
    )
}