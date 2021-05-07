package com.accessbankplc.shoeinventoryapp.model

import androidx.databinding.ObservableField

/**
 * Data model for shoe properties
 *
 * Created by Daniel Ayodeji : https://github.com/Ayodeji97
 * */
data class Shoe(
        var shoeName: String,
        var brandName: String,
        var shoeSize: Double,
        var shoeDescription: String,
)

