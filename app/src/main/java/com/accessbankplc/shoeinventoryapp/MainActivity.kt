package com.accessbankplc.shoeinventoryapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.accessbankplc.shoeinventoryapp.databinding.ActivityMainBinding

/**
 * Created by Daniel Ayodeji : https://github.com/Ayodeji97
 * */
class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var navController : NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setContentView(R.layout.activity_main)


        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        setUpViews()

    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    private fun setUpViews() {

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_main)

        if (navHostFragment != null) {
            navController = navHostFragment.findNavController()
        }

        var appConfiguration = AppBarConfiguration(navController.graph)

        setupActionBarWithNavController(navController, appConfiguration)
    }
}