package com.example.framework.wizard.hilt

import com.example.domain.wizard.data.LocalWizardsDataSource
import com.example.domain.wizard.data.RemoteWizardsDataSource
import com.example.framework.wizard.database.RoomDataSource
import com.example.framework.wizard.network.RetrofitDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

// TODO: change functions name
@Module
@InstallIn(SingletonComponent::class)
internal abstract class FrameworkWizardModule {
    @Binds
    abstract fun bindRemoteWizardsDataSource(
        retrofitDataSource: RetrofitDataSource
    ): RemoteWizardsDataSource

    @Binds
    abstract fun bindLocalWizardsDataSource(
        roomDataSource: RoomDataSource
    ): LocalWizardsDataSource

}