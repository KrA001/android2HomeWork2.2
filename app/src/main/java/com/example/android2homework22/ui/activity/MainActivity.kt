package com.example.android2homework22.ui.activity

import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.fragment.NavHostFragment
import com.example.android2homework22.R
import com.example.android2homework22.utils.PreferenceHelper

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment =  supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment
        val navController = navHostFragment.navController
        val preference = PreferenceHelper()
        preference.unit(this)

        val check = preference.saveBoolean

        if(check == false){
            navController.navigate(R.id.onBoardFragment)
        }else{
            navController.navigate(R.id.noteFragment)
        }
    }


}