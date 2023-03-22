package com.example.userwithhilt_retrofit.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.userwithhilt_retrofit.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        val binding: ActivityMainBinding =
//            DataBindingUtil.setContentView(this, R.layout.activity_main)
//        binding.apply {
//            lifecycleOwner = this@MainActivity
//          //  viewModelWojtas = mainViewModel
//        }
        setContentView(R.layout.activity_main)
    }
}