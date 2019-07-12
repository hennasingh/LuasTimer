package com.retailmotion.android.luastimer.ui.forecast

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.retailmotion.android.luastimer.data.model.Direction
import com.retailmotion.android.luastimer.data.repository.WebRepository
import com.retailmotion.android.luastimer.utils.common.Resource
import com.retailmotion.android.luastimer.utils.network.NetworkHelper
import com.retailmotion.android.luastimer.utils.rx.TestSchedulerProvider
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.TestScheduler
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ForecastViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Mock
    private lateinit var networkHelper: NetworkHelper

    @Mock
    private lateinit var webRepository: WebRepository

    @Mock
    private lateinit var pbLoadingObserver: Observer<Boolean>

    @Mock
    private lateinit var messageStringIdObserver: Observer<Resource<Int>>

    private lateinit var testScheduler: TestScheduler

    private lateinit var forecastViewModel: ForecastViewModel

    @Mock
    private lateinit var directionList: Direction

    @Before
    fun setUp() {
        val compositeDisposable = CompositeDisposable()
        testScheduler = TestScheduler()
        val testSchedulerProvider = TestSchedulerProvider(testScheduler)
        forecastViewModel = ForecastViewModel(
            testSchedulerProvider,
            compositeDisposable,
            networkHelper,
            webRepository
        )
        forecastViewModel.getLoadVisibility().observeForever(pbLoadingObserver)
        forecastViewModel.messageStringId.observeForever(messageStringIdObserver)
    }


    @Test
    fun givenServerResponse200_whenInboundCall_shouldDisplayInboundForecast() {
        val action = "forecast"
        val stop = "sti"
        val encrypt = false
        val listDirections = Single.just(listOf(directionList))

        Mockito.doReturn(ForecastViewModel.INBOUND)
            .`when`(directionList)
            .name

        Mockito.doReturn(true)
            .`when`(networkHelper)
            .isNetworkConnected()
        Mockito.doReturn(listDirections)
            .`when`(webRepository)
            .doStiInboundCall(action, stop, encrypt)
        forecastViewModel.onCreate()
        forecastViewModel.getForecastData()
        testScheduler.triggerActions()
        assert(forecastViewModel.getLoadVisibility().value == false)
        Mockito.verify(pbLoadingObserver).onChanged(true)
        Mockito.verify(pbLoadingObserver).onChanged(false)
    }

    @After
    fun tearDown() {
        forecastViewModel.getLoadVisibility().removeObserver(pbLoadingObserver)
        forecastViewModel.messageStringId.removeObserver(messageStringIdObserver)
    }
}