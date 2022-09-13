package com.lloydsbankinggroupcc.data.datamodels.auth


import com.google.gson.annotations.SerializedName

data class ErrorAuthResponse401(
    @SerializedName("detail") val detail: String?,
    @SerializedName("status") val status: Int?,
    @SerializedName("title") val title: String?,
    @SerializedName("type") val type: String?
)