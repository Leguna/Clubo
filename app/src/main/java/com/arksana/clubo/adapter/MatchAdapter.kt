package com.arksana.clubo.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.arksana.clubo.R
import com.arksana.clubo.data.Repository
import com.arksana.clubo.model.Match
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.item_match_list.view.*


class MatchAdapter(
    private val owner: LifecycleOwner,
    private var list: List<Match>,
    val listener: (Match) -> Unit
) :
    RecyclerView.Adapter<MatchAdapter.MatchViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchViewHolder {
        return MatchViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_match_list,
                parent,
                false
            )
        )
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MatchViewHolder, position: Int) {

        val match = list[position]
        val repository = Repository()
        val ids = arrayOf(match.idHomeTeam.toString(), match.idAwayTeam.toString())
        repository.allDetailTeam(ids)
        repository.team.observe(owner, Observer {
            Glide.with(holder.itemView)
                .load(it[0].teams[0].strTeamBadge)
                .apply(RequestOptions().override(200, 300))
                .into(holder.badge)
            Glide.with(holder.itemView)
                .load(it[1].teams[0].strTeamBadge)
                .apply(RequestOptions().override(200, 300))
                .into(holder.badge2)
        })

        holder.match.text = match.strEvent
        holder.score.text = (match.intHomeScore ?: "0")
        holder.score2.text = (match.intAwayScore ?: "0")
        holder.round.text = "Round " + (match.intRound ?: "-")
        holder.date.text = match.dateEvent ?: "-"
        holder.time.text = match.strTime ?: "-"

        holder.item.setOnClickListener {
            listener(match)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class MatchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val match: TextView = itemView.tv_match
        val score: TextView = itemView.tv_score
        val score2: TextView = itemView.tv_score2
        val round: TextView = itemView.tv_round
        val date: TextView = itemView.tv_date
        val time: TextView = itemView.tv_time
        val item: CardView = itemView.item

        val badge: ImageView = itemView.iv_badge
        val badge2: ImageView = itemView.iv_badge2
    }
}