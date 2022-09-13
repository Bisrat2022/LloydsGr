package com.lloydsbankinggroupcc.data.datamodels.animals


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Attributes(
    @PrimaryKey
    @SerializedName("id") val id: Int = 1,
    @SerializedName("declawed") val declawed: Any?,
    @SerializedName("house_trained") val houseTrained: Boolean?,
    @SerializedName("shots_current") val shotsCurrent: Boolean?,
    @SerializedName("spayed_neutered") val spayedNeutered: Boolean?,
    @SerializedName("special_needs") val specialNeeds: Boolean?
)