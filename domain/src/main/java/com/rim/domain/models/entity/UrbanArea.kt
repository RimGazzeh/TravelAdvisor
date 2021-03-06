package com.rim.domain.models.entity

/**
 * Created by Rim Gazzah on 3/6/21.
 **/
data class UrbanArea(
    val name: String,
    val categories: List<ScoreCategory>,
    val summary: String,
    val scoreUA: Double
)
