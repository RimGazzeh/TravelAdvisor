package com.rim.data.common

import java.util.*

/**
 * Created by Rim Gazzah on 3/4/21.
 **/

fun getUAIdFromCityTitle(cityTitle: String): String {
    val regexNonAlphabeticChar = Regex("[^A-Za-z0-9 ]")
    cityTitle.apply {
        replace(regexNonAlphabeticChar, "-")
        toLowerCase(Locale.ROOT)
    }

    return "slug:$cityTitle"
}