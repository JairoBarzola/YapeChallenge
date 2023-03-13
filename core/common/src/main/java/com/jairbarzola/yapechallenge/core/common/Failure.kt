package com.jairbarzola.yapechallenge.core.common

sealed class Failure {
    data class Message(val message: String) : Failure()
    data class Exception(val t: Throwable) : Failure()
}