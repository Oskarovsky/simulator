package com.slyko.simulator.model

import kotlinx.serialization.Serializable

@Serializable
data class Deal(
    val id: String? = null,
    val version: Long? = null,
    val title: String? = null,
    val status: String? = null,
    val accountId: String? = null,
    val products: List<Product> = emptyList()
)

enum class Status {
    PAYMENT_EXPECTED,
    PAID,
    PREPARING,
    READY,
    NEW,
    DONE
}