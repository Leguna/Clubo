package com.arksana.clubo.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


data class Matches(
    @SerializedName("events", alternate = ["event"])
    val matches: List<Match>
)

@Parcelize
data class Match(
    @SerializedName("dateEvent")
    val dateEvent: String?, // 2019-11-30
    @SerializedName("dateEventLocal")
    val dateEventLocal: String?, // 2019-11-23
    @SerializedName("idAwayTeam")
    val idAwayTeam: String?, // 133613
    @SerializedName("idEvent")
    val idEvent: String?, // 602266
    @SerializedName("idHomeTeam")
    val idHomeTeam: String?, // 134777
    @SerializedName("idLeague")
    val idLeague: String?, // 4328
    @SerializedName("idSoccerXML")
    val idSoccerXML: String?, // 402117
    @SerializedName("intAwayScore")
    val intAwayScore: String? = "0", // 3
    @SerializedName("intAwayShots")
    val intAwayShots: String?, // null
    @SerializedName("intHomeScore")
    val intHomeScore: String? = "0", // 2
    @SerializedName("intHomeShots")
    val intHomeShots: String?, // null
    @SerializedName("intRound")
    val intRound: String? = "0", // 14
    @SerializedName("intSpectators")
    val intSpectators: String?, // null
    @SerializedName("strAwayFormation")
    val strAwayFormation: String?, // null
    @SerializedName("strAwayGoalDetails")
    val strAwayGoalDetails: String?,
    @SerializedName("strAwayLineupDefense")
    val strAwayLineupDefense: String?,
    @SerializedName("strAwayLineupForward")
    val strAwayLineupForward: String?,
    @SerializedName("strAwayLineupGoalkeeper")
    val strAwayLineupGoalkeeper: String?,
    @SerializedName("strAwayLineupMidfield")
    val strAwayLineupMidfield: String?,
    @SerializedName("strAwayLineupSubstitutes")
    val strAwayLineupSubstitutes: String?,
    @SerializedName("strAwayRedCards")
    val strAwayRedCards: String?,
    @SerializedName("strAwayTeam")
    val strAwayTeam: String?, // Man City
    @SerializedName("strAwayYellowCards")
    val strAwayYellowCards: String?,
    @SerializedName("strBanner")
    val strBanner: String?, // null
    @SerializedName("strCircuit")
    val strCircuit: String?, // null
    @SerializedName("strCity")
    val strCity: String?, // null
    @SerializedName("strCountry")
    val strCountry: String?, // null
    @SerializedName("strDate")
    val strDate: String?, // 30/11/19
    @SerializedName("strDescriptionEN")
    val strDescriptionEN: String?,
    @SerializedName("strEvent")
    val strEvent: String?, // Newcastle vs Man City
    @SerializedName("strEventAlternate")
    val strEventAlternate: String?, // Man City @ Newcastle
    @SerializedName("strFanart")
    val strFanart: String?, // null
    @SerializedName("strFilename")
    val strFilename: String?, // English Premier League 2019-11-30 Newcastle vs Man City
    @SerializedName("strHomeFormation")
    val strHomeFormation: String?, // null
    @SerializedName("strHomeGoalDetails")
    val strHomeGoalDetails: String?,
    @SerializedName("strHomeLineupDefense")
    val strHomeLineupDefense: String?,
    @SerializedName("strHomeLineupForward")
    val strHomeLineupForward: String?,
    @SerializedName("strHomeLineupGoalkeeper")
    val strHomeLineupGoalkeeper: String?,
    @SerializedName("strHomeLineupMidfield")
    val strHomeLineupMidfield: String?,
    @SerializedName("strHomeLineupSubstitutes")
    val strHomeLineupSubstitutes: String?,
    @SerializedName("strHomeRedCards")
    val strHomeRedCards: String?,
    @SerializedName("strHomeTeam")
    val strHomeTeam: String?, // Newcastle
    @SerializedName("strHomeYellowCards")
    val strHomeYellowCards: String?,
    @SerializedName("strLeague")
    val strLeague: String?, // English Premier League
    @SerializedName("strLocked")
    val strLocked: String?, // unlocked
    @SerializedName("strMap")
    val strMap: String?, // null
    @SerializedName("strPoster")
    val strPoster: String?, // null
    @SerializedName("strResult")
    val strResult: String?,
    @SerializedName("strSeason")
    val strSeason: String?, // 1920
    @SerializedName("strSport")
    val strSport: String?, // Soccer
    @SerializedName("strTVStation")
    val strTVStation: String?, // null
    @SerializedName("strThumb")
    val strThumb: String?, // https://www.thesportsdb.com/images/media/event/thumb/e84qfr1574511008.jpg
    @SerializedName("strTime")
    val strTime: String?, // 12:30:00
    @SerializedName("strTimeLocal")
    val strTimeLocal: String? // 13:30:00
) : Parcelable


