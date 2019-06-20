package com.retailmotion.android.luastimer.di.module

import android.app.Application
import com.retailmotion.android.luastimer.BuildConfig
import com.retailmotion.android.luastimer.LuasApplication
import com.retailmotion.android.luastimer.data.remote.NetworkService
import com.retailmotion.android.luastimer.data.remote.Networking
import com.retailmotion.android.luastimer.utils.SchedulerProvider
import com.retailmotion.android.luastimer.utils.network.NetworkHelper
import com.retailmotion.android.luastimer.utils.rx.RxSchedulerProvider
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Module
class ApplicationModule(private val application: LuasApplication) {

    @Provides
    @Singleton
    fun provideApplication(): Application = application

    @Provides
    fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()

    @Provides
    fun provideSchedulerProvider(): SchedulerProvider = RxSchedulerProvider()

    @Provides
    @Singleton
    fun provideNetworkingService(): NetworkService =
        Networking.create(
            BuildConfig.BASE_URL,
            application.cacheDir,
            10 * 1024 * 1024
        )

    @Singleton
    @Provides
    fun provideNetworkHelper(): NetworkHelper = NetworkHelper(application)

}