package com.example.framework.wizard.network

import retrofit2.http.GET
import retrofit2.http.Path

// TODO: change queries and functions name
interface WizardService {
    @GET("characters/house/{house}")
    suspend fun getWizardsSortedByHouse(@Path("house") house: String): List<WizardResult>

    @GET("character/{id}")
    suspend fun getWizardById(@Path("id") id: String): List<WizardResult>
}