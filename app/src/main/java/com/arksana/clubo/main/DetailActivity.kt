package com.arksana.clubo.main


import android.app.SearchManager
import android.content.Context
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.viewpager.widget.ViewPager
import com.arksana.clubo.R
import com.arksana.clubo.data.League
import com.arksana.clubo.main.league.SectionsPagerAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_league.*
import org.jetbrains.anko.startActivity


class DetailActivity : AppCompatActivity() {

    companion object {
        val EXTRA_LEAGUE = "extra_league"
        var league: League? = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)

        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)

        setToolbar()

        if (intent.hasExtra(EXTRA_LEAGUE)) {
            league = intent.getParcelableExtra(EXTRA_LEAGUE)
            initLeague()
        }

    }

    fun initLeague() {
        toolbar.title = league?.strLeague
        tv_country.text = league?.strCountry
        tv_desc.text = league?.strDescriptionEN
        tv_formed.text = league?.intFormedYear
        Glide.with(this)
            .load(league?.strBadge)
            .apply(RequestOptions().override(200, 300))
            .into(image_league)
    }

    private fun setToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.list_menu, menu)

        val searchView: SearchView =
            toolbar.menu.findItem(R.id.action_search).actionView as SearchView

        searchView.queryHint = resources.getString(R.string.search)
        searchView.setOnQueryTextListener(object :
            SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                if (query.isNotEmpty())
                    startActivity<SearchActivity>(SearchActivity.EXTRA_QUERY to query)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            super.onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

}