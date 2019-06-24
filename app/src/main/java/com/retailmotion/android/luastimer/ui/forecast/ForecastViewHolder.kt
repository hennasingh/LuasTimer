package com.retailmotion.android.luastimer.ui.forecast

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.retailmotion.android.luastimer.data.model.Tram
import kotlinx.android.synthetic.main.tram_list_layout.view.*

class ForecastViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val srNumber = itemView.tv_number
    val destination = itemView.tv_destination
    val dueMin = itemView.tv_mins

    fun bindValues(tram: Tram?, position: Int) {
        destination.text = tram?.destination
        dueMin.text = tram?.dueMins
        srNumber.text = position.toString()
    }

}