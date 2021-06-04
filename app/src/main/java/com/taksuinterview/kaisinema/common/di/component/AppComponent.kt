package com.taksuinterview.kaisinema.common.di.component

import android.app.Application
import com.taksuinterview.kaisinema.Kaisinema
import com.taksuinterview.kaisinema.common.di.module.AppModule
import com.taksuinterview.kaisinema.common.di.scope.ApplicationScope
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import dagger.worker.AndroidWorkerInjectionModule

@ApplicationScope
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AndroidWorkerInjectionModule::class,
        AppModule::class
    ]
)
interface AppComponent : AndroidInjector<Kaisinema> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}