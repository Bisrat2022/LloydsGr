package com.lloydsbankinggroupcc.data.datamodels.auth


import com.google.gson.annotations.SerializedName

data class ErrorResponse400(
    @SerializedName("detail") val detail: String?,
    @SerializedName("invalid-params") val invalidParams: List<InvalidParam>?,
    @SerializedName("status") val status: Int?,
    @SerializedName("title") val title: String?,
    @SerializedName("type") val type: String?
)

data class InvalidParam(
    @SerializedName("in") val inX: String?,
    @SerializedName("message") val message: String?,
    @SerializedName("path") val path: String?
)