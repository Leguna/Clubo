package com.arksana.clubo.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Liga(var name: String, var id: Int, var desc: String, var image: Int) : Parcelable