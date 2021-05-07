package com.accessbankplc.shoeinventoryapp.ui.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.accessbankplc.shoeinventoryapp.R
import com.accessbankplc.shoeinventoryapp.databinding.FragmentInstructionsOnBoardingBinding

/**
 * Instruction on boarding screen
 *
 * Created by Daniel Ayodeji : https://github.com/Ayodeji97
 * */

class InstructionsOnBoardingFragment : Fragment() {

    private lateinit var ui : FragmentInstructionsOnBoardingBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        ui = DataBindingUtil.inflate(inflater, R.layout.fragment_instructions_on_boarding, container, false)

        navigate()
        return ui.root
    }


    /**
     * Navigate to login screen
     * */
    private fun navigate () {
        ui.fragmentWelcomeOnBoardingSkipTv.setOnClickListener {
            findNavController().navigate(R.id.shoeListingFragment)
        }
        ui.getInstructionBtn.setOnClickListener {
            findNavController().navigate(R.id.shoeListingFragment)
        }
    }

}