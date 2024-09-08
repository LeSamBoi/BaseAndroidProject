package com.example.framework.wizard.database

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

// TODO: change classes name
@Entity(tableName = "wizards")
data class WizardEntity(
    @PrimaryKey(autoGenerate = false) val id: String,
    val actor: String,
    val house: String,
    val image: String,
    val name: String,
    val patronus: String,
    @Embedded val wand: WandEntity,
    val isFavorite: Boolean
)

data class WandEntity(
    val core: String,
    val length: Double?,
    val wood: String
)