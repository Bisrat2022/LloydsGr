package com.lloydsbankinggroupcc.data.datamodels.animals


import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class Links(
    @PrimaryKey
    @SerializedName("id") val id: Int,
    @SerializedName("organization") val organization: Organization?,
    @SerializedName("self") val self: Self?,
    @SerializedName("type") val type: Type?
)