package com.lloydsbankinggroupcc.data.datamodels.animals


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Breeds(
    @PrimaryKey
    @SerializedName("id") val id: Int = 1,
    @SerializedName("mixed") val mixed: Boolean?,
    @SerializedName("primary") val primary: String?,
    @SerializedName("secondary") val secondary: Any?,
    @SerializedName("unknown") val unknown: Boolean?
)