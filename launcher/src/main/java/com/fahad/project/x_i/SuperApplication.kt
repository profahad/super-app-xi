package com.fahad.project.x_i

import android.app.Activity
import android.app.Application
import android.os.Bundle
import com.fahad.project.common.base.BaseApplication
import com.fahad.project.common_domain.providers.CurrentActivityProvider
import dagger.hilt.android.HiltAndroidApp
import androidx.hilt.work.HiltWorkerFactory
import androidx.work.Configuration
/*import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager*/
import javax.inject.Inject

@HiltAndroidApp
class SuperApplication :
    BaseApplication(),
    Application.ActivityLifecycleCallbacks,
    CurrentActivityProvider,
    Configuration.Provider {

    @Inject
    lateinit var workerFactory: HiltWorkerFactory

    override fun getWorkManagerConfiguration() =
        Configuration.Builder()
            .setWorkerFactory(workerFactory)
            .build()

    private lateinit var currentActivity: Activity

    override fun onCreate() {
        super.onCreate()
        registerActivityLifecycleCallbacks(this)
        //setupRecurringWork()
    }

    /*private fun setupRecurringWork() {
        WorkManager.getInstance(applicationContext).apply {

        }
    }*/

    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {}
    override fun onActivityStarted(activity: Activity) {}
    override fun onActivityResumed(activity: Activity) {
        currentActivity = activity
    }

    override fun onActivityPaused(activity: Activity) {}
    override fun onActivityStopped(activity: Activity) {}
    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {}
    override fun onActivityDestroyed(activity: Activity) {}
    override fun get(): Activity = currentActivity
}
