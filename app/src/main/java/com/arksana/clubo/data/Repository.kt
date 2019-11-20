package com.arksana.clubo.data

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface GetDataService {

    @GET("lookupleague")
    fun detailLeague(@Query("id") id: Int?): Call<League?>?

    @GET("eventspastleague.php?")
    fun prevMatch(@Query("id") id: Int?): Call<List<Match?>?>?

    @GET("eventsnextleague")
    fun nextMatch(@Query("id") id: Int?): Call<List<Match?>?>?

    @GET("lookupevent")
    fun detailMatch(@Query("id") id: Int?): Call<Match?>?

    @GET("searcheventse=%7Bquery%7D")
    fun search(@Query("e") query: String?): Call<List<Match?>?>?

}