package com.retailmotion.android.luastimer

import android.app.Application
import com.retailmotion.android.luastimer.di.component.ApplicationComponent
import com.retailmotion.android.luastimer.di.component.DaggerApplicationComponent
import com.retailmotion.android.luastimer.di.module.ApplicationModule

class LuasApplication : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        injectDependencies()
    }

    private fun injectDependencies() {
        applicationComponent = DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()

        applicationComponent.inject(this)

    }
}