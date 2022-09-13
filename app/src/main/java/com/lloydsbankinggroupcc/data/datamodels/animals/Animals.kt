package com.lloydsbankinggroupcc.data.datamodels.animals


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Animals(
    @PrimaryKey
    @SerializedName("id") val id: Int = 1,
    @SerializedName("animals") val animals: List<Animal>?,
    @SerializedName("pagination") val pagination: Pagination?
)