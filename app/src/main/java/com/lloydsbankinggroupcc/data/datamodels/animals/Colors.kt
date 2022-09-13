package com.lloydsbankinggroupcc.data.datamodels.animals


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Colors(
    @PrimaryKey
    @SerializedName("id") val id: Int = 1,
    @SerializedName("primary") val primary: String?,
    @SerializedName("secondary") val secondary: String?,
    @SerializedName("tertiary") val tertiary: Any?
)