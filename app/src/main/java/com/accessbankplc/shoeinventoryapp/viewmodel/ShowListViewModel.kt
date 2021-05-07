package com.accessbankplc.shoeinventoryapp.viewmodel

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.accessbankplc.shoeinventoryapp.BR
import com.accessbankplc.shoeinventoryapp.model.Shoe
import java.text.DecimalFormat

class ShowListViewModel : ViewModel() {

    var shoe: Shoe? = null

    private val shoes = mutableListOf<Shoe>()

    private val shoeLiveData : LiveData<List<Shoe>> = shoeList

    val shoeSize : LiveData<String> = Transformations.map(shoeLiveData) { shoe ->
        String.format("%.1f", shoe.forEach {
            it?.shoeSize
        })
    }


    private val _shoeList = MutableLiveData<List<Shoe>>()
    val shoeList: LiveData<List<Shoe>>
        get() = _shoeList

    // boolean live data to check if the shoe has being added to navigate to back
    private val _isShoeAdditionComplete = MutableLiveData<Boolean>()
    val isShoeAdditionComplete : LiveData<Boolean>
    get() = _isShoeAdditionComplete

    fun addShoe() {
//        shoe?.shoeSize = observeShoeSize.shoeSize.toDouble()
        shoe?.let { shoe ->
            shoes.add(shoe)
            additionCompleted()
            _shoeList.value = shoes
        }
    }

    fun initialShoeValue () {
        shoe = Shoe("", "", 0.0, "")
    }

    fun additionCompleted () {
        _isShoeAdditionComplete.value = true
    }

    fun reset () {
        _isShoeAdditionComplete.value = false
    }

    fun shoeClear() {
        shoes.clear()
    }





}