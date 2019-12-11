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
import com.arksana.clubo.adapter.StandingAdapter
import com.arksana.clubo.data.Repository
import com.arksana.clubo.main.DetailActivity
import com.arksana.clubo.main.TeamActivity
import com.arksana.clubo.model.Standing
import com.arksana.clubo.utils.gone
import com.arksana.clubo.utils.visible
import kotlinx.android.synthetic.main.fragment_standings.*

class StandingsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_standings, container, false)
    }

    private val repository = Repository()
    private lateinit var id: String
    private lateinit var items: ArrayList<Standing?>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        id = DetailActivity.league?.idLeague.toString()
        repository.standings(id)
        showLoading(true)
        recyclerView.layoutManager = LinearLayoutManager(context)
        repository.standing.observe(this, Observer {
            items = arrayListOf(it.standings?.get(0))
            recyclerView.adapter = StandingAdapter(this, it.standings) { id ->
                val intent = Intent(context, TeamActivity::class.java)
                intent.putExtra(TeamActivity.EXTRA_IDTEAM, id)
                startActivity(intent)
            }
            showLoading(false)
        })
    }

    private fun showLoading(state: Boolean) {
        if (state) {
            standings.gone()
            loading_overlay.visible()
        } else {
            standings.visible()
            loading_overlay.gone()
            if (items.size == 0) {
                text_overlay.visible()
                standings.gone()
            }
        }
    }

}
