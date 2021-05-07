package com.accessbankplc.shoeinventoryapp.utils

import androidx.fragment.app.Fragment


/**
 * Created by Daniel Ayodeji : https://github.com/Ayodeji97
 *
 * Fragment extension function responsible for validating if fields are empty.
 * */

fun Fragment.validateEmailAddress (email : String) : Boolean {
    if (email.isEmpty()) return false

    return true
}

fun Fragment.validatePassword (password : String) : Boolean {
    if (password.isEmpty()) return false
    return true
}