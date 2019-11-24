package com.arksana.clubo.utils

import com.arksana.clubo.data.Leagues
import com.arksana.clubo.data.Matches
import com.arksana.clubo.data.Teams
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

    @GET("lookupteam.php?")
    fun getTeam(@Query("id") id: String): Call<Teams>
}