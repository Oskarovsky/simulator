package com.slyko.simulator.handler

import com.slyko.simulator.api.AccountApiClient
import com.slyko.simulator.api.DealApiClient
import com.slyko.simulator.model.Account
import com.slyko.simulator.model.AccountUpdate
import com.slyko.simulator.model.Deal
import com.slyko.simulator.model.Status
import java.util.*
import kotlin.random.Random

class Simulation(
    private val accountApiClient: AccountApiClient,
    private val dealApiClient: DealApiClient
) {

    suspend fun run() {
//        simulateAccounts()
        simulateDeals()
    }

    private suspend fun simulateAccounts() {
        // Create a new account
        val newAccount = accountApiClient.createAccount(
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
        val accounts = accountApiClient.getAccounts()
        println("Current accounts: $accounts")

        // Update an account
        if (accounts.isNotEmpty()) {
            val accountToUpdate = accounts.random()
            val updatedAccount = accountApiClient.updateAccount(
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

    private suspend fun simulateDeals() {
        val accId = accountApiClient.getAccounts().get(2).id
        println("DEEJYA -- > $accId")
        // Create new deal
        val newDeal = dealApiClient.createDeal(
            Deal(
                title = "Deal ${Random.nextInt(1000)}",
                version = null,
                status = "NEW",
                accountId = accId,
                products = listOf()
            )
        )
        println("Created deal: $newDeal")
        // Wait for a bit
        kotlinx.coroutines.delay(1000)
    }
}