package com.nabiha.artikel.model

import android.graphics.drawable.Drawable
import android.media.Image
import java.io.Serializable

data class ArtikelModel(
    var id : Int,
    var image: Int,
    var title: String,
    var desc: String,
    var view: Int,
    var time: String
): Serializable
