package com.rim.domain.models.dao.response.all_ua

import com.squareup.moshi.Json

data class ELinks(
    @field:Json(name = "ua:item")
    val item: List<EUrbanArea>
)
