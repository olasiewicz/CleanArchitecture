package com.example.userwithhilt_retrofit.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.userwithhilt_retrofit.R
import com.example.userwithhilt_retrofit.databinding.ActivityMainBinding
import com.example.userwithhilt_retrofit.ui.notes.NotesListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), UIController {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.apply {
            lifecycleOwner = this@MainActivity
        }
    }

    override fun displayProgressBar(isDisplayed: Boolean) {
        if (isDisplayed)
            binding.mainProgressBar.visibility = View.VISIBLE
        else
            binding.mainProgressBar.visibility = View.GONE
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}