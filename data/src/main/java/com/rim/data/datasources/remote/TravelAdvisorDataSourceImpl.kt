package com.rim.data.datasources.remote

import com.rim.data.common.asyncAll
import com.rim.data.common.getUAIdFromName
import com.rim.data.remote.ApiServices
import com.rim.domain.common.CallErrors
import com.rim.domain.common.CallResult
import com.rim.domain.data_source.TravelAdvisorDataSource
import com.rim.domain.models.dao.response.all_ua.mapToUrbanAreaNameList
import com.rim.domain.models.dao.response.score_ua.mapToEntity
import com.rim.domain.models.entity.UrbanArea
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.withContext

/**
 * Created by Rim Gazzah on 3/6/21.
 **/
class TravelAdvisorDataSourceImpl(private val apiServices: ApiServices) : TravelAdvisorDataSource {
    override suspend fun getUAScore(uaName: String): UrbanArea? =
        apiServices.getUAScore(getUAIdFromName(uaName)).run {
            if (isSuccessful && body() != null) {
                body()!!.mapToEntity(uaName)
            } else {
                return null
            }
        }

    override suspend fun getUrbanAreasWihScores(): CallResult<List<UrbanArea>> {
        apiServices.getAllUrbanAreas().let { response ->
            if (response.isSuccessful) {
                if (response.body() != null) {
                    val listUA: List<String> = response.body()!!.mapToUrbanAreaNameList()
                    val listUAWithScore = mutableListOf<UrbanArea>()
                    //run list of Retrofit requests asynchronously, this should reduce the time considerably
                    //Although it is not a good practice to do this operation client side, just in this case of WS structure
                    withContext(Dispatchers.IO) {
                        asyncAll(listUA) { getUAScore(it) }
                            .awaitAll()
                            .forEach { responseScore ->
                                responseScore?.let { listUAWithScore.add(it) }
                            }
                    }
                    return if (listUAWithScore.isNotEmpty()) {
                        CallResult.Success(listUAWithScore)
                    } else {
                        CallResult.Error(CallErrors.ErrorEmptyData)
                    }
                } else {
                    return CallResult.Error(CallErrors.ErrorEmptyData)
                }
            } else {
                return CallResult.Error(CallErrors.ErrorServer)
            }
        }
    }
}