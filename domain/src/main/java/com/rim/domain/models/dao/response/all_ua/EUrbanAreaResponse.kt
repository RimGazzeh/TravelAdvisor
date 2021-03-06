package com.rim.domain.models.dao.response.all_ua

import com.google.gson.annotations.SerializedName

data class EUrbanAreaResponse(
    @SerializedName("_links")
    val links: ELinks,
    val count: Int
)

fun EUrbanAreaResponse.mapToUrbanAreaNameList(): List<String> = run {
    if (count > 12) this.links.item.take(12) else links.item
}.map { it.name }


