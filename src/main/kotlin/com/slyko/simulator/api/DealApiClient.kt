package com.slyko.simulator.api

import com.slyko.simulator.model.Deal
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class DealApiClient(private val client: HttpClient) {

    suspend fun createDeal(deal: Deal): Deal {
        return client.post("http://localhost:8080/deal") {
            contentType(ContentType.Application.Json)
            setBody(deal)
        }.body()
    }

    companion object {
        fun createClient(): DealApiClient {
            val client = HttpClient {
                install(ContentNegotiation) {
                    json(Json { ignoreUnknownKeys = true })
                }
                install(Logging) {
                    level = LogLevel.INFO
                }
            }
            return DealApiClient(client)
        }
    }
}