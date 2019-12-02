package com.arksana.clubo.utils

import com.arksana.clubo.data.Match
import com.arksana.clubo.data.Match.Companion.KEY_DATE
import com.arksana.clubo.data.Match.Companion.KEY_ID
import com.arksana.clubo.data.Match.Companion.KEY_NAME
import com.arksana.clubo.data.Match.Companion.KEY_PHOTO_AWAY
import com.arksana.clubo.data.Match.Companion.KEY_PHOTO_HOME
import com.arksana.clubo.data.Match.Companion.KEY_ROUND
import com.arksana.clubo.data.Match.Companion.KEY_SCORE_AWAY
import com.arksana.clubo.data.Match.Companion.KEY_SCORE_HOME
import com.arksana.clubo.data.Match.Companion.KEY_TIME
import org.jetbrains.anko.db.MapRowParser

class MyRowParser : MapRowParser<Match> {
    //    override fun parseRow(columns: Map<String, Any?>): Match {
//        return Match(
//            idEvent = columns.getValue(KEY_ID).toString(),
//            strEvent = columns.getValue(KEY_NAME).toString(),
//            strHomePhoto = columns.getValue(KEY_PHOTO_HOME).toString(),
//            strAwayPhoto = columns.getValue(KEY_PHOTO_AWAY).toString(),
//            intHomeScore = columns.getValue(KEY_SCORE_HOME).toString(),
//            intAwayScore = columns.getValue(KEY_SCORE_AWAY).toString(),
//            intRound = columns.getValue(KEY_ROUND).toString(),
//            strTime = columns.getValue(KEY_TIME).toString(),
//            dateEvent = columns.getValue(KEY_DATE).toString()
//        )
//    }
    override fun parseRow(columns: Map<String, Any?>): Match {
        val id = columns.getValue(KEY_ID)
        val name = columns.getValue(KEY_NAME)
        val photoHome = columns.getValue(KEY_PHOTO_HOME)
        val photoAway = columns.getValue(KEY_PHOTO_AWAY)
        val scoreHome = columns.getValue(KEY_SCORE_HOME)
        val scoreAway = columns.getValue(KEY_SCORE_AWAY)
        val time = columns.getValue(KEY_TIME)
        val date = columns.getValue(KEY_DATE)
        val round = columns.getValue(KEY_ROUND)

        val match = Match()
        match.idEvent = id.toString()
        match.strEvent = name.toString()
        match.strHomePhoto = photoHome.toString()
        match.strAwayPhoto = photoAway.toString()
        match.intHomeScore = scoreHome.toString()
        match.intAwayScore = scoreAway.toString()
        match.intRound = round.toString()
        match.strTime = time.toString()
        match.dateEvent = date.toString()

        return match
    }
}