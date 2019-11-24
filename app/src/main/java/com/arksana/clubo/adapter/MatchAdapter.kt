package com.arksana.clubo.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arksana.clubo.R
import com.arksana.clubo.data.Match
import kotlinx.android.synthetic.main.item_match_list.view.*


class MatchAdapter(var list: List<Match> = arrayListOf(), val listener: (Match) -> Unit) :
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

    inner class MatchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val match = itemView.tv_match
        val score = itemView.tv_score
        val score2 = itemView.tv_score2
        val round = itemView.tv_round
        val date = itemView.tv_date
        val time = itemView.tv_time

        val item = itemView.item

    }
}