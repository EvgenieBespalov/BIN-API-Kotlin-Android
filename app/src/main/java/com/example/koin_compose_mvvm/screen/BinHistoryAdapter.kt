package com.example.koin_compose_mvvm.screen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.koin_compose_mvvm.R
import com.example.koin_compose_mvvm.domain.entity.MainData

class BinHistoryAdapter(private val userClickListener: (MainData) -> Unit) : RecyclerView.Adapter<HistoryViewHolder>() {

    var mainData: List<MainData> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.bin_history_item, parent, false)
        return HistoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        holder.bind(mainData[position], userClickListener)
    }

    override fun getItemCount(): Int =
        mainData.size
}

class HistoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binText get() = itemView.findViewById<TextView>(R.id.binHistoryItemTextView)
    private val dateEmailText get() = itemView.findViewById<TextView>(R.id.dateHistoryItemTextView)

    fun bind(mainData: MainData, userClickListener: (MainData) -> Unit) {
        binText.setText(mainData.bin)
        dateEmailText.setText(mainData.date)


        /*itemView.setOnClickListener {
            userClickListener(user)
        }*/
    }
}