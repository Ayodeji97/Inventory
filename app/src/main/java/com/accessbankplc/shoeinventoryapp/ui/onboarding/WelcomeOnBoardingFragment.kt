package com.accessbankplc.shoeinventoryapp.ui.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.accessbankplc.shoeinventoryapp.R
import com.accessbankplc.shoeinventoryapp.databinding.ActivityMainBinding
import com.accessbankplc.shoeinventoryapp.databinding.FragmentWelcomeOnBoardingBinding

/**
 * Instruction on boarding screen
 *
 * Created by Daniel Ayodeji : https://github.com/Ayodeji97
 * */

class WelcomeOnBoardingFragment : Fragment() {

private lateinit var ui : FragmentWelcomeOnBoardingBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_welcome_on_boarding, container, false)

        ui = DataBindingUtil.inflate(inflater, R.layout.fragment_welcome_on_boarding, container, false)

        navigate()

        return ui.root
    }


    /**
     * Navigate to login screen
     * */

    private fun navigate () {
        ui.fragmentWelcomeOnBoardingSkipTv.setOnClickListener {
            findNavController().navigate(WelcomeOnBoardingFragmentDirections.actionWelcomeOnBoardingFragmentToInstructionsOnBoardingFragment())
        }
        ui.getStartedBtn.setOnClickListener {
            findNavController().navigate(WelcomeOnBoardingFragmentDirections.actionWelcomeOnBoardingFragmentToInstructionsOnBoardingFragment())
        }
    }
}