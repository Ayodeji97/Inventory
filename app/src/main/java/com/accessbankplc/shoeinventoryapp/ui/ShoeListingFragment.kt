package com.accessbankplc.shoeinventoryapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.accessbankplc.shoeinventoryapp.R
import com.accessbankplc.shoeinventoryapp.databinding.FragmentShoeDetailBinding
import com.accessbankplc.shoeinventoryapp.databinding.FragmentShoeListingBinding
import com.accessbankplc.shoeinventoryapp.databinding.ItemShoelistBinding
import com.accessbankplc.shoeinventoryapp.viewmodel.ShowListViewModel


class ShoeListingFragment : Fragment() {


    private lateinit var ui : FragmentShoeListingBinding

    private val shoeListViewModel : ShowListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        ui = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_listing, container, false)


        observeShoeList(inflater, container)
       // navigate()

        return ui.root
    }


    private fun navigate () {

//        ui.fab.setOnClickListener {
//           shoeListViewModel.initialShoeValue()
//            //shoeListViewModel.addShoe()
//            findNavController().navigate(R.id.shoeDetailFragment)
//        }
    }

    private fun observeShoeList (inflater: LayoutInflater, container: ViewGroup?) {

        ui.fab.setOnClickListener {
            shoeListViewModel.initialShoeValue()
            //shoeListViewModel.addShoe()
            findNavController().navigate(R.id.shoeDetailFragment)
        }

        shoeListViewModel.shoeList.observe(viewLifecycleOwner, Observer {shoeList ->

            if (shoeList.isNotEmpty()) {
                ui.fragmentShoeListingEmptyImage.visibility = View.GONE
                ui.fragmentShoeListingEmptyTextView.visibility = View.GONE
            }

            shoeList.forEach { shoe ->
                // inflate the shoe list item
                val shoeListItem : ItemShoelistBinding = DataBindingUtil.inflate(inflater, R.layout.item_shoelist, container, false)

                shoeListItem.shoeData = shoe

                ui.fragmentShoeListingLinearLayout.addView(shoeListItem.root)
            }

        })
    }

}