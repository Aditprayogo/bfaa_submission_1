package com.aditprayogo.bfaa_submission_1.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    private val username : String?,
    private val name : String?,
    private val avatar : Int?,
    private val company : String?,
    private val location : String?,
    private val repository : String?,
    private val follower : String?,
    private val following : String?
) : Parcelable