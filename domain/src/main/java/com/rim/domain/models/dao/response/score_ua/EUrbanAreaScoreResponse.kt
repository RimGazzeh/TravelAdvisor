package com.rim.domain.models.dao.response.score_ua

import com.rim.domain.models.entity.UrbanArea
import com.squareup.moshi.Json

data class EUrbanAreaScoreResponse(
    @field:Json(name = "categories")
    val categories: List<ECategory>,
    @field:Json(name = "summary")
    val summary: String,
    @field:Json(name = "teleport_city_score")
    val scoreUA: Double
)

fun EUrbanAreaScoreResponse.mapToEntity(nameUA: String) = UrbanArea(
    nameUA,
    categories.mapToEntity(),
    summary,
    scoreUA
)