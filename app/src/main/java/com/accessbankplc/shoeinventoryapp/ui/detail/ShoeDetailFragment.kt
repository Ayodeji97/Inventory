package com.accessbankplc.shoeinventoryapp.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.accessbankplc.shoeinventoryapp.R
import com.accessbankplc.shoeinventoryapp.databinding.FragmentShoeDetailBinding
import com.accessbankplc.shoeinventoryapp.viewmodel.ShoeDetailViewModel


class ShoeDetailFragment : Fragment() {

    private val viewModel : ShoeDetailViewModel by viewModels()

    private lateinit var binding : FragmentShoeDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
     //   return inflater.inflate(R.layout.fragment_shoe_detail, container, false)

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail, container, false)

        // Set the viewmodel for databinding - this allows the bound layout access to all of the
        // data in the VieWModel
        binding.detailViewModel = viewModel

        // this makes it possible to use data binding to update my layout directly and its makes data binding lifecycle aware
        binding.lifecycleOwner = this

        return binding.root
    }

}