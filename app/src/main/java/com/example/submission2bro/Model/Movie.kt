package com.example.submission2bro.Model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    val movieName: String?,
    val movieYear: String?,
    val movieRate: String?,
    val imgMovie: Int,
    val movieDescription: String?
) : Parcelable