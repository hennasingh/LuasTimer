package com.retailmotion.android.luastimer.ui.forecast

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.retailmotion.android.luastimer.R
import com.retailmotion.android.luastimer.data.model.Tram

class ForecastAdapter(private var context: Context, private var tramList: List<Tram>?) :
    RecyclerView.Adapter<ForecastViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.tram_list_layout, parent, false)
        return ForecastViewHolder(view)
    }

    override fun getItemCount(): Int {
        return tramList?.size ?: 0
    }

    override fun onBindViewHolder(holder: ForecastViewHolder, position: Int) {
        val tram = tramList?.get(position)
        holder.bindValues(tram, position + 1)
    }

    fun updateData(list: List<Tram>?) {
        tramList = list
        notifyDataSetChanged()
    }
}