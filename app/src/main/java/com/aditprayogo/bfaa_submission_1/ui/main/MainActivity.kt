package com.aditprayogo.bfaa_submission_1.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aditprayogo.bfaa_submission_1.R
import com.aditprayogo.bfaa_submission_1.data.User
import com.aditprayogo.bfaa_submission_1.data.UserData
import com.aditprayogo.bfaa_submission_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding : ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private lateinit var rvUser : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupAdapter()
    }

    private fun setupAdapter() {
        supportActionBar?.title = getString(R.string.list_github_user)
        val userList : List<User> = UserData.userData
        rvUser = binding.rvUser

        rvUser.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)

            val listUserAdapter = MainAdapter(this@MainActivity, userList)
            listUserAdapter.setActiivty(this@MainActivity)
            adapter = listUserAdapter
        }
    }


}