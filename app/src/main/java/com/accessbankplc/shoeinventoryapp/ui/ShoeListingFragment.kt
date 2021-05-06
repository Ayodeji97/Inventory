package com.accessbankplc.shoeinventoryapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.accessbankplc.shoeinventoryapp.R
import com.accessbankplc.shoeinventoryapp.databinding.FragmentShoeDetailBinding
import com.accessbankplc.shoeinventoryapp.databinding.FragmentShoeListingBinding


class ShoeListingFragment : Fragment() {

    private lateinit var ui : FragmentShoeListingBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_shoe_listing, container, false)

        ui = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_listing, container, false)
        return ui.root
    }

}