package com.arksana.clubo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.arksana.clubo.R
import com.arksana.clubo.data.Repository
import com.arksana.clubo.model.Standing
import com.arksana.clubo.model.Team
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.item_standing_list.view.*

class StandingAdapter(
    private val owner: LifecycleOwner,
    private var list: List<Standing?>?,
    val listener: (String) -> Unit
) : RecyclerView.Adapter<StandingAdapter.StandingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StandingViewHolder {
        return StandingViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_standing_list,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return list?.size ?: 0
    }

    override fun onBindViewHolder(holder: StandingViewHolder, position: Int) {
        val view = holder.itemView
        val standing = list?.get(position)
        val repository = Repository()

        repository.detailTeam(standing?.teamid!!)
        repository.team.observe(owner, Observer {
            println(it[0])
            val team: Team = it[0].teams[0]
            Glide.with(view)
                .load(team.strTeamBadge)
                .apply(RequestOptions().override(200, 300))
                .into(view.iv_badge)
        })
        view.tv_name.text = standing.name.toString()
        view.tv_match.text = standing.played.toString()
        view.tv_lose.text = standing.loss.toString()
        view.tv_win.text = standing.win.toString()
        view.tv_draw.text = standing.draw.toString()

        view.setOnClickListener {
            listener(standing.teamid)
        }
    }

    class StandingViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    }

}