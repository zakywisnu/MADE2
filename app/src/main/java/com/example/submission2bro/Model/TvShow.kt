package com.example.submission2bro.Model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TvShow(
    val tvShowName: String?,
    val tvShowYear: String?,
    val tvShowRate: String?,
    val imgTvShow: Int,
    val tvShowDescription: String?
) : Parcelable