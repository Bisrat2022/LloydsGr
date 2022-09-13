package com.lloydsbankinggroupcc.data.datamodels.animals


import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class Photo(
    @PrimaryKey
    @SerializedName("id") val id: Int,
    @SerializedName("full") val full: String?,
    @SerializedName("large") val large: String?,
    @SerializedName("medium") val medium: String?,
    @SerializedName("small") val small: String?
)