package com.rim.domain.models.dao.response.image_ua

data class EImageUA(val photos: List<EPhoto>)
data class EPhoto(val image: EImage)
data class EImage(val mobile: String)

fun EImageUA.getFirstImage(): String? = photos.firstOrNull()?.image?.mobile