package com.retailmotion.android.luastimer.di.module

import androidx.lifecycle.ViewModelProviders
import com.retailmotion.android.luastimer.data.repository.WebRepository
import com.retailmotion.android.luastimer.ui.base.BaseActivity
import com.retailmotion.android.luastimer.ui.forecast.ForecastViewModel
import com.retailmotion.android.luastimer.utils.SchedulerProvider
import com.retailmotion.android.luastimer.utils.ViewModelProviderFactory
import com.retailmotion.android.luastimer.utils.network.NetworkHelper
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class ActivityModule(private val activity: BaseActivity<*>) {

    @Provides
    fun provideForecastViewModel(
        schedulerProvider: SchedulerProvider,
        compositeDisposable: CompositeDisposable,
        networkHelper: NetworkHelper,
        webRepository: WebRepository
    ): ForecastViewModel = ViewModelProviders.of(activity, ViewModelProviderFactory(ForecastViewModel::class) {
        ForecastViewModel(schedulerProvider, compositeDisposable, networkHelper, webRepository)
    }).get(ForecastViewModel::class.java)

    //@Provides
    //fun provideForecastAdapter() = ForecastAdapter(activity,ArrayList())
}