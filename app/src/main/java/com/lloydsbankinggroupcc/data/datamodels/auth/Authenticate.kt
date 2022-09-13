package com.lloydsbankinggroupcc.data.datamodels.auth

import com.google.gson.annotations.SerializedName
import com.lloydsbankinggroupcc.BuildConfig
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Authenticate(
    @SerializedName("grant_type") val grantType: String = BuildConfig.grant_type,
    @SerializedName("client_id") val clientId: String = BuildConfig.client_id,
    @SerializedName("client_secret") val clientSecret: String = BuildConfig.client_secret
)



