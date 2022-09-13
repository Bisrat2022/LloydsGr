package com.lloydsbankinggroupcc.data.datamodels.animals


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Address(
    @PrimaryKey
    @SerializedName("id") val id: Int = 1,
    @SerializedName("address1") val address1: String?,
    @SerializedName("address2") val address2: Any?,
    @SerializedName("city") val city: String?,
    @SerializedName("country") val country: String?,
    @SerializedName("postcode") val postcode: String?,
    @SerializedName("state") val state: String?
)