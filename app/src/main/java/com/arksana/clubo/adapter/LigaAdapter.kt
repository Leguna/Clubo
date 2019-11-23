package com.arksana.clubo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.arksana.clubo.R
import org.jetbrains.anko.AnkoContext

import com.arksana.clubo.anko.LigaUI
import com.arksana.clubo.data.League
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.item_league_list.view.*


class LigaAdapter(var list: List<League> = arrayListOf(), val listener: (League) -> Unit) :
    RecyclerView.Adapter<LigaAdapter.LeagueViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeagueViewHolder {
        return LeagueViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_league_list,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: LeagueViewHolder, position: Int) {

        val league = list[position]
        Glide.with(holder.itemView.context)
            .load(league.strBadge)
            .apply(RequestOptions().override(200, 300))
            .into(holder.ivLogo)
        holder.tvTitle.text = league.strLeague
        holder.tvDesc.text = "${league.strDescriptionEN}"
        holder.layout.setOnClickListener{
            listener(league)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class LeagueViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val ivLogo: ImageView = itemView.image_league
        val tvTitle: TextView = itemView.tv_league
        val tvDesc: TextView = itemView.tv_desc
        val layout: LinearLayout = itemView.item

    }
}