package com.arksana.clubo.main.mainactivity


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.arksana.clubo.R
import com.arksana.clubo.data.AnkoSQL
import com.arksana.clubo.data.Match
import kotlinx.android.synthetic.main.fragment_league.*


class FavoriteListFragment : Fragment() {

    private lateinit var listMatch: ArrayList<Match>
    private lateinit var ankoSQL: AnkoSQL

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_league, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ankoSQL = AnkoSQL(context!!)
        recyclerView.layoutManager = LinearLayoutManager(context)


    }


}
