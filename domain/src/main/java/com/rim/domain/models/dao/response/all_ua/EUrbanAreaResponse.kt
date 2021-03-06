package com.rim.domain.models.dao.response.all_ua

import com.squareup.moshi.Json

data class EUrbanAreaResponse(
    @field:Json(name = "_links")
    val links: ELinks,
    @field:Json(name = "count")
    val count: Int
)

fun EUrbanAreaResponse.mapToUrbanAreaNameList(): List<String> = run {
    if (count > 18) this.links.item.take(18) else links.item
}.map { it.name }


