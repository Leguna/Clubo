package com.arksana.clubo.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


data class Matches(
    @SerializedName("events")
    val matches: List<Match>
)

@Parcelize
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
    val idSoccerXML: String, // null
    @SerializedName("intAwayScore")
    val intAwayScore: String, // 107
    @SerializedName("intAwayShots")
    val intAwayShots: String, // null
    @SerializedName("intHomeScore")
    val intHomeScore: String, // 112
    @SerializedName("intHomeShots")
    val intHomeShots: String, // null
    @SerializedName("intRound")
    val intRound: String, // 0
    @SerializedName("intSpectators")
    val intSpectators: String, // null
    @SerializedName("strAwayFormation")
    val strAwayFormation: String, // null
    @SerializedName("strAwayGoalDetails")
    val strAwayGoalDetails: String, // null
    @SerializedName("strAwayLineupDefense")
    val strAwayLineupDefense: String, // null
    @SerializedName("strAwayLineupForward")
    val strAwayLineupForward: String, // null
    @SerializedName("strAwayLineupGoalkeeper")
    val strAwayLineupGoalkeeper: String, // null
    @SerializedName("strAwayLineupMidfield")
    val strAwayLineupMidfield: String, // null
    @SerializedName("strAwayLineupSubstitutes")
    val strAwayLineupSubstitutes: String, // null
    @SerializedName("strAwayRedCards")
    val strAwayRedCards: String, // null
    @SerializedName("strAwayTeam")
    val strAwayTeam: String, // Boston Celtics
    @SerializedName("strAwayYellowCards")
    val strAwayYellowCards: String, // null
    @SerializedName("strBanner")
    val strBanner: String, // null
    @SerializedName("strCircuit")
    val strCircuit: String, // null
    @SerializedName("strCity")
    val strCity: String, // null
    @SerializedName("strCountry")
    val strCountry: String, // null
    @SerializedName("strDate")
    val strDate: String, // null
    @SerializedName("strDescriptionEN")
    val strDescriptionEN: String, // null
    @SerializedName("strEvent")
    val strEvent: String, // Los Angeles Clippers vs Boston Celtics
    @SerializedName("strEventAlternate")
    val strEventAlternate: String, // Boston Celtics @ Los Angeles Clippers
    @SerializedName("strFanart")
    val strFanart: String, // null
    @SerializedName("strFilename")
    val strFilename: String, // NBA 2019-11-21 Los Angeles Clippers vs Boston Celtics
    @SerializedName("strHomeFormation")
    val strHomeFormation: String, // null
    @SerializedName("strHomeGoalDetails")
    val strHomeGoalDetails: String, // null
    @SerializedName("strHomeLineupDefense")
    val strHomeLineupDefense: String, // null
    @SerializedName("strHomeLineupForward")
    val strHomeLineupForward: String, // null
    @SerializedName("strHomeLineupGoalkeeper")
    val strHomeLineupGoalkeeper: String, // null
    @SerializedName("strHomeLineupMidfield")
    val strHomeLineupMidfield: String, // null
    @SerializedName("strHomeLineupSubstitutes")
    val strHomeLineupSubstitutes: String, // null
    @SerializedName("strHomeRedCards")
    val strHomeRedCards: String, // null
    @SerializedName("strHomeTeam")
    val strHomeTeam: String, // Los Angeles Clippers
    @SerializedName("strHomeYellowCards")
    val strHomeYellowCards: String, // null
    @SerializedName("strLeague")
    val strLeague: String, // NBA
    @SerializedName("strLocked")
    val strLocked: String, // unlocked
    @SerializedName("strMap")
    val strMap: String, // null
    @SerializedName("strPoster")
    val strPoster: String, // null
    @SerializedName("strResult")
    val strResult: String, // null
    @SerializedName("strSeason")
    val strSeason: String, // 1920
    @SerializedName("strSport")
    val strSport: String, // Basketball
    @SerializedName("strTVStation")
    val strTVStation: String, // null
    @SerializedName("strThumb")
    val strThumb: String, // null
    @SerializedName("strTime")
    val strTime: String, // 03:00:00
    @SerializedName("strTimeLocal")
    val strTimeLocal: String, // 10:00 PM ET
    @SerializedName("strTweet1")
    val strTweet1: String, // null
    @SerializedName("strTweet2")
    val strTweet2: String, // null
    @SerializedName("strTweet3")
    val strTweet3: String, // null
    @SerializedName("strVideo")
    val strVideo: String // null
) : Parcelable



