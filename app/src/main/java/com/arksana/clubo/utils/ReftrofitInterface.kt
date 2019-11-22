package com.arksana.clubo.utils

import com.arksana.clubo.data.League
import com.arksana.clubo.data.Leagues
import com.arksana.clubo.data.Match
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface RetrofitInterface {

    @GET("search_all_leagues.php?s=Soccer")
    fun getListLeague(): Call<Leagues>

    @GET("lookupleague")
    fun getDetailLeague(@Query("id") id: Int): Call<League>

    @GET("eventspastleague.php?")
    fun getPrevMatch(@Query("id") id: Int): Call<List<Match>>

    @GET("eventsnextleague")
    fun getNextMatch(@Query("id") id: Int): Call<List<Match>>

    @GET("lookupevent")
    fun getDetailMatch(@Query("id") id: Int): Call<Match>

    @GET("searchevents.php")
    fun getSearch(@Query("e") query: String): Call<List<Match>>

}