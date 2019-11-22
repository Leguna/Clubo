package com.arksana.clubo.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.jetbrains.anko.AnkoContext

import com.arksana.clubo.anko.LigaUI
import com.arksana.clubo.data.League
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions


class LigaAdapter(var list: List<League> = arrayListOf(), val listener: (League) -> Unit) :
    RecyclerView.Adapter<LigaAdapter.LeagueViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeagueViewHolder {
        return LeagueViewHolder(LigaUI().createView(AnkoContext.create(parent.context, parent)))
    }

    override fun onBindViewHolder(holder: LeagueViewHolder, position: Int) {

        val league = list[position]
        Glide.with(holder.itemView.context)
            .load(league.strBadge)
            .apply(RequestOptions().override(200, 300))
            .into(holder.ivLogo)
        holder.tvTitle.text = league.strLeague
        holder.tvYear.text = "${league.strDescriptionEN}"
        holder.layout.setOnClickListener {
            listener(league)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class LeagueViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
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