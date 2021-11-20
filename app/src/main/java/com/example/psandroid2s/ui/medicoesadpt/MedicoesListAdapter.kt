package com.example.psandroid2s.ui.medicoesadpt

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.psandroid2s.R
import com.example.psandroid2s.model.ReturnRelatorio
import com.example.psandroid2s.ui.listall.ListAllViewModel

class MedicoesListAdapter :
    RecyclerView.Adapter<MedicoesListAdapter.RelatorioListItemViewHolder>() {

    var items = emptyList<ReturnRelatorio>()
        set(value) {
            val result = DiffUtil.calculateDiff(
                RelatorioListDiffCallback(
                    field,
                    value
                )
            )
            result.dispatchUpdatesTo(this)
            field = value
        }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RelatorioListItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.medicoes_item, parent, false)

        return RelatorioListItemViewHolder(
            view
        )
    }

    override fun onBindViewHolder(holder: RelatorioListItemViewHolder, position: Int) {
        holder.bind(items[position])
    }

    fun getItemAt(position: Int): ReturnRelatorio {
        return items[position]
    }

    override fun getItemCount(): Int = items.size

    class RelatorioListItemViewHolder(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {

        fun bind(items: ReturnRelatorio) {
            itemView.findViewById<TextView>(R.id.txt_cidade).text = items.sensor.local.cidade
            itemView.findViewById<TextView>(R.id.txt_co2).text = items.co2Vol.toString()
            itemView.findViewById<TextView>(R.id.txt_data).text = items.medicaoDate
            itemView.findViewById<TextView>(R.id.txt_local).text = items.sensor.local.nome
            itemView.findViewById<TextView>(R.id.txt_ph).text = items.phVol.toString()
        }

    }

    class RelatorioListDiffCallback(
        private val oldList: List<ReturnRelatorio>,
        private val newList: List<ReturnRelatorio>
    ) : DiffUtil.Callback() {

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition].id == newList[newItemPosition].id
        }

        override fun getOldListSize(): Int {
            return oldList.size
        }

        override fun getNewListSize(): Int {
            return newList.size
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return true
        }
    }
}



