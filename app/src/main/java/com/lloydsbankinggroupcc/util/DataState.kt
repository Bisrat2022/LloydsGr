package com.lloydsbankinggroupcc.util

data class DataState(
    val status: Status,
    val message: String? = null
) {
    companion object {
        val SUCCESS = DataState(Status.SUCCESS)
        val LOADING = DataState(Status.LOADING)
        fun logError(message: String?) = DataState(Status.FAILED, message)
    }

    enum class Status {
        LOADING,
        SUCCESS,
        FAILED
    }
}

