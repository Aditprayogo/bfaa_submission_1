package com.aditprayogo.bfaa_submission_1.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aditprayogo.bfaa_submission_1.R
import com.aditprayogo.bfaa_submission_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding : ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupUi()
    }

    private fun setupUi() {

    }
}