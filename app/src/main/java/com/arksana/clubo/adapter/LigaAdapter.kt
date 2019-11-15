package com.arksana.clubo.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.arksana.clubo.data.Liga
import org.jetbrains.anko.AnkoContext

import com.arksana.clubo.anko.LigaUI
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions


class LigaAdapter(var list: ArrayList<Liga> = arrayListOf(), val listener: (Liga) -> Unit)
    : RecyclerView.Adapter<LigaAdapter.LigaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LigaViewHolder {
        return LigaViewHolder(LigaUI().createView(AnkoContext.create(parent.context, parent)))
    }
    override fun onBindViewHolder(holder: LigaViewHolder, position: Int) {

        val liga = list[position]
        Glide.with(holder.itemView.context)
            .load(liga.image)
            .apply(RequestOptions().override(200, 300))
            .into(holder.ivLogo)
        holder.tvTitle.text = liga.name
        holder.tvYear.text = "${liga.desc}"
        holder.layout.setOnClickListener{
            listener(liga)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class LigaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var ivLogo: ImageView
        var tvTitle: TextView
        var tvYear: TextView
        var layout: LinearLayout

        init {
            ivLogo = itemView.findViewById(LigaUI.ivLogoId)
            tvTitle = itemView.findViewById(LigaUI.tvNameId)
            tvYear = itemView.findViewById(LigaUI.tvDescId)
            layout = itemView.findViewById(LigaUI.layoutId)
        }

    }
}