package com.slyko.simulator.model

import kotlinx.serialization.Serializable

@Serializable
data class Account(
    val id: String? = null,
    val version: Long?,
    val name: String,
    val type: String
)