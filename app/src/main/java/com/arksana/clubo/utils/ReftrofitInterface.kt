package com.arksana.clubo.utils

import com.arksana.clubo.data.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface RetrofitInterface {

    @GET("search_all_leagues.php?s=Soccer")
    fun getListLeague(): Call<Leagues>

    @GET("lookupleague")
    fun getDetailLeague(@Query("id") id: String): Call<League>

    @GET("eventspastleague.php?")
    fun getPrevMatch(@Query("id") id: String): Call<Matches>

    @GET("eventsnextleague.php?")
    fun getNextMatch(@Query("id") id: String): Call<Matches>

    @GET("lookupevent")
    fun getDetailMatch(@Query("id") id: String): Call<Match>

    @GET("searchevents.php?")
    fun getSearch(@Query("e") query: String): Call<Matches>

    @GET("lookupteam.php?")
    fun getTeam(@Query("id") id: String): Call<Team>
}