package com.arksana.clubo.main.mainactivity

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.arksana.clubo.R
import com.arksana.clubo.adapter.LigaAdapter
import com.arksana.clubo.data.League
import com.arksana.clubo.data.Repository
import com.arksana.clubo.main.DetailActivity
import kotlinx.android.synthetic.main.fragment_league_list.*

class LeagueListFragment : Fragment() {

    private var items: List<League> = ArrayList()
    private val repository = Repository()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_league_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        repository.listLeague()
        showLoading(true)

        recyclerView.layoutManager = LinearLayoutManager(context)
        repository.leagues.observe(this, Observer {
            showLoading(false)
            items = it.leagues
            recyclerView.adapter = LigaAdapter(items) { league ->
                val intent = Intent(context, DetailActivity::class.java)
                intent.putExtra(DetailActivity.EXTRA_LEAGUE, league)
                startActivity(intent)
            }
        })

    }


    private fun showLoading(state: Boolean) {
        if (state) loading_overlay.visibility = View.VISIBLE
        else loading_overlay.visibility = View.GONE
    }
}
