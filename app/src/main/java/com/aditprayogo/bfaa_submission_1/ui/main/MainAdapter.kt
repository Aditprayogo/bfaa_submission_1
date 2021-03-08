package com.aditprayogo.bfaa_submission_1.ui.main

import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair
import androidx.palette.graphics.Palette
import androidx.recyclerview.widget.RecyclerView
import com.aditprayogo.bfaa_submission_1.R
import com.aditprayogo.bfaa_submission_1.data.User
import com.aditprayogo.bfaa_submission_1.databinding.ItemRowUserBinding
import com.aditprayogo.bfaa_submission_1.ui.detail.DetailActivity
import com.aditprayogo.bfaa_submission_1.util.load

class MainAdapter(
    private val context: Context,
    private val listUsers: List<User>
) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    private lateinit var mainActivity: MainActivity

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding: ItemRowUserBinding = ItemRowUserBinding.bind(itemView)

        fun bind(data: User) {
            with(itemView) {
                binding.apply {
                    txtUsername.text = data.username
                    txtCompany.text = data.company
                    txtLocation.text = data.location
                    imgUser.load(data.avatar)

                    val bitmap =
                        data.avatar?.let { BitmapFactory.decodeResource(context.resources, it) }

                    bitmap?.let {
                        Palette.from(it).generate { pallete ->
                            val defValue = resources.getColor(R.color.black, context.theme)
                            cardViewItem.setCardBackgroundColor(
                                pallete?.getDarkMutedColor(defValue) ?: defValue
                            )
                        }
                    }

                    setOnClickListener {
                        val imagePair = Pair.create<View, String>(
                            binding.imgUser,
                            context.getString(R.string.imgUserPhoto)
                        )
                        val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                            mainActivity,
                            imagePair
                        )
                        context.startActivity(
                            Intent(context, DetailActivity::class.java).apply {
                                putExtra(DetailActivity.EXTRA_USER, data)
                            },
                            options.toBundle()
                        )
                    }
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_row_user, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MainAdapter.ViewHolder, position: Int) {
        holder.bind(listUsers[position])
    }

    override fun getItemCount(): Int = listUsers.size

    fun setActiivty(activity: MainActivity) {
        this.mainActivity = activity
    }
}