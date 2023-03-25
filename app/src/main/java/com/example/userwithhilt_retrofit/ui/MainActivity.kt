package com.example.userwithhilt_retrofit.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.userwithhilt_retrofit.R
import com.example.userwithhilt_retrofit.databinding.ActivityMainBinding
import com.example.userwithhilt_retrofit.ui.notes.noteList.NotesListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), UIController{

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.apply {
            lifecycleOwner = this@MainActivity
            //  viewModelWojtas = mainViewModel
        }
    }

    override fun displayProgressBar(isDisplayed: Boolean) {
        if (isDisplayed)
            binding.mainProgressBar.visibility = View.VISIBLE
        else
            binding.mainProgressBar.visibility = View.GONE
    }


}