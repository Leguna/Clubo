package com.arksana.clubo.main

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.arksana.clubo.R
import com.arksana.clubo.adapter.LigaAdapter
import com.arksana.clubo.data.League
import com.arksana.clubo.data.Repository
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity


class MainActivity : AppCompatActivity() {

    private var items: List<League> = ArrayList()

    private val repository = Repository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        repository.listLeague()
        showLoading(true)

        recyclerView.layoutManager = LinearLayoutManager(this)
        repository.leagues.observe(this, Observer {
            showLoading(false)
            items = it.leagues
            recyclerView.adapter = LigaAdapter(items) { league ->
                startActivity<DetailActivity>(DetailActivity.EXTRA_LEAGUE to league)
                println(league.idLeague)
            }
        })

    }

    private fun showLoading(state: Boolean) {
        if (state) loading_overlay.visibility = View.VISIBLE
        else loading_overlay.visibility = View.GONE
    }

}
