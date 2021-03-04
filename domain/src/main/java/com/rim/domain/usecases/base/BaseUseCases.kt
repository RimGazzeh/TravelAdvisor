package com.rim.domain.usecases.base

/**
 * Created by Rim Gazzah on 3/4/21.
 **/

interface BaseUseCaseWithoutInput<out RESPONSE> : BaseUseCase<Nothing, RESPONSE> {
    override fun invoke(request: Nothing): RESPONSE
}

interface BaseUseCase<in REQUEST, out RESPONSE> {
    operator fun invoke(request: REQUEST): RESPONSE
}