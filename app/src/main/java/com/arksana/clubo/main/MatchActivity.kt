package com.arksana.clubo.main

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.lifecycle.Observer
import com.arksana.clubo.R
import com.arksana.clubo.data.Match
import com.arksana.clubo.data.Repository
import kotlinx.android.synthetic.main.activity_match.*

class MatchActivity : AppCompatActivity() {

    companion object {
        val EXTRA_IDMATCH = "extra_idmatch"
    }

    private val repository = Repository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_match)

        title = "Detail Match"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        showLoading(true)
        repository.matches.observe(this, Observer {
            setUI(it.matches[0])
            showLoading(false)
        })

        repository.detailMatch(intent.getStringExtra(EXTRA_IDMATCH)!!)
    }


    @SuppressLint("SetTextI18n")
    fun setUI(match: Match?) {

        tv_league.text = match?.strLeague
        tv_match.text = match?.strEvent
        tv_date.text = match?.dateEvent
        tv_round.text = "Round " + match?.intRound
        tv_time.text = match?.strTime
        tv_score.text = match?.intHomeScore ?: "0"
        tv_score2.text = match?.intAwayScore ?: "0"
        tv_formation.text = match?.strHomeFormation ?: "-"
        tv_formation2.text = match?.strAwayFormation ?: "-"
        tv_keeper.text = match?.strHomeLineupGoalkeeper ?: "-"
        tv_keeper2.text = match?.strAwayLineupGoalkeeper ?: "-"
        tv_goal.text = match?.strHomeGoalDetails ?: "-"
        tv_goal2.text = match?.strAwayGoalDetails ?: "-"
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            super.onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    fun showLoading(state: Boolean) {
        if (state) loading_overlay.visibility = View.VISIBLE
        else loading_overlay.visibility = View.GONE
    }

}
