package com.taksuinterview.kaisinema.common.di.module.util

import com.taksuinterview.kaisinema.common.di.scope.ApplicationScope
import com.taksuinterview.kaisinema.common.util.framework.DeviceUtil
import com.taksuinterview.kaisinema.common.util.framework.DeviceUtilFactory
import com.taksuinterview.kaisinema.common.util.helper.*
import com.taksuinterview.kaisinema.common.util.rx.RxScheduler
import com.taksuinterview.kaisinema.common.util.rx.RxSchedulerProvider
import com.taksuinterview.kaisinema.common.util.state.HttpState
import com.taksuinterview.kaisinema.data.repository.UserSessionFactory
import com.taksuinterview.kaisinema.domain.repository.UserSession
import dagger.Binds
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subjects.PublishSubject

@Module
internal abstract class UtilModule {
    @ApplicationScope
    @Binds
    abstract fun userSession(userSessionFactory: UserSessionFactory): UserSession

    @ApplicationScope
    @Binds
    abstract fun dataConverter(dataConverterFactory: DataConverterFactory): DataConverter

    @ApplicationScope
    @Binds
    abstract fun appValidator(appValidatorFactory: AppValidatorFactory): AppValidator

    @ApplicationScope
    @Binds
    abstract fun rxScheduler(rxSchedulerProvider: RxSchedulerProvider): RxScheduler

    @ApplicationScope
    @Binds
    abstract fun deviceUtil(deviceUtilFactory: DeviceUtilFactory): DeviceUtil

    @ApplicationScope
    @Binds
    abstract fun appConfig(appConfigFactory: AppConfigFactory): AppConfig

    @ApplicationScope
    @Binds
    abstract fun uiHelper(uiHelperFactory: UIHelperFactory): UIHelper

    companion object {
        @Provides
        fun compositeDisposable(): CompositeDisposable = CompositeDisposable()

        @ApplicationScope
        @Provides
        fun httpEvent(): PublishSubject<Pair<HttpState, String>> = PublishSubject.create()
    }
}