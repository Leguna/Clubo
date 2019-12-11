package com.arksana.clubo.main.league

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.arksana.clubo.R
import com.arksana.clubo.adapter.MatchAdapter
import com.arksana.clubo.data.Repository
import com.arksana.clubo.main.DetailActivity
import com.arksana.clubo.main.MatchActivity
import com.arksana.clubo.model.Match
import com.arksana.clubo.utils.gone
import com.arksana.clubo.utils.visible
import kotlinx.android.synthetic.main.fragment_league.*

class MatchFragment : Fragment() {

    private val repository = Repository()
    private var items: List<Match> = ArrayList()
    private var items2: List<Match> = ArrayList()
    private var items3: List<Match> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_league, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showLoading(true)
        repository.prevMatch(DetailActivity.league?.idLeague.toString())
        repository.nextMatch(DetailActivity.league?.idLeague.toString())

        recyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        repository.matches.observe(this, Observer {
            items = ArrayList(it.matches)
            recyclerView.adapter = MatchAdapter(this, it.matches) { match ->
                val intent = Intent(context, MatchActivity::class.java)
                intent.putExtra(MatchActivity.EXTRA_IDMATCH, match.idEvent)
                startActivity(intent)
            }
            showLoading(false)
        })

        recyclerView2.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        repository.matches2.observe(this, Observer {
            items2 = ArrayList(it.matches)
            recyclerView2.adapter = MatchAdapter(this, it.matches) { match ->
                val intent = Intent(context, MatchActivity::class.java)
                intent.putExtra(MatchActivity.EXTRA_IDMATCH, match.idEvent)
                startActivity(intent)
            }
            showLoading(false)
        })

        searchView.queryHint = "Cari Match..."
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (!newText.isNullOrEmpty()) {
                    repository.search(newText)
                    recyclerView3.visible()
                    prevnext.gone()
                } else {
                    recyclerView3.gone()
                    prevnext.visible()
                }
                return false
            }

        })
        recyclerView3.layoutManager = LinearLayoutManager(context)
        repository.matches3.observe(this, Observer {
            items3 = ArrayList(it.matches)
            recyclerView3.adapter = MatchAdapter(this, it.matches) { match ->
                val intent = Intent(context, MatchActivity::class.java)
                intent.putExtra(MatchActivity.EXTRA_IDMATCH, match.idEvent)
                startActivity(intent)
            }
        })
    }

    private fun showLoading(state: Boolean) {
        if (state) loading_overlay.visibility = View.VISIBLE
        else {
            loading_overlay.visibility = View.GONE
            text_overlay.visibility = View.GONE
        }

        if (!state && items.isEmpty()) {
            text_overlay.visibility = View.VISIBLE
        }
    }

}