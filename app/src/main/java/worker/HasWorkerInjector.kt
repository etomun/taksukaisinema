package dagger.worker

import androidx.work.Worker
import dagger.android.AndroidInjector

/* Remove this if Dagger2 support Android Worker injection */
interface HasWorkerInjector {
    fun workerInjector(): AndroidInjector<Worker>
}