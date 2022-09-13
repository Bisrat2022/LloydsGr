package com.lloydsbankinggroupcc.data.datamodels.animals


import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class Pagination(
    @PrimaryKey
    @SerializedName("id") val id: Int = 1,
    @SerializedName("count_per_page") val countPerPage: Int?,
    @SerializedName("current_page") val currentPage: Int?,
    @SerializedName("_links") val links: LinksX?,
    @SerializedName("total_count") val totalCount: Int?,
    @SerializedName("total_pages") val totalPages: Int?
)