package com.accessbankplc.shoeinventoryapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.accessbankplc.shoeinventoryapp.R
import com.accessbankplc.shoeinventoryapp.databinding.FragmentInstructionsOnBoardingBinding


class InstructionsOnBoardingFragment : Fragment() {

    private lateinit var binding : FragmentInstructionsOnBoardingBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_instructions_on_boarding, container, false)

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_instructions_on_boarding, container, false)

        return binding.root
    }

}