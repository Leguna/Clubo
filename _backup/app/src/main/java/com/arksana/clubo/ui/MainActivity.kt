package com.arksana.clubo.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.arksana.clubo.R
import com.arksana.clubo.adapter.LigaAdapter
import com.arksana.clubo.data.League
import com.arksana.clubo.data.Repository
import kotlinx.android.synthetic.main.activity_leagues.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    var items: List<League> = ArrayList()

    val repository = Repository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_leagues)

        initData()

        rv_category.layoutManager = LinearLayoutManager(this)

        repository.leagues.observe(this, Observer {
            items = it.leagues
            rv_category.adapter = LigaAdapter(items) {
                println(it.strLeague)
                startActivity<DetailActivity>(DetailActivity.EXTRA_LEAGUE to it)
            }
        })

//        mainActivity.rv.layoutManager = LinearLayoutManager(this)
//        mainActivity.rv.adapter = LigaAdapter(items) {
//            startActivity<DetailActivity>(DetailActivity.EXTRA_LEAGUE to it)
//        }

    }

    private fun initData() {
        val image = resources.obtainTypedArray(R.array.liga_image)
        val name = resources.getStringArray(R.array.liga_name)
        val id = resources.getIntArray(R.array.liga_id)
        val desc = resources.getStringArray(R.array.liga_desc)

        repository.listLeague()

        //Recycle the typed array
        image.recycle()
    }
}
