package com.slyko.simulator

import ApiClient
import com.slyko.simulator.handler.Simulation
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import mu.KotlinLogging

private val logger = KotlinLogging.logger {}

fun main() {
    val apiClient = ApiClient.createClient()
    val simulation = Simulation(apiClient)

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