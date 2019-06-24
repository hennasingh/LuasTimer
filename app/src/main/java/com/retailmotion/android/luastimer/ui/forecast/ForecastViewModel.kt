package com.retailmotion.android.luastimer.ui.forecast

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.retailmotion.android.luastimer.data.model.Direction
import com.retailmotion.android.luastimer.data.repository.WebRepository
import com.retailmotion.android.luastimer.ui.base.BaseViewModel
import com.retailmotion.android.luastimer.utils.SchedulerProvider
import com.retailmotion.android.luastimer.utils.common.Resource
import com.retailmotion.android.luastimer.utils.common.TimeChecker
import com.retailmotion.android.luastimer.utils.network.NetworkHelper
import io.reactivex.disposables.CompositeDisposable

class ForecastViewModel(
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable,
    networkHelper: NetworkHelper,
    private val webRepository: WebRepository
) : BaseViewModel(schedulerProvider, compositeDisposable, networkHelper) {

    companion object {
        const val TAG = "ForecastViewModel"
        const val INBOUND = "Inbound"
        const val OUTBOUND = "Outbound"
        const val MAR = "Marlborough"
        const val STI = "Stillorgan"
    }

    private val forecastLiveData: MutableLiveData<Resource<Direction>> = MutableLiveData()
    private val destinationLiveData: MutableLiveData<String> = MutableLiveData()
    private val directionLiveData: MutableLiveData<String> = MutableLiveData()
    private val pbLoadingLiveData: MutableLiveData<Boolean> = MutableLiveData()

    fun getForecastData(): LiveData<Direction> = Transformations.map(forecastLiveData) {
        it.data
    }

    fun getDirectionField(): LiveData<String> = directionLiveData
    fun getDestinationField(): LiveData<String> = destinationLiveData
    fun getLoadVisibility(): LiveData<Boolean> = pbLoadingLiveData


    override fun onCreate() {

        getLuasForecast()
    }

    fun refreshData() = getLuasForecast()

    private fun getLuasForecast() {
        if (checkInternetConnectionWithMessage()) {

            forecastLiveData.postValue(Resource.loading())
            pbLoadingLiveData.postValue(true)

            if (TimeChecker.checkCurrentTime()) {

                compositeDisposable.add(
                    webRepository.doMarOutboundCall("forecast", "mar", false)
                        .subscribeOn(schedulerProvider.io())
                        .subscribe(
                            {
                                val name = it.get(1).name
                                if (name.equals(OUTBOUND)) {
                                    forecastLiveData.postValue(Resource.success(it.get(1)))
                                    directionLiveData.postValue(OUTBOUND)
                                    destinationLiveData.postValue(MAR)
                                    pbLoadingLiveData.postValue(false)
                                }
                            },
                            {
                                forecastLiveData.postValue(Resource.error())
                                pbLoadingLiveData.postValue(false)
                            }
                        )
                )

            } else {
                compositeDisposable.add(
                    webRepository.doStiInboundCall("forecast", "sti", false)
                        .subscribeOn(schedulerProvider.io())
                        .subscribe(
                            {
                                val name = it.get(0).name
                                if (name.equals(INBOUND)) {
                                    forecastLiveData.postValue(Resource.success(it.get(0)))
                                    directionLiveData.postValue(INBOUND)
                                    destinationLiveData.postValue(STI)
                                    pbLoadingLiveData.postValue(false)
                                }
                            },
                            {
                                handleNetworkError(it)
                                forecastLiveData.postValue(Resource.error())
                                pbLoadingLiveData.postValue(false)
                            })
                )
            }
        }
    }
}