package com.rim.domain.models.entity

import com.sun.xml.internal.ws.developer.Serialization
import java.io.Serializable

@Serialization
data class ScoreCategory(
    val name: String,
    val score: Double
): Serializable