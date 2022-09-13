package com.lloydsbankinggroupcc.data.datamodels.animals


import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class Organization(
    @PrimaryKey
    @SerializedName("id") val id: Int,
    @SerializedName("href") val href: String?
)