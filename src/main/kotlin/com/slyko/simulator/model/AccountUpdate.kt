package com.slyko.simulator.model

import kotlinx.serialization.Serializable

@Serializable
data class AccountUpdate(
    val id: String,
    val name: String,
    val type: String
)