package com.accessbankplc.shoeinventoryapp.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.accessbankplc.shoeinventoryapp.R
import com.accessbankplc.shoeinventoryapp.databinding.FragmentLoginBinding
import com.accessbankplc.shoeinventoryapp.utils.validateEmailAddress
import com.accessbankplc.shoeinventoryapp.utils.validatePassword


/**
 * Login Screen
 * Created by Daniel Ayodeji : https://github.com/Ayodeji97
 * */
class LoginFragment : Fragment() {

    private lateinit var ui : FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        ui = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)

        validateUserInput()
        return ui.root
    }


    /**
     * Email and Password validation function
     * */
    private fun validateUserInput () {
        ui.loginBtn.setOnClickListener {

            if (!validateEmailAddress(ui.fragmentLoginEmailEt.text.toString())) {
                ui.fragmentLoginEmailEt.error = "Email Field Cannot be blank"
                return@setOnClickListener
            }

            if (!validatePassword(ui.fragmentLoginPasswordEt.text.toString())) {
                Toast.makeText(requireContext(), "Empty", Toast.LENGTH_SHORT).show()
                ui.fragmentLoginPasswordEt.error = "Password Field Cannot be blank"
                return@setOnClickListener
            }
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeOnBoardingFragment())
        }
    }



}