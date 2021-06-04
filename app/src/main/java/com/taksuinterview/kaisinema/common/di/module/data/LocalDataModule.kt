package com.taksuinterview.kaisinema.common.di.module.data

import android.content.Context
import androidx.room.Room
import com.taksuinterview.kaisinema.common.di.qualifier.android.ApplicationContext
import com.taksuinterview.kaisinema.common.di.scope.ApplicationScope
import com.taksuinterview.kaisinema.data.local.database.AppDatabase
import com.taksuinterview.kaisinema.data.local.preference.AppPreference
import com.taksuinterview.kaisinema.data.local.preference.AuthPreference
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module(includes = [LocalDataSourceModule::class])
internal abstract class LocalDataModule {

    @ApplicationScope
    @Binds
    abstract fun authPref(authPreference: AuthPreference): AppPreference.AuthPref

    companion object {
        @ApplicationScope
        @Provides
        fun appDatabase(@ApplicationContext context: Context): AppDatabase =
            Room.databaseBuilder(context, AppDatabase::class.java, AppDatabase.DB_NAME)
                .fallbackToDestructiveMigration()
                .build()

    }

}