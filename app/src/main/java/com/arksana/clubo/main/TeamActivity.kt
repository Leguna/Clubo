package com.arksana.clubo.main

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.arksana.clubo.R
import com.arksana.clubo.data.Repository
import com.arksana.clubo.model.Team
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.activity_team.*


class TeamActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_IDTEAM = "extra_idmatch"
    }

    lateinit var id: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_team)

        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        showLoading(true)
        btn_website.isEnabled = false
        id = intent.getStringExtra(EXTRA_IDTEAM)!!
        val repository = Repository()
        repository.detailTeam(id)
        repository.team.observe(this, Observer {
            setUI(it[0].teams[0])
            showLoading(false)
        })
    }

    private fun setUI(team: Team) {
        title = team.strTeam
        Glide.with(this)
            .load(team.strTeamBadge)
            .apply(RequestOptions().override(200, 200))
            .into(iv_badge)
        Glide.with(this)
            .load(team.strTeamJersey)
            .apply(RequestOptions().override(200, 200))
            .into(iv_jersey)
        tv_name.text = team.strTeam
        tv_country.text = team.strCountry
        tv_gender.text = team.strGender
        tv_desc.text = team.strDescriptionEN
        if (team.strWebsite.isNotEmpty())
            btn_website.isEnabled = true
        btn_website.setOnClickListener {
            var url = team.strWebsite
            if (url.isNotEmpty()) {
                if (!url.startsWith("http://") && !url.startsWith("https://"))
                    url = "http://" + url
                val browserIntent =
                    Intent(Intent.ACTION_VIEW, Uri.parse(url))
                startActivity(browserIntent)
            } else {
                btn_website.isEnabled = false
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.fav, menu)
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
//                ankoSQL.sqlLiteCreate(match)
            } else {
                item.setIcon(R.drawable.ic_favorite_border)
//                ankoSQL.matchDelete(match)
            }
        } else {
            item.isEnabled = false
        }
    }

    private fun heartCheck(idEvent: String) {
        val menuItem: MenuItem = menu.findItem(R.id.action_favorite)
//        heartCondition = ankoSQL.sqlLiteSelectID(idEvent).isNotEmpty()
        val icon = if (heartCondition) R.drawable.ic_favorite else R.drawable.ic_favorite_border
        menuItem.setIcon(icon)
    }

    private var isLoading: Boolean = true

    private fun showLoading(state: Boolean) {
        isLoading = state
        if (state)
            loading_overlay.visibility = View.VISIBLE
        else
            loading_overlay.visibility = View.GONE
    }
}
