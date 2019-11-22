package com.arksana.clubo.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.arksana.clubo.R
import com.arksana.clubo.data.League
import com.arksana.clubo.ui.league.SectionsPagerAdapter
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_league.*

class DetailActivity : AppCompatActivity() {

    companion object {
        val EXTRA_LEAGUE = "extra_league"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)

        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)

        if (intent.hasExtra(EXTRA_LEAGUE)) {
            var league: League? = intent.getParcelableExtra(EXTRA_LEAGUE)
            println(league?.strLeague)
            toolbar.title = league?.strLeague
        }

    }


}