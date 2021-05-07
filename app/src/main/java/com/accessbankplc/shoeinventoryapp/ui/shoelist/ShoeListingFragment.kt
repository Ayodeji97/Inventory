package com.accessbankplc.shoeinventoryapp.ui.shoelist

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.accessbankplc.shoeinventoryapp.R
import com.accessbankplc.shoeinventoryapp.databinding.FragmentShoeListingBinding
import com.accessbankplc.shoeinventoryapp.databinding.ItemShoelistBinding
import com.accessbankplc.shoeinventoryapp.viewmodel.ShowListViewModel


/**
 * Created by Daniel Ayodeji : https://github.com/Ayodeji97
 * */
class ShoeListingFragment : Fragment() {


    private lateinit var ui: FragmentShoeListingBinding

    private val shoeListViewModel: ShowListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        ui = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_listing, container, false)


        observeShoeList(inflater, container)
        navigate()

        return ui.root
    }


    private fun navigate() {
        ui.fab.setOnClickListener {
            shoeListViewModel.initialShoeValue()
            findNavController().navigate(R.id.shoeDetailFragment)
        }
    }

    /**
     * Function responsible for observing added shoe item,
     * Inflating the shoe item list layout
     * Adding the observed shoe item to the item list layout
     * */
    private fun observeShoeList(inflater: LayoutInflater, container: ViewGroup?) {

        shoeListViewModel.shoeList.observe(viewLifecycleOwner, Observer { shoeList ->

            /**
             * Check if shoe list on view
             * */
            if (shoeList.isNotEmpty()) {
                ui.fragmentShoeListingEmptyImage.visibility = View.GONE
                ui.fragmentShoeListingEmptyTextView.visibility = View.GONE
            }

            shoeList.forEach { shoe ->
                // inflate the shoe list item
                val shoeListItem: ItemShoelistBinding =
                    DataBindingUtil.inflate(inflater, R.layout.item_shoelist, container, false)

                shoeListItem.shoeData = shoe
                ui.fragmentShoeListingLinearLayout.addView(shoeListItem.root)

            }
        })

        setHasOptionsMenu(true)
    }

    /**
     * Log out function which called when the menu icon get clicked
     * */
    private fun logout() {
        findNavController().navigate(R.id.loginFragment)
    }


    /**
     * Inflate menu layout
     * */
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu, menu)
    }

    /**
     * On click of log out menu icon, shoe list get clear and navigate back to log in screen
     * */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.log_out -> {
                shoeListViewModel.shoeClear()
                logout()
            }
        }

        return super.onOptionsItemSelected(item)
    }

}