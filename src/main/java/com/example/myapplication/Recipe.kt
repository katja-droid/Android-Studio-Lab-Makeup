package com.example.myapplication

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Recipe(val name: String, val shade: String, val year: String, val company: String) :
    Parcelable {

    init {
        name
        shade
        year
        company
    }
}
