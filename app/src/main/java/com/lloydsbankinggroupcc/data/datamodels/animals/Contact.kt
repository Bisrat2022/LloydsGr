package com.lloydsbankinggroupcc.data.datamodels.animals


import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class Contact(
    @PrimaryKey
    @SerializedName("id") val id: Int,
    @SerializedName("address") val address: Address?,
    @SerializedName("email") val email: String?,
    @SerializedName("phone") val phone: String?
)