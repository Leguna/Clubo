package com.arksana.clubo.main.mainactivity


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.arksana.clubo.R
import com.arksana.clubo.adapter.MatchAdapter
import com.arksana.clubo.data.AnkoSQL
import com.arksana.clubo.data.Match
import com.arksana.clubo.main.MatchActivity
import com.arksana.clubo.utils.MyDatabaseOpenHelper
import kotlinx.android.synthetic.main.fragment_league.*


class FavoriteListFragment : Fragment() {

    private lateinit var listMatch: ArrayList<Match>
    private lateinit var ankoSQL: AnkoSQL

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_league, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ankoSQL = AnkoSQL(MyDatabaseOpenHelper.getInstance(context!!))
        recyclerView.layoutManager = LinearLayoutManager(context)

        listMatch = ankoSQL.sqlLiteFindAll()

        recyclerView.adapter = MatchAdapter(this, listMatch) {
            val intent = Intent(context, MatchActivity::class.java)
            intent.putExtra(MatchActivity.EXTRA_IDMATCH, it.idEvent)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        listMatch = ankoSQL.sqlLiteFindAll()
        recyclerView.adapter = MatchAdapter(this, listMatch) {
            val intent = Intent(context, MatchActivity::class.java)
            intent.putExtra(MatchActivity.EXTRA_IDMATCH, it.idEvent)
            startActivity(intent)
        }
    }


}
