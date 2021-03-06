package com.rim.domain.models.dao.response.score_ua

import com.google.gson.annotations.SerializedName
import com.rim.domain.models.entity.ScoreCategory

data class ECategory(
    val name: String,
    @SerializedName("score_out_of_10")
    val score: Double
)

fun ECategory.mapToEntity() = ScoreCategory(name, score)
fun List<ECategory>.mapToEntity() = map { it.mapToEntity() }