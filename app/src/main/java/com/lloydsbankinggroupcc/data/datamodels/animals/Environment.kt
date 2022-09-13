package com.lloydsbankinggroupcc.data.datamodels.animals


import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class Environment(
    @PrimaryKey
    @SerializedName("id") val id: Int,
    @SerializedName("cats") val cats: Any?,
    @SerializedName("children") val children: Any?,
    @SerializedName("dogs") val dogs: Any?
)