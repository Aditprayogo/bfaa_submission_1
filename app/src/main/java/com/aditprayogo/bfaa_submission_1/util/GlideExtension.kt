package com.aditprayogo.bfaa_submission_1.util

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory

fun ImageView.load(imageResource: Any?) {
    Glide.with(context.applicationContext)
        .load(imageResource)
        .transition(DrawableTransitionOptions.withCrossFade(getDrawableFactory()))
        .into(this)
}

private fun getDrawableFactory(): DrawableCrossFadeFactory {
    return DrawableCrossFadeFactory.Builder().setCrossFadeEnabled(true).build()
}