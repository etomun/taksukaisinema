package com.taksuinterview.kaisinema.common.di.module.receiver;

import com.taksuinterview.kaisinema.common.util.framework.ConnectivityReceiver;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class BroadcastReceiverBuilder {

    @ContributesAndroidInjector
    abstract ConnectivityReceiver connectivityReceiver();

}
