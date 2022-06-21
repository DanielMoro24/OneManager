package com.morodaniel.onemanagerapp.extensions

import android.widget.ImageView
import com.squareup.picasso.Picasso

fun ImageView.imageUrl(imageUrl: Int) {
    Picasso.get().load(imageUrl).into(this)
}

fun ImageView.imageUrl2(imageUrl: String) {
    Picasso.get().load(imageUrl).into(this)
}