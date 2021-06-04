package com.taksuinterview.kaisinema.common.di.module

import android.app.Application
import android.content.Context
import com.taksuinterview.kaisinema.common.di.module.data.DataModule
import com.taksuinterview.kaisinema.common.di.module.presentation.ActivityBuilder
import com.taksuinterview.kaisinema.common.di.module.presentation.FragmentBuilder
import com.taksuinterview.kaisinema.common.di.module.receiver.BroadcastReceiverBuilder
import com.taksuinterview.kaisinema.common.di.module.service.ServiceBuilder
import com.taksuinterview.kaisinema.common.di.module.util.UtilModule
import com.taksuinterview.kaisinema.common.di.qualifier.android.ApplicationContext
import com.taksuinterview.kaisinema.common.di.scope.ApplicationScope
import dagger.Binds
import dagger.Module

@Module(
    includes = [
        DataModule::class,
        ActivityBuilder::class,
        FragmentBuilder::class,
        BroadcastReceiverBuilder::class,
        ServiceBuilder::class,
        UtilModule::class
    ]
)
abstract class AppModule {
    @ApplicationScope
    @ApplicationContext
    @Binds
    abstract fun context(application: Application): Context
}