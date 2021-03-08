package com.aditprayogo.bfaa_submission_1.ui.main

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aditprayogo.bfaa_submission_1.data.User

class MainAdapter(
    private val context: Context,
    private val listUsers: List<User>
) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    private lateinit var mainActivity: MainActivity

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(data : User) {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: MainAdapter.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int = listUsers.size

    fun setActiivty(activity: MainActivity) {
        this.mainActivity = activity
    }
}