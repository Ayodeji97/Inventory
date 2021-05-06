package com.accessbankplc.shoeinventoryapp.utils

import androidx.fragment.app.Fragment


fun Fragment.validateEmailAddress (email : String) : Boolean {
    if (email.isEmpty()) return false

//    val regex = Regex("^([a-zA-Z0-9_\\-.]+)@([a-zA-Z0-9_\\-.]+)\\.([a-zA-Z]{2,5})\$")
//
//    if (!email.trim().matches(regex)) return false

    return true
}

fun Fragment.validatePassword (password : String) : Boolean {
    if (password.isEmpty()) return false
    return true
}