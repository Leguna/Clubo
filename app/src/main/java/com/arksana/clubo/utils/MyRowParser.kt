package com.arksana.clubo.utils

import com.arksana.clubo.model.Match
import com.arksana.clubo.model.Match.Companion.KEY_DATE
import com.arksana.clubo.model.Match.Companion.KEY_ID
import com.arksana.clubo.model.Match.Companion.KEY_NAME
import com.arksana.clubo.model.Match.Companion.KEY_PHOTO_AWAY
import com.arksana.clubo.model.Match.Companion.KEY_PHOTO_HOME
import com.arksana.clubo.model.Match.Companion.KEY_ROUND
import com.arksana.clubo.model.Match.Companion.KEY_SCORE_AWAY
import com.arksana.clubo.model.Match.Companion.KEY_SCORE_HOME
import com.arksana.clubo.model.Match.Companion.KEY_TIME
import org.jetbrains.anko.db.MapRowParser

class MyRowParser : MapRowParser<Match> {
    override fun parseRow(columns: Map<String, Any?>): Match {
        return Match(
            idEvent = columns.getValue(KEY_ID).toString(),
            strEvent = columns.getValue(KEY_NAME).toString(),
            strHomePhoto = columns.getValue(KEY_PHOTO_HOME).toString(),
            strAwayPhoto = columns.getValue(KEY_PHOTO_AWAY).toString(),
            intHomeScore = columns.getValue(KEY_SCORE_HOME)?.toString() ?: "0",
            intAwayScore = columns.getValue(KEY_SCORE_AWAY)?.toString() ?: "0",
            idHomeTeam = columns.getValue(Match.KEY_HOME_TEAM).toString(),
            idAwayTeam = columns.getValue(Match.KEY_AWAY_TEAM).toString(),
            intRound = columns.getValue(KEY_ROUND).toString(),
            strTime = columns.getValue(KEY_TIME).toString(),
            dateEvent = columns.getValue(KEY_DATE).toString()
        )
    }
}