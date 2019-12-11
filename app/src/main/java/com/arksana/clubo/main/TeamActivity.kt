package com.arksana.clubo.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.arksana.clubo.R

class TeamActivity : AppCompatActivity() {

    companion object {
        val EXTRA_IDTEAM = "extra_idmatch"
    }

    var id: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_team)

        id = intent.getStringExtra(EXTRA_IDTEAM)

    }
}
