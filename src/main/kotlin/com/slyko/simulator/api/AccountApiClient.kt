package com.slyko.simulator.api

import com.slyko.simulator.model.Account
import com.slyko.simulator.model.AccountUpdate
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class AccountApiClient(private val client: HttpClient) {

    suspend fun createAccount(account: Account): Account {
        return client.post("http://localhost:8080/account") {
            contentType(ContentType.Application.Json)
            setBody(account)
        }.body()
    }

    suspend fun getAccounts(): List<Account> {
        return client.get("http://localhost:8080/account").body()
    }

    suspend fun updateAccount(id: String, accountUpdate: AccountUpdate, etag: String): Account {
        return client.put("http://localhost:8080/account/$id") {
            contentType(ContentType.Application.Json)
            setBody(accountUpdate)
            header(HttpHeaders.IfMatch, etag)
        }.body()
    }

    companion object {
        fun createClient(): AccountApiClient {
            val client = HttpClient {
                install(ContentNegotiation) {
                    json(Json { ignoreUnknownKeys = true })
                }
                install(Logging) {
                    level = LogLevel.INFO
                }
            }
            return AccountApiClient(client)
        }
    }
}