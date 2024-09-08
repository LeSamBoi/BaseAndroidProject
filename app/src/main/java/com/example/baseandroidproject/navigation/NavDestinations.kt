package com.example.baseandroidproject.navigation

import kotlinx.serialization.Serializable

// TODO: Change destinations name if necessary
@Serializable
object Home

@Serializable
data class Detail(val id: String)