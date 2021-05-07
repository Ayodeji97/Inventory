package com.accessbankplc.shoeinventoryapp.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.accessbankplc.shoeinventoryapp.R
import com.accessbankplc.shoeinventoryapp.databinding.FragmentShoeDetailBinding
import com.accessbankplc.shoeinventoryapp.viewmodel.ShowListViewModel


/**
 * Created by Daniel Ayodeji : https://github.com/Ayodeji97
 * */
class ShoeDetailFragment : Fragment() {

    private val showListViewModel : ShowListViewModel by activityViewModels()

    private lateinit var ui : FragmentShoeDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        ui = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail, container, false)

        setUpView()

        return ui.root
    }


    private fun setUpView () {

        // Set the viewmodel for databinding - this allows the bound layout access to all of the
        // data in the VieWModel
        ui.showListViewModel = showListViewModel

        // this makes it possible to use data binding to update my layout directly and its makes data binding lifecycle aware
        ui.lifecycleOwner = this

        ui.addShoeBtn.setOnClickListener {
            showListViewModel.addShoe()
            findNavController().navigate(R.id.shoeListingFragment)
        }

        ui.cancelShoeBtn.setOnClickListener {
            findNavController().navigate(R.id.shoeListingFragment)
        }


        showListViewModel.isShoeAdditionComplete.observe(viewLifecycleOwner, Observer {
            if (it) {
                findNavController().navigateUp()
            }
        })

    }

    override fun onDestroyView() {
        super.onDestroyView()

        showListViewModel.reset()
    }

}