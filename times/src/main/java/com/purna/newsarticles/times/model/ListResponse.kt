package com.purna.newsarticles.times.model


import com.google.gson.annotations.SerializedName

data class ListResponse<T>(
    @SerializedName("copyright")
    val copyright: String,
    @SerializedName("last_updated")
    val lastUpdated: String,
    @SerializedName("num_results")
    val numResults: Int,
    @SerializedName("results")
    val results: List<T>,
    @SerializedName("section")
    val section: String,
    @SerializedName("status")
    val status: String
)