package com.bangkit.ilt_5

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Artist (
    var photo : String,
    var name : String ) : Parcelable