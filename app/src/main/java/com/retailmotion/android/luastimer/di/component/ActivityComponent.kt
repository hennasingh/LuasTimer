package com.retailmotion.android.luastimer.di.component

import com.retailmotion.android.luastimer.di.ActivityScope
import com.retailmotion.android.luastimer.di.module.ActivityModule
import com.retailmotion.android.luastimer.ui.forecast.ForecastActivity
import dagger.Component

@ActivityScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [ActivityModule::class]
)
interface ActivityComponent {

    fun inject(activity: ForecastActivity)
}