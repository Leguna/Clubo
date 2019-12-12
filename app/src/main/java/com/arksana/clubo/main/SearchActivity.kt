package com.arksana.clubo.main

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.arksana.clubo.R
import com.arksana.clubo.adapter.MatchAdapter
import com.arksana.clubo.data.Repository
import com.arksana.clubo.model.Match
import kotlinx.android.synthetic.main.activity_search.*
import org.jetbrains.anko.startActivity

class SearchActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_QUERY = "extra_query"
    }

    private var items: List<Match> = ArrayList()
    private val repository = Repository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        showLoading(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        repository.matches.observe(this, Observer {
            items = ArrayList(it.matches)
            recyclerView.adapter = MatchAdapter(this, it.matches) { match ->
                startActivity<MatchActivity>(MatchActivity.EXTRA_IDMATCH to match.idEvent)
            }
            showLoading(false)
        })

        repository.searchMatch(intent.getStringExtra(EXTRA_QUERY)!!)
        title = intent.getStringExtra(EXTRA_QUERY)
    }

    fun showLoading(state: Boolean) {
        if (state) {
            loading_overlay.visibility = View.VISIBLE
        }
        else {
            loading_overlay.visibility = View.GONE
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.list_menu, menu)

        val searchView: SearchView = menu?.findItem(R.id.action_search)?.actionView as SearchView

        searchView.queryHint = resources.getString(R.string.search)
        searchView.setOnQueryTextListener(object :
            SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                if (query.isNotEmpty())
                    title = query
                showLoading(true)
                repository.searchMatch(query)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText?.isNotEmpty()!!) {
                    showLoading(true)
                    title = newText
                    repository.searchMatch(newText)
                }
                return true
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
