package com.arksana.clubo.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


data class Matches(
        @SerializedName("events")
        val events: List<Match>
)


data class Match(
        @SerializedName("dateEvent")
        val dateEvent: String, // 2019-11-21
        @SerializedName("dateEventLocal")
        val dateEventLocal: String, // 2019-11-20
        @SerializedName("idAwayTeam")
        val idAwayTeam: String, // 134860
        @SerializedName("idEvent")
        val idEvent: String, // 647900
        @SerializedName("idHomeTeam")
        val idHomeTeam: String, // 134866
        @SerializedName("idLeague")
        val idLeague: String, // 4387
        @SerializedName("idSoccerXML")
        val idSoccerXML: Any, // null
        @SerializedName("intAwayScore")
        val intAwayScore: String, // 107
        @SerializedName("intAwayShots")
        val intAwayShots: Any, // null
        @SerializedName("intHomeScore")
        val intHomeScore: String, // 112
        @SerializedName("intHomeShots")
        val intHomeShots: Any, // null
        @SerializedName("intRound")
        val intRound: String, // 0
        @SerializedName("intSpectators")
        val intSpectators: Any, // null
        @SerializedName("strAwayFormation")
        val strAwayFormation: Any, // null
        @SerializedName("strAwayGoalDetails")
        val strAwayGoalDetails: Any, // null
        @SerializedName("strAwayLineupDefense")
        val strAwayLineupDefense: Any, // null
        @SerializedName("strAwayLineupForward")
        val strAwayLineupForward: Any, // null
        @SerializedName("strAwayLineupGoalkeeper")
        val strAwayLineupGoalkeeper: Any, // null
        @SerializedName("strAwayLineupMidfield")
        val strAwayLineupMidfield: Any, // null
        @SerializedName("strAwayLineupSubstitutes")
        val strAwayLineupSubstitutes: Any, // null
        @SerializedName("strAwayRedCards")
        val strAwayRedCards: Any, // null
        @SerializedName("strAwayTeam")
        val strAwayTeam: String, // Boston Celtics
        @SerializedName("strAwayYellowCards")
        val strAwayYellowCards: Any, // null
        @SerializedName("strBanner")
        val strBanner: Any, // null
        @SerializedName("strCircuit")
        val strCircuit: Any, // null
        @SerializedName("strCity")
        val strCity: Any, // null
        @SerializedName("strCountry")
        val strCountry: Any, // null
        @SerializedName("strDate")
        val strDate: Any, // null
        @SerializedName("strDescriptionEN")
        val strDescriptionEN: Any, // null
        @SerializedName("strEvent")
        val strEvent: String, // Los Angeles Clippers vs Boston Celtics
        @SerializedName("strEventAlternate")
        val strEventAlternate: String, // Boston Celtics @ Los Angeles Clippers
        @SerializedName("strFanart")
        val strFanart: Any, // null
        @SerializedName("strFilename")
        val strFilename: String, // NBA 2019-11-21 Los Angeles Clippers vs Boston Celtics
        @SerializedName("strHomeFormation")
        val strHomeFormation: Any, // null
        @SerializedName("strHomeGoalDetails")
        val strHomeGoalDetails: Any, // null
        @SerializedName("strHomeLineupDefense")
        val strHomeLineupDefense: Any, // null
        @SerializedName("strHomeLineupForward")
        val strHomeLineupForward: Any, // null
        @SerializedName("strHomeLineupGoalkeeper")
        val strHomeLineupGoalkeeper: Any, // null
        @SerializedName("strHomeLineupMidfield")
        val strHomeLineupMidfield: Any, // null
        @SerializedName("strHomeLineupSubstitutes")
        val strHomeLineupSubstitutes: Any, // null
        @SerializedName("strHomeRedCards")
        val strHomeRedCards: Any, // null
        @SerializedName("strHomeTeam")
        val strHomeTeam: String, // Los Angeles Clippers
        @SerializedName("strHomeYellowCards")
        val strHomeYellowCards: Any, // null
        @SerializedName("strLeague")
        val strLeague: String, // NBA
        @SerializedName("strLocked")
        val strLocked: String, // unlocked
        @SerializedName("strMap")
        val strMap: Any, // null
        @SerializedName("strPoster")
        val strPoster: Any, // null
        @SerializedName("strResult")
        val strResult: Any, // null
        @SerializedName("strSeason")
        val strSeason: String, // 1920
        @SerializedName("strSport")
        val strSport: String, // Basketball
        @SerializedName("strTVStation")
        val strTVStation: Any, // null
        @SerializedName("strThumb")
        val strThumb: Any, // null
        @SerializedName("strTime")
        val strTime: String, // 03:00:00
        @SerializedName("strTimeLocal")
        val strTimeLocal: String, // 10:00 PM ET
        @SerializedName("strTweet1")
        val strTweet1: Any, // null
        @SerializedName("strTweet2")
        val strTweet2: Any, // null
        @SerializedName("strTweet3")
        val strTweet3: Any, // null
        @SerializedName("strVideo")
        val strVideo: Any // null
)

