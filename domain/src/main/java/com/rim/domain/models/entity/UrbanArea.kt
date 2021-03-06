package com.rim.domain.models.entity

/**
 * Created by Rim Gazzah on 3/6/21.
 **/
data class UrbanArea(
    val name: String,
    val categories: List<ScoreCategory>,
    val summary: String,
    val scoreUA: Double
) {
    fun getTravelScoreCategories() = categories.filter {
        it.name == ScoreCategoryTypes.OUTDOORS.value
                || it.name == ScoreCategoryTypes.LEISURE.value
                || it.name == ScoreCategoryTypes.TRAVEL_CONNECTIVITY.value
    }
}

enum class ScoreCategoryTypes(val value: String) {
    OUTDOORS("Outdoors"),
    LEISURE("Leisure & Culture"),
    TRAVEL_CONNECTIVITY("Travel Connectivity")
}

