package com.arksana.clubo.main.league

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.arksana.clubo.R

private val TAB_TITLES = arrayOf(
    R.string.match, R.string.standings, R.string.team
)

class SectionsPagerAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val pages = listOf(
        MatchFragment(),
        StandingsFragment(),
        TeamFragment()
    )

    override fun getItem(position: Int): Fragment {
        return pages[position]
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "Match"
            1 -> "Standings"
            else -> "Team"
        }
    }

    override fun getCount(): Int {
        return TAB_TITLES.size
    }

}