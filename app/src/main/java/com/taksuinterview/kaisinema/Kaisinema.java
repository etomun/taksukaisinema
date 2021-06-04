package com.taksuinterview.kaisinema;

import android.content.Context;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.lifecycle.LifecycleObserver;
import androidx.multidex.MultiDex;
import androidx.work.Worker;

import com.taksuinterview.kaisinema.common.di.component.DaggerAppComponent;

import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.DaggerApplication;
import dagger.worker.HasWorkerInjector;
import io.reactivex.plugins.RxJavaPlugins;
import timber.log.Timber;

public class Kaisinema extends DaggerApplication implements HasWorkerInjector, LifecycleObserver {
    @Inject
    protected DispatchingAndroidInjector<Worker> dispatchingAndroidInjector;

    @Override
    public void onCreate() {
        super.onCreate();
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
        RxJavaPlugins.setErrorHandler(Timber::e);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().application(this).build();
    }

    @NotNull
    @Override
    public AndroidInjector<Worker> workerInjector() {
        return dispatchingAndroidInjector;
    }
}