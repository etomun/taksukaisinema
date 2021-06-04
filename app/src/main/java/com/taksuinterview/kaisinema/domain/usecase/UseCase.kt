package com.taksuinterview.kaisinema.domain.usecase

interface UseCase<RESULT, PARAM> {
    fun execute(param: PARAM): RESULT
}