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
    var dateEvent: String? = "2019-11-30", // 2019-11-30
    @SerializedName("idAwayTeam")
    val idAwayTeam: String? = "", // 133613
    @SerializedName("idEvent")
    var idEvent: String? = "", // 602266
    @SerializedName("idHomeTeam")
    val idHomeTeam: String? = "", // 134777
    @SerializedName("idLeague")
    val idLeague: String? = "", // 4328
    @SerializedName("intAwayScore")
    var intAwayScore: String? = "0", // 3
    @SerializedName("intHomeScore")
    var intHomeScore: String? = "0", // 2
    @SerializedName("intRound")
    var intRound: String? = "0", // 14
    @SerializedName("strAwayFormation")
    val strAwayFormation: String? = "", // null
    @SerializedName("strAwayGoalDetails")
    val strAwayGoalDetails: String? = "",
    @SerializedName("strAwayLineupGoalkeeper")
    val strAwayLineupGoalkeeper: String? = "",
    @SerializedName("strAwayTeam")
    val strAwayTeam: String? = "", // Man City
    @SerializedName("strCountry")
    val strCountry: String? = "", // null
    @SerializedName("strEvent")
    var strEvent: String? = "", // Newcastle vs Man City
    @SerializedName("strHomeFormation")
    val strHomeFormation: String? = "", // null
    @SerializedName("strHomeGoalDetails")
    val strHomeGoalDetails: String? = "",
    @SerializedName("strHomeLineupGoalkeeper")
    val strHomeLineupGoalkeeper: String? = "",
    @SerializedName("strHomeTeam")
    val strHomeTeam: String? = "", // Newcastle
    @SerializedName("strLeague")
    val strLeague: String? = "", // English Premier League
    @SerializedName("strSport")
    val strSport: String? = "", // Soccer
    @SerializedName("strTime")
    var strTime: String? = "", // 12:30:00

    var strAwayPhoto: String? = "",
    var strHomePhoto: String? = ""
) : Parcelable {

    constructor()


    companion object {
        const val KEY_TABLE = "Matches"
        const val KEY_ID = "idEvent"
        const val KEY_NAME = "strEvent"
        const val KEY_TIME = "strTime"
        const val KEY_DATE = "dateEvent"
        const val KEY_ROUND = "intRound"
        const val KEY_PHOTO_AWAY = "strAwayPhoto"
        const val KEY_PHOTO_HOME = "strHomePhoto"
        const val KEY_SCORE_AWAY = "intAwayScore"
        const val KEY_SCORE_HOME = "intHomeScore"
    }

}


