package com.rim.domain.usecases.base

/**
 * Created by Rim Gazzah on 3/4/21.
 **/

interface BaseUseCase<out RESPONSE>  {
     suspend operator fun invoke(): RESPONSE
}

interface BaseUseCaseWithInput<in REQUEST, out RESPONSE> {
    suspend operator fun invoke(request: REQUEST): RESPONSE
}