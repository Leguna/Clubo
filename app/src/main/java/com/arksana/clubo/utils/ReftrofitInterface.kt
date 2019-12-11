package com.arksana.clubo.utils

import com.arksana.clubo.model.Leagues
import com.arksana.clubo.model.Matches
import com.arksana.clubo.model.Standings
import com.arksana.clubo.model.Teams
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface RetrofitInterface {

    @GET("search_all_leagues.php?s=Soccer")
    fun getListLeague(): Call<Leagues>

    @GET("lookupleague.php?")
    fun getDetailLeague(@Query("id") id: String): Call<Leagues>

    @GET("eventspastleague.php?")
    fun getPrevMatch(@Query("id") id: String): Call<Matches>

    @GET("eventsnextleague.php?")
    fun getNextMatch(@Query("id") id: String): Call<Matches>

    @GET("lookupevent.php?")
    fun getDetailMatch(@Query("id") id: String): Call<Matches>

    @GET("searchevents.php?")
    fun getSearch(@Query("e") query: String): Call<Matches>

    @GET("lookup_all_teams.php?")
    fun getTeamList(@Query("id") id: String): Call<Teams>

    @GET("lookupteam.php?")
    fun getTeam(@Query("id") id: String): Call<Teams>

    @GET("lookuptable.php?")
    fun getStandings(@Query("l") id: String): Call<Standings>
}