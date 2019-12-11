package com.arksana.clubo.main

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.arksana.clubo.R
import com.arksana.clubo.data.AnkoSQL
import com.arksana.clubo.data.MyDatabaseOpenHelper
import com.arksana.clubo.data.Repository
import com.arksana.clubo.model.Match
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.activity_match.*

class MatchActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_IDMATCH = "extra_idMatch"
    }

    private val repository = Repository()
    private lateinit var ankoSQL: AnkoSQL
    private lateinit var match: Match

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_match)
        ankoSQL = AnkoSQL(MyDatabaseOpenHelper.getInstance(applicationContext))
        title = "Detail Match"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        showLoading(true)
        repository.team.observe(this, Observer {
            match.strHomePhoto = it[0].teams!![0]?.strTeamBadge
            match.strAwayPhoto = it[1].teams!![0]?.strTeamBadge

            Glide.with(this)
                .load(it[0].teams!![0]?.strTeamBadge)
                .apply(RequestOptions().override(200, 300))
                .into(iv_badge)
            Glide.with(this)
                .load(it[1].teams!![0]?.strTeamBadge)
                .apply(RequestOptions().override(200, 300))
                .into(iv_badge2)
        })
        repository.matches.observe(this, Observer {
            match = it.matches[0]
            setUI(it.matches[0])
            showLoading(false)
            val ids =
                arrayOf(it.matches[0].idHomeTeam.toString(), it.matches[0].idAwayTeam.toString())
            repository.allDetailTeam(ids)
            heartCheck(it.matches[0].idEvent!!)
        })

        repository.detailMatch(intent.getStringExtra(EXTRA_IDMATCH)!!)
    }

    private fun setUI(match: Match?) {

        tv_league.text = match?.strLeague
        tv_match.text = match?.strEvent
        tv_date.text = match?.dateEvent
        tv_round.text = String.format(resources.getString(R.string.round) + match?.intRound)
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.fav, menu)
        this.menu = menu!!
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            super.onBackPressed()
        } else if (item.itemId == R.id.action_favorite) {
            changeLoveColor(item)
        }
        return super.onOptionsItemSelected(item)
    }

    private lateinit var menu: Menu
    private var heartCondition = false
    private fun changeLoveColor(item: MenuItem) {
        if (!isLoading) {
            item.isEnabled = true
            heartCondition = !heartCondition
            if (heartCondition) {
                item.setIcon(R.drawable.ic_favorite)
                ankoSQL.sqlLiteCreate(match)
            } else {
                item.setIcon(R.drawable.ic_favorite_border)
                ankoSQL.matchDelete(match)
            }
        } else {
            item.isEnabled = false
        }
    }

    private fun heartCheck(idEvent: String) {
        val menuItem: MenuItem = menu.findItem(R.id.action_favorite)
        heartCondition = ankoSQL.sqlLiteSelectID(idEvent).isNotEmpty()
        val icon = if (heartCondition) R.drawable.ic_favorite else R.drawable.ic_favorite_border
        menuItem.setIcon(icon)
    }

    private var isLoading: Boolean = true

    private fun showLoading(state: Boolean) {
        isLoading = state
        if (state) loading_overlay.visibility = View.VISIBLE
        else loading_overlay.visibility = View.GONE
    }

}
