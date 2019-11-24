package com.arksana.clubo.main.league

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.arksana.clubo.R
import com.arksana.clubo.adapter.MatchAdapter
import com.arksana.clubo.data.Match
import com.arksana.clubo.data.Repository
import com.arksana.clubo.main.DetailActivity
import com.arksana.clubo.main.MatchActivity
import kotlinx.android.synthetic.main.fragment_league.*

class LeagueDetailFragment : Fragment() {

    private val repository = Repository()
    private var index = 0
    private var items: List<Match> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_league, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showLoading(true)
        index = arguments?.getInt(ARG_SECTION_NUMBER)!!
        if (index == 1)
            repository.prevMatch(DetailActivity.league?.idLeague.toString())
        else repository.nextMatch(DetailActivity.league?.idLeague.toString())

        recyclerView.layoutManager = LinearLayoutManager(context)
        repository.matches.observe(this, Observer {
            items = ArrayList(it.matches)
            recyclerView.adapter = MatchAdapter(this, it.matches) { match ->
                val intent = Intent(context, MatchActivity::class.java)
                intent.putExtra(MatchActivity.EXTRA_IDMATCH, match.idEvent)
                startActivity(intent)
            }
            showLoading(false)
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

    companion object {
        private const val ARG_SECTION_NUMBER = "section_number"

        @JvmStatic
        fun newInstance(sectionNumber: Int): LeagueDetailFragment {
            return LeagueDetailFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }
}