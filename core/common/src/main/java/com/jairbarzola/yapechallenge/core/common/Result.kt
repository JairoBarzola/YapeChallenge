package com.jairbarzola.yapechallenge.core.common

sealed class Result<T, U> {
    data class Success<T, U>(val value: T) : Result<T, U>()
    data class Error<T, U>(val value: U) : Result<T, U>()
}