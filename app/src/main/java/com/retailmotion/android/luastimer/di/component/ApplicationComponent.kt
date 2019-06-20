package com.retailmotion.android.luastimer.di.component

import android.app.Application
import com.retailmotion.android.luastimer.LuasApplication
import com.retailmotion.android.luastimer.data.remote.NetworkService
import com.retailmotion.android.luastimer.data.repository.WebRepository
import com.retailmotion.android.luastimer.di.module.ApplicationModule
import com.retailmotion.android.luastimer.utils.SchedulerProvider
import com.retailmotion.android.luastimer.utils.network.NetworkHelper
import dagger.Component
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(app: LuasApplication)

    fun getApplication(): Application

    fun getSchedulerProvider(): SchedulerProvider

    fun getCompositeDisposable(): CompositeDisposable

    fun getNetworkingService(): NetworkService

    fun getNetworkHelper(): NetworkHelper

    fun getWebRepository(): WebRepository
}