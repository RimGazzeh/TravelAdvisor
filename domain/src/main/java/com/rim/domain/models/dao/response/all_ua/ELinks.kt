package com.rim.domain.models.dao.response.all_ua

import com.google.gson.annotations.SerializedName

data class ELinks(
    @SerializedName("ua:item")
    val item: List<EUrbanArea>
)
