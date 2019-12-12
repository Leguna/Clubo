package com.arksana.clubo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arksana.clubo.R
import com.arksana.clubo.model.Team
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.item_team_list.view.*

class TeamAdapter(
    private var list: List<Team>?,
    val listener: (Team) -> Unit
) : RecyclerView.Adapter<TeamAdapter.TeamViewHolder>() {

    class TeamViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        return TeamViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_team_list,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return list?.size ?: 0
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        val view = holder.itemView
        val team = list?.get(position) ?: Team()

        Glide.with(view)
            .load(team.strTeamBadge)
            .apply(RequestOptions().override(200, 200))
            .into(view.iv_badge)
        view.tv_name.text = team.strTeam
        view.tv_country.text = team.strCountry
        view.tv_desc.text = team.strDescriptionEN
        view.setOnClickListener {
            listener(list?.get(position) ?: Team())
        }
    }


}