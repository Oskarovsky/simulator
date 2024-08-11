package com.slyko.simulator

import com.slyko.simulator.api.AccountApiClient
import com.slyko.simulator.api.DealApiClient
import com.slyko.simulator.handler.Simulation
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import mu.KotlinLogging

private val logger = KotlinLogging.logger {}

fun main() {
    val accountApiClient = AccountApiClient.createClient()
    val dealApiClient = DealApiClient.createClient()
    val simulation = Simulation(accountApiClient, dealApiClient)

    // Start the simulation loop
    CoroutineScope(Dispatchers.IO).launch {
        while (true) {
            try {
                simulation.run()
            } catch (e: Exception) {
                logger.error(e) { "Failed to perform API operations" }
            }
            delay(10000)  // Delay for 10 seconds before retrying
        }
    }

    // Keep the application running
    println("Simulation started. Press Enter to exit.")
    readLine()
}