package com.retailmotion.android.luastimer.ui.forecast

import com.retailmotion.android.luastimer.data.repository.WebRepository
import com.retailmotion.android.luastimer.ui.base.BaseViewModel
import com.retailmotion.android.luastimer.utils.SchedulerProvider
import com.retailmotion.android.luastimer.utils.network.NetworkHelper
import io.reactivex.disposables.CompositeDisposable

class ForecastViewModel(
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable,
    networkHelper: NetworkHelper,
    private val webRepository: WebRepository
) : BaseViewModel(schedulerProvider, compositeDisposable, networkHelper) {

    override fun onCreate() {

    }
}