package com.arksana.clubo.data

import com.arksana.clubo.model.Match
import com.arksana.clubo.model.Match.Companion.KEY_AWAY_TEAM
import com.arksana.clubo.model.Match.Companion.KEY_DATE
import com.arksana.clubo.model.Match.Companion.KEY_HOME_TEAM
import com.arksana.clubo.model.Match.Companion.KEY_ID
import com.arksana.clubo.model.Match.Companion.KEY_NAME
import com.arksana.clubo.model.Match.Companion.KEY_PHOTO_AWAY
import com.arksana.clubo.model.Match.Companion.KEY_PHOTO_HOME
import com.arksana.clubo.model.Match.Companion.KEY_ROUND
import com.arksana.clubo.model.Match.Companion.KEY_SCORE_AWAY
import com.arksana.clubo.model.Match.Companion.KEY_SCORE_HOME
import com.arksana.clubo.model.Match.Companion.KEY_TIME
import com.arksana.clubo.model.Match.Companion.MATCH_TABLE
import com.arksana.clubo.utils.MyRowParser
import org.jetbrains.anko.db.*

class AnkoSQL(private val db: MyDatabaseOpenHelper) {

    fun sqlLiteFindAll(): ArrayList<Match> = db.use {
        val matches = ArrayList<Match>()

        select(MATCH_TABLE)
            .parseList(object : MapRowParser<List<Match>> {
                override fun parseRow(columns: Map<String, Any?>): List<Match> {
                    val match = Match(
                        idEvent = columns.getValue(KEY_ID).toString(),
                        strEvent = columns.getValue(KEY_NAME).toString(),

                        strHomePhoto = columns.getValue(KEY_PHOTO_HOME).toString(),
                        strAwayPhoto = columns.getValue(KEY_PHOTO_AWAY).toString(),
                        intHomeScore = columns.getValue(KEY_SCORE_HOME)?.toString() ?: "0",
                        intAwayScore = columns.getValue(KEY_SCORE_AWAY)?.toString() ?: "0",

                        idHomeTeam = columns.getValue(KEY_HOME_TEAM).toString(),
                        idAwayTeam = columns.getValue(KEY_AWAY_TEAM).toString(),

                        intRound = columns.getValue(KEY_ROUND).toString(),
                        strTime = columns.getValue(KEY_TIME).toString(),
                        dateEvent = columns.getValue(KEY_DATE).toString()
                    )
                    matches.add(match)
                    return matches
                }
            })

        matches
    }

    fun sqlLiteSelectID(id: String) = db.use {

        val result = select(MATCH_TABLE)
            .whereArgs("$KEY_ID = {idMatch}", "idMatch" to id)
            .exec { parseList(MyRowParser()) }

        result
    }

    fun sqlLiteCreate(match: Match) = db.use {
        insert(
            MATCH_TABLE,
            KEY_ID to match.idEvent,
            KEY_NAME to match.strEvent,
            KEY_PHOTO_HOME to match.strHomePhoto,
            KEY_PHOTO_AWAY to match.strAwayPhoto,
            KEY_SCORE_HOME to match.intHomeScore,
            KEY_SCORE_AWAY to match.intAwayScore,
            KEY_AWAY_TEAM to match.idAwayTeam,
            KEY_HOME_TEAM to match.idHomeTeam,
            KEY_ROUND to match.intRound,
            KEY_TIME to match.strTime,
            KEY_DATE to match.dateEvent
        )
    }

    fun matchDelete(match: Match) = db.use {
        delete(MATCH_TABLE, "$KEY_ID = {matchId}", "matchId" to match.idEvent!!)
    }

}