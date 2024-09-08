package com.example.framework.core

import com.example.framework.wizard.network.WizardService
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import retrofit2.create

// TODO: change class name
class WizardsClient(
    private val apiUrl: String,
) {
    private val contentType = "application/json".toMediaType()

    val instance = Retrofit.Builder()
        .baseUrl(apiUrl)
        .addConverterFactory(Json.asConverterFactory(contentType))
        .build()
        .create<WizardService>()
}