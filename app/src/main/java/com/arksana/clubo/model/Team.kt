package com.arksana.clubo.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class Teams(
    @SerializedName("teams")
    val teams: List<Team> = listOf()
)

@Parcelize
data class Team(
    @SerializedName("idTeam")
    val idTeam: String = "", // 135152
    @SerializedName("idSoccerXML")
    val idSoccerXML: String = "", // 1345
    @SerializedName("intLoved")
    val intLoved: String = "", // 2
    @SerializedName("strTeam")
    val strTeam: String = "", // Arsenal Sarandi
    @SerializedName("strTeamShort")
    val strTeamShort: String = "", // Ars
    @SerializedName("strAlternate")
    val strAlternate: String = "",
    @SerializedName("intFormedYear")
    val intFormedYear: String = "", // 1957
    @SerializedName("strSport")
    val strSport: String = "", // Soccer
    @SerializedName("strLeague")
    val strLeague: String = "", // _No League
    @SerializedName("idLeague")
    val idLeague: String = "", // 4367
    @SerializedName("strManager")
    val strManager: String = "",
    @SerializedName("strStadium")
    val strStadium: String = "",
    @SerializedName("strKeywords")
    val strKeywords: String = "",
    @SerializedName("strRSS")
    val strRSS: String = "",
    @SerializedName("strStadiumThumb")
    val strStadiumThumb: String = "",
    @SerializedName("strStadiumDescription")
    val strStadiumDescription: String = "",
    @SerializedName("strStadiumLocation")
    val strStadiumLocation: String = "",
    @SerializedName("intStadiumCapacity")
    val intStadiumCapacity: String = "", // 18300
    @SerializedName("strWebsite")
    val strWebsite: String = "",
    @SerializedName("strFacebook")
    val strFacebook: String = "",
    @SerializedName("strTwitter")
    val strTwitter: String = "",
    @SerializedName("strInstagram")
    val strInstagram: String = "",
    @SerializedName("strDescriptionEN")
    val strDescriptionEN: String = "",
    @SerializedName("strDescriptionDE")
    val strDescriptionDE: String = "",
    @SerializedName("strDescriptionIT")
    val strDescriptionIT: String = "",
    @SerializedName("strGender")
    val strGender: String = "", // Male
    @SerializedName("strCountry")
    val strCountry: String = "", // Argentina
    @SerializedName("strTeamBadge")
    val strTeamBadge: String = "",
    @SerializedName("strTeamJersey")
    val strTeamJersey: String = "",
    @SerializedName("strTeamLogo")
    val strTeamLogo: String = "",
    @SerializedName("strTeamFanart1")
    val strTeamFanart1: String = "",
    @SerializedName("strTeamFanart2")
    val strTeamFanart2: String = "",
    @SerializedName("strTeamFanart3")
    val strTeamFanart3: String = "",
    @SerializedName("strTeamFanart4")
    val strTeamFanart4: String = "",
    @SerializedName("strTeamBanner")
    val strTeamBanner: String = "",
    @SerializedName("strYoutube")
    val strYoutube: String = ""
) : Parcelable {

    companion object {
        const val TEAM_TABLE = "Teams"
        const val TEAM_ID = "id_team"
        const val TEAM_NAME = "name_team"
        const val TEAM_COUNTRY = "country_team"
        const val TEAM_DESC = "description_team"
        const val TEAM_BADGE = "badge_team"
    }

}