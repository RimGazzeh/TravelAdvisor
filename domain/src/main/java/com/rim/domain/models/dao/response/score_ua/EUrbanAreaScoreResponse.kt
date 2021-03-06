package com.rim.domain.models.dao.response.score_ua

import com.google.gson.annotations.SerializedName
import com.rim.domain.models.entity.UrbanArea

data class EUrbanAreaScoreResponse(
    val categories: List<ECategory>,
    val summary: String,
    @SerializedName("teleport_city_score")
    val scoreUA: Double
)

fun EUrbanAreaScoreResponse.mapToEntity(nameUA: String) = UrbanArea(
    nameUA,
    categories.mapToEntity(),
    summary,
    scoreUA
)