package com.example.framework.core

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.framework.wizard.database.WizardDao
import com.example.framework.wizard.database.WizardEntity

// TODO: change class name and entity name
@Database(
    entities = [WizardEntity::class],
    version = 1,
    exportSchema = false
)
abstract class WizardsDatabase: RoomDatabase() {
    abstract fun wizardsDao(): WizardDao
}