package com.arksana.clubo.data

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.arksana.clubo.utils.RetrofitClientInstance
import com.arksana.clubo.utils.RetrofitInterface
import retrofit2.*


class Repository : ViewModel() {

    val leagues = MutableLiveData<Leagues>()
    val league = MutableLiveData<League>()

    val matches = MutableLiveData<Matches>()
    val match = MutableLiveData<Match>()

    val team = MutableLiveData<Team>()

    private val retrofit: Retrofit? = RetrofitClientInstance.retrofitInstance
    private val service = retrofit?.create(RetrofitInterface::class.java)

    fun listLeague() {
        service?.getListLeague()?.enqueue(object : Callback<Leagues> {
            override fun onResponse(call: Call<Leagues>, response: Response<Leagues>) {
                if (response.isSuccessful) {
                    val data = response.body()
                    leagues.postValue(data)
                }
            }
            override fun onFailure(call: Call<Leagues>, error: Throwable) {
                println("ListLeague Error")
            }
        })
    }

    fun prevMatch(id: String) {
        service?.getPrevMatch(id)?.enqueue(object : Callback<Matches> {
            override fun onFailure(call: Call<Matches>, t: Throwable) {
                println("PrevMatch Error")
            }

            override fun onResponse(call: Call<Matches>, response: Response<Matches>) {
                var data = response.body()

                println(data?.matches == null)
                if (data?.matches == null) data = Matches(emptyList())
                println("Prev: ")
                matches.postValue(data)
            }
        })
    }

    fun nextMatch(id: String) {
        service?.getNextMatch(id)?.enqueue(object : Callback<Matches> {
            override fun onFailure(call: Call<Matches>, t: Throwable) {
                println("NextMatch Error")
            }

            override fun onResponse(call: Call<Matches>, response: Response<Matches>) {
                var data = response.body()
                println(data?.matches == null)
                if (data?.matches == null) data = Matches(emptyList())
                println("Next: ")
                matches.postValue(data)
            }
        })
    }

    fun detailMatch(id: String) {
        service?.getDetailMatch(id)?.enqueue(object : Callback<Match> {
            override fun onFailure(call: Call<Match>, t: Throwable) {

            }

            override fun onResponse(call: Call<Match>, response: Response<Match>) {
                val data = response.body()
                match.postValue(data)
            }
        })
    }

    fun search(query: String) {
        service?.getSearch(query)?.enqueue(object : Callback<Matches> {
            override fun onFailure(call: Call<Matches>, t: Throwable) {
                println("Fail Search Data.")
            }

            override fun onResponse(call: Call<Matches>, response: Response<Matches>) {
                val data = response.body()
                matches.postValue(data)
            }
        })
    }

    fun detailLeague(id: String) {
        service?.getDetailLeague(id)?.enqueue(object : Callback<League?> {
            override fun onResponse(call: Call<League?>, response: Response<League?>) {
                if (response.isSuccessful) {
                    val data = response.body()
                    league.postValue(data)
                }
            }
            override fun onFailure(call: Call<League?>, t: Throwable) {
                println("Errornya: $t")
            }
        })
    }

    fun detailTeam(id: String) {
        service?.getTeam(id)?.enqueue(object : Callback<Team> {
            override fun onFailure(call: Call<Team>, t: Throwable) {}

            override fun onResponse(call: Call<Team>, response: Response<Team>) {
                if (response.isSuccessful) {
                    val data = response.body()
                    team.postValue(data)
                }
            }
        })
    }
}
