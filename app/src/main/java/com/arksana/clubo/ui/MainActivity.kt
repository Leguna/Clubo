package com.arksana.clubo.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.arksana.clubo.R
import com.arksana.clubo.adapter.LigaAdapter
import com.arksana.clubo.anko.MainUI
import com.arksana.clubo.data.Liga
import com.arksana.clubo.ui.league.DetailActivity
import org.jetbrains.anko.setContentView
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    var items: ArrayList<Liga> = ArrayList()
    lateinit var mainActivity : MainUI

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainActivity = MainUI()
        mainActivity.setContentView(this)

        initData()

        mainActivity.rv.layoutManager = LinearLayoutManager(this)
        mainActivity.rv.adapter = LigaAdapter(items) {
            startActivity<DetailActivity>(DetailActivity.EXTRA_LEAGUE to it)
        }

    }

    private fun initData(){
        val image = resources.obtainTypedArray(R.array.liga_image)
        val name = resources.getStringArray(R.array.liga_name)
        val id = resources.getIntArray(R.array.liga_id)
        val desc = resources.getStringArray(R.array.liga_desc)
        items.clear()
        for (i in name.indices) {
            items.add(
                Liga(
                    name[i],
                    id[i],
                    desc[i],
                    image.getResourceId(i, 0)
                )
            )
        }
        //Recycle the typed array
        image.recycle()
    }
}
