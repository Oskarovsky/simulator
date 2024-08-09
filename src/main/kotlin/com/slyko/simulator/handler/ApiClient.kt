package com.slyko.simulator.handler

import com.slyko.simulator.model.Account
import com.slyko.simulator.model.AccountUpdate
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*

class ApiClient(private val client: HttpClient) {

    suspend fun getAccounts(): List<Account> {
        return client.get("http://localhost:8080/account").body()
    }

    suspend fun getAccountById(id: String): Account {
        return client.get("http://localhost:8080/account/$id").body()
    }

    suspend fun createAccount(account: Account): Account {
        return client.post("http://localhost:8080/account") {
            contentType(ContentType.Application.Json)
            setBody(account)
        }.body()
    }

    suspend fun updateAccount(id: String, accountUpdate: AccountUpdate, etag: String): Account {
        return client.put("http://localhost:8080/account/$id") {
            contentType(ContentType.Application.Json)
            header(HttpHeaders.IfMatch, etag)
            setBody(accountUpdate)
        }.body()
    }
}