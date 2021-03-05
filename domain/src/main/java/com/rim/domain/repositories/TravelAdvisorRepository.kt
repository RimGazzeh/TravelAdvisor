package com.rim.domain.repositories

/**
 * Created by Rim Gazzah on 3/4/21.
 **/
interface TravelAdvisorRepository {
    suspend fun getAllUrbanAreas()
    suspend fun searchCity(city: String)
    suspend fun getUAScore(uaId: String)
}