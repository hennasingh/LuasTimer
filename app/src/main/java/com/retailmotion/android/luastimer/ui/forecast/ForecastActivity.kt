package com.retailmotion.android.luastimer.ui.forecast

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.retailmotion.android.luastimer.R
import com.retailmotion.android.luastimer.di.component.ActivityComponent
import com.retailmotion.android.luastimer.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_forecast.*

class ForecastActivity : BaseActivity<ForecastViewModel>() {

    lateinit var forecastAdapter: ForecastAdapter

    override fun provideLayoutId(): Int = R.layout.activity_forecast

    override fun injectDependencies(activityComponent: ActivityComponent) = activityComponent.inject(this)

    override fun setupView(savedInstanceState: Bundle?) {

        rv_trams.layoutManager = LinearLayoutManager(this)
        forecastAdapter = ForecastAdapter(this, ArrayList())
        rv_trams.adapter = forecastAdapter

        btn_refresh.setOnClickListener {
            viewModel.refreshData()
        }
    }

    override fun setupObservers() {
        super.setupObservers()

        viewModel.getForecastData().observe(this, Observer {
            forecastAdapter.updateData(it?.trams)
        })

        viewModel.getDestinationField().observe(this, Observer {
            tvluas_station.text = it
        })

        viewModel.getDirectionField().observe(this, Observer {
            tvluas_direction.text = it
        })

        viewModel.getLoadVisibility().observe(this, Observer {
            pb_loading.visibility = if (it) View.VISIBLE else View.GONE
        })
    }
}
