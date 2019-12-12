package com.arksana.clubo.main.mainactivity


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.arksana.clubo.R
import com.arksana.clubo.adapter.MatchAdapter
import com.arksana.clubo.adapter.TeamAdapter
import com.arksana.clubo.data.AnkoSQL
import com.arksana.clubo.data.MyDatabaseOpenHelper
import com.arksana.clubo.main.MatchActivity
import com.arksana.clubo.main.TeamActivity
import com.arksana.clubo.model.Match
import com.arksana.clubo.model.Team
import kotlinx.android.synthetic.main.fragment_favorite.*

class FavoriteListFragment : Fragment() {

    private lateinit var listMatch: ArrayList<Match>
    private lateinit var listTeam: ArrayList<Team>
    private lateinit var ankoSQL: AnkoSQL

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_favorite, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ankoSQL = AnkoSQL(MyDatabaseOpenHelper.getInstance(context!!))
        recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        recyclerView2.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)

        listMatch = ankoSQL.findAllMatchFavorite()
        listTeam = ankoSQL.findAllTeamFavorite()

        recyclerView.adapter = MatchAdapter(this, listMatch) {
            val intent = Intent(context, MatchActivity::class.java)
            intent.putExtra(MatchActivity.EXTRA_IDMATCH, it.idEvent)
            startActivity(intent)
        }
        recyclerView2.adapter = TeamAdapter(listTeam) {
            val intent = Intent(context, TeamActivity::class.java)
            intent.putExtra(TeamActivity.EXTRA_IDTEAM, it.idTeam)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        listMatch = ankoSQL.findAllMatchFavorite()
        listTeam = ankoSQL.findAllTeamFavorite()
        recyclerView.adapter = MatchAdapter(this, listMatch) {
            val intent = Intent(context, MatchActivity::class.java)
            intent.putExtra(MatchActivity.EXTRA_IDMATCH, it.idEvent)
            startActivity(intent)
        }
        recyclerView2.adapter = TeamAdapter(listTeam) {
            val intent = Intent(context, TeamActivity::class.java)
            intent.putExtra(TeamActivity.EXTRA_IDTEAM, it.idTeam)
            startActivity(intent)
        }
    }


}
