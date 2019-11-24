package com.arksana.clubo.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.arksana.clubo.R
import com.arksana.clubo.adapter.MatchAdapter
import com.arksana.clubo.data.Match
import com.arksana.clubo.data.Repository
import kotlinx.android.synthetic.main.activity_search.*

class SearchActivity : AppCompatActivity() {

    companion object {
        val EXTRA_QUERY = "extra_query"
    }

    private var items: List<Match> = ArrayList()
    private val repository = Repository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        recyclerView.layoutManager = LinearLayoutManager(this)
        repository.matches.observe(this, Observer {
            items = ArrayList(it.matches)
            recyclerView.adapter = MatchAdapter(it.matches) { match ->
                println(match.idEvent + " " + match.strEvent)
            }
            showLoading(false)
        })

        repository.search(intent.getStringExtra(EXTRA_QUERY))
    }

    fun showLoading(state: Boolean) {
        if (state) loading_overlay.visibility = View.VISIBLE
        else {
            loading_overlay.visibility = View.GONE
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.list_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            super.onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
}
