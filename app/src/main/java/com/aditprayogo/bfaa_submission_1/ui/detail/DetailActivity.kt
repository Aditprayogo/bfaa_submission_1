package com.aditprayogo.bfaa_submission_1.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.aditprayogo.bfaa_submission_1.data.User
import com.aditprayogo.bfaa_submission_1.databinding.ActivityDetailBinding
import com.aditprayogo.bfaa_submission_1.util.load

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_USER = "extra_user"
    }

    private val binding: ActivityDetailBinding by lazy {
        ActivityDetailBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupUi()
    }

    private fun setupUi() {
        val data = intent.getParcelableExtra<User>(EXTRA_USER)

        supportActionBar?.apply {
            elevation = 0f
            title = data?.name
            setDisplayHomeAsUpEnabled(true)
        }

        binding.apply {
            data?.let { user ->
                imgPhotoDetailUser.load(user.avatar)
                txtName.text = user.name
                txtUsername.text = user.username
                txtCompany.text = user.company
                txtLocation.text = user.location
                txtRepository.text = user.repository
                txtFollower.text = user.follower
                txtFollowing.text = user.following
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }


}