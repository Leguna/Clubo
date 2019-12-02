package com.arksana.clubo.data

import com.arksana.clubo.data.Match.Companion.KEY_DATE
import com.arksana.clubo.data.Match.Companion.KEY_ID
import com.arksana.clubo.data.Match.Companion.KEY_NAME
import com.arksana.clubo.data.Match.Companion.KEY_PHOTO_AWAY
import com.arksana.clubo.data.Match.Companion.KEY_PHOTO_HOME
import com.arksana.clubo.data.Match.Companion.KEY_ROUND
import com.arksana.clubo.data.Match.Companion.KEY_SCORE_AWAY
import com.arksana.clubo.data.Match.Companion.KEY_SCORE_HOME
import com.arksana.clubo.data.Match.Companion.KEY_TABLE
import com.arksana.clubo.data.Match.Companion.KEY_TIME
import com.arksana.clubo.utils.MyDatabaseOpenHelper
import org.jetbrains.anko.db.*

class AnkoSQL(private val db: MyDatabaseOpenHelper) {

    fun sqlLiteFindAll(): ArrayList<Match> = db.use {
        val matches = ArrayList<Match>()

        select(KEY_TABLE)
            .parseList(object : MapRowParser<List<Match>> {
                override fun parseRow(columns: Map<String, Any?>): List<Match> {
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

                    matches.add(match)

                    return matches
                }
            })

        matches
    }

    fun sqlLiteSelectID(id: String) = db.use {

        val result = select(KEY_TABLE).whereArgs("$KEY_ID = {idMatch}", "idMatch" to id).exec {
            parseList(classParser<Match>())
        }

        result
    }

    fun sqlLiteCreate(match: Match) = db.use {
        insert(
            KEY_TABLE,
            KEY_ID to match.idEvent,
            KEY_NAME to match.strEvent,
            KEY_PHOTO_HOME to match.strHomePhoto,
            KEY_PHOTO_AWAY to match.strAwayPhoto,
            KEY_SCORE_HOME to match.intHomeScore,
            KEY_SCORE_AWAY to match.intAwayScore,
            KEY_ROUND to match.intRound,
            KEY_TIME to match.strTime,
            KEY_DATE to match.dateEvent
        )
    }

    fun sqlLiteDelete(match: Match) = db.use {
        delete(KEY_TABLE, "$KEY_ID = {matchId}", "matchId" to match.idEvent!!)
    }

//    fun sqlLiteUpdate(match: Match) = context.database.use {
//        val updateResult = update(
//            "Matches",
//            "title" to match.title,
//            "content" to match.content
//        )
//            .whereArgs("id = {matchId}", "matchId" to match.id)
//            .exec()
//
//        Timber.d("Update result code is $updateResult")
//    }

}