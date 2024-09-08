package com.example.framework.core.hilt

import android.app.Application
import androidx.room.Room
import com.example.framework.core.WizardsClient
import com.example.framework.core.WizardsDatabase
import com.example.framework.core.common.API_URL
import com.example.framework.core.common.VAL_API_URL
import com.example.framework.core.common.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

// TODO: change name of functions and parameters
@Module
@InstallIn(SingletonComponent::class)
internal class FrameworkCoreModule {
    @Provides
    @Singleton
    fun provideWizardDao(db: WizardsDatabase) = db.wizardsDao()

    @Provides
    @Singleton
    fun provideWizardService(@Named(VAL_API_URL) apiUrl: String) = WizardsClient(apiUrl).instance
}
// TODO: change value wizards_db and api url
@Module
@InstallIn(SingletonComponent::class)
object FrameworkCoreExtrasModule {
    @Provides
    @Singleton
    fun provideDatabase(app: Application) = Room.databaseBuilder(
        app,
        WizardsDatabase::class.java,
        DATABASE_NAME
    ).build()

    @Provides
    @Singleton
    @Named(VAL_API_URL)
    fun provideApiUrl() = API_URL
}