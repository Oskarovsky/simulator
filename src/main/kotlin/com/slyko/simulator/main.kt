package com.slyko.simulator

import com.slyko.simulator.handler.ApiClient
import com.slyko.simulator.model.Account
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json
import kotlin.random.Random

fun main() = runBlocking {
    val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(Json { prettyPrint = true })
        }
    }

    val apiClient = ApiClient(client)

    // Example simulation loop
    while (true) {
        // Create a new account
        val newAccount = apiClient
            .createAccount(
                Account(
                    name = "Account ${Random.nextInt(1000)}",
                    version = null,
                    type = "BUSINESS"
                )
            )
        println("Created account: $newAccount")

        // Wait for a bit
        delay(1000)

        // Get all accounts
        val accounts = apiClient.getAccounts()
        println("Current accounts: $accounts")

        // Update an account
//        if (accounts.isNotEmpty()) {
//            val accountToUpdate = accounts.random()
//            val updatedAccount = apiClient.updateAccount(
//                accountToUpdate.id!!,
//                AccountUpdate(id = accountToUpdate.id, name = "Updated ${accountToUpdate.name}", type = "PRIVATE"),
//                "1"  // Example ETag, replace with the actual one
//            )
//            println("Updated account: $updatedAccount")
//        }

        // Wait for a bit before the next iteration
//        delay(10000)
    }
}