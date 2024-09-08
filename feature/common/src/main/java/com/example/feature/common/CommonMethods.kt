package com.example.feature.common

fun String.capitalize(): String {
    return this.replaceFirstChar(Char::titlecase)
}