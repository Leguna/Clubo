package com.arksana.clubo

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.arksana.clubo.anko.DetailUI
import com.arksana.clubo.data.Liga
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import org.jetbrains.anko.setContentView

class DetailActivity : AppCompatActivity() {

    companion object {
        val EXTRA_LIGA = "extra_liga"
    }

    var liga: Liga? = null

    lateinit var detailActivity: DetailUI

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        liga = intent.getParcelableExtra(EXTRA_LIGA)

        detailActivity = DetailUI()
        detailActivity.setContentView(this)

        supportActionBar?.title = liga?.name
        Glide.with(this)
            .load(liga?.image)
            .apply(RequestOptions().override(400, 500))
            .into(detailActivity.image)
        detailActivity.judul.text = liga?.name
        detailActivity.desc.text = liga?.desc
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == android.R.id.home){
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
}
