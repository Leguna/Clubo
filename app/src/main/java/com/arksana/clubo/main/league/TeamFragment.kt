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
import com.arksana.clubo.adapter.TeamAdapter
import com.arksana.clubo.data.Repository
import com.arksana.clubo.main.DetailActivity
import com.arksana.clubo.main.TeamActivity
import com.arksana.clubo.model.Teams
import kotlinx.android.synthetic.main.fragment_team.*

class TeamFragment : Fragment() {

    private val repository = Repository()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_team, container, false)
    }

    var teams = listOf<Teams>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView.layoutManager = LinearLayoutManager(context)
        repository.listTeam(DetailActivity.league?.idLeague!!)
        repository.team.observe(this, Observer {
            teams = listOf(it[0])
            recyclerView.adapter = TeamAdapter(this, teams[0].teams) { team ->
                val intent = Intent(context, TeamActivity::class.java)
                intent.putExtra(TeamActivity.EXTRA_IDTEAM, team.idTeam)
                startActivity(intent)
            }
        })

        searchView.queryHint = "Cari Team..."
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (!newText.isNullOrEmpty()) {
                    repository.search(newText)
                    return true
                } else {
                    repository.listTeam(id.toString())
                }
                return false
            }
        })

    }

}
