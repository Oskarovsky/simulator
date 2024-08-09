package com.slyko.simulator.handler

import ApiClient
import com.slyko.simulator.model.Account
import com.slyko.simulator.model.AccountUpdate
import kotlin.random.Random

class Simulation(private val apiClient: ApiClient) {

    suspend fun run() {
        // Create a new account
        val newAccount = apiClient.createAccount(
            Account(
                name = "Account ${Random.nextInt(1000)}",
                version = null,
                type = "BUSINESS"
            )
        )
        println("Created account: $newAccount")

        // Wait for a bit
        kotlinx.coroutines.delay(1000)

        // Get all accounts
        val accounts = apiClient.getAccounts()
        println("Current accounts: $accounts")

        // Update an account
        if (accounts.isNotEmpty()) {
            val accountToUpdate = accounts.random()
            val updatedAccount = apiClient.updateAccount(
                accountToUpdate.id!!,
                AccountUpdate(
                    id = accountToUpdate.id,
                    name = "Updated ${accountToUpdate.name}",
                    version = accountToUpdate.version,
                    type = "PRIVATE"
                ),
                accountToUpdate.version.toString()  // Example ETag, replace with the actual one
            )
            println("Updated account: $updatedAccount")
        }
    }
}