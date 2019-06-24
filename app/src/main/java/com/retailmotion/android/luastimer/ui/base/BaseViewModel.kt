package com.retailmotion.android.luastimer.ui.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.retailmotion.android.luastimer.R
import com.retailmotion.android.luastimer.utils.SchedulerProvider
import com.retailmotion.android.luastimer.utils.common.Resource
import com.retailmotion.android.luastimer.utils.network.NetworkHelper
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel(
    protected val schedulerProvider: SchedulerProvider,
    protected val compositeDisposable: CompositeDisposable,
    protected val networkHelper: NetworkHelper
) : ViewModel() {

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }

    val messageStringId: MutableLiveData<Resource<Int>> = MutableLiveData()
    val messageString: MutableLiveData<Resource<String>> = MutableLiveData()

    protected fun checkInternetConnectionWithMessage(): Boolean =
        if (networkHelper.isNetworkConnected()) {
            true
        } else {
            messageStringId.postValue(Resource.error(R.string.no_internet_error))
            false
        }

    protected fun handleNetworkError(error: Throwable?) {
        error?.let {
            messageString.postValue(Resource.error(it.message))
        }
    }

    abstract fun onCreate()
}