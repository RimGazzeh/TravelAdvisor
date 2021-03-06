package com.rim.domain.models.dao.response.score_ua

import com.rim.domain.models.entity.ScoreCategory
import com.squareup.moshi.Json
import kotlin.math.round

data class ECategory(
    @field:Json(name = "name")
    val name: String,
    @field:Json(name = "score_out_of_10")
    val score: Double
)

fun ECategory.mapToEntity() = ScoreCategory(name, round(score * 100) / 10)
fun List<ECategory>.mapToEntity() = map { it.mapToEntity() }