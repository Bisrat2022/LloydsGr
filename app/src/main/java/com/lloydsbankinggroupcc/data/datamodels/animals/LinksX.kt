package com.lloydsbankinggroupcc.data.datamodels.animals


import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class LinksX(
    @PrimaryKey
    @SerializedName("id") val id: Int,
    @SerializedName("next") val next: Next?
)