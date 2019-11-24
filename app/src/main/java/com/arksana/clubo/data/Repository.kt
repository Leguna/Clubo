package com.arksana.clubo.data

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.arksana.clubo.utils.RetrofitClientInstance
import com.arksana.clubo.utils.RetrofitInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit


class Repository : ViewModel() {

    val leagues = MutableLiveData<Leagues>()
    val league = MutableLiveData<League>()

    val matches = MutableLiveData<Matches>()

    val teams = ArrayList<Teams>(listOf(null, null))
    val team = MutableLiveData<ArrayList<Teams>>()

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

                if (data?.matches == null) data = Matches(emptyList())
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
                if (data?.matches == null) data = Matches(emptyList())
                matches.postValue(data)
            }
        })
    }

    fun detailMatch(id: String) {
        service?.getDetailMatch(id)?.enqueue(object : Callback<Matches> {
            override fun onFailure(call: Call<Matches>, t: Throwable) {

            }

            override fun onResponse(call: Call<Matches>, response: Response<Matches>) {
                val data = response.body()
                matches.postValue(data)
            }
        })
    }

    fun search(query: String) {
        service?.getSearch(query)?.enqueue(object : Callback<Matches> {
            override fun onFailure(call: Call<Matches>, t: Throwable) {
                println("Fail Search Data.")
            }

            override fun onResponse(call: Call<Matches>, response: Response<Matches>) {
                var data = response.body()
                if (data?.matches == null) data = Matches(emptyList())
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

    fun detailTeam(id: String, index: Int) {
        service?.getTeam(id)?.enqueue(object : Callback<Teams> {
            override fun onFailure(call: Call<Teams>, t: Throwable) {}

            override fun onResponse(call: Call<Teams>, response: Response<Teams>) {
                if (response.isSuccessful) {
                    val data = response.body()
                    teams[index] = data!!

                    if (teams[0] != null && teams[1] != null)
                        team.postValue(teams)
                }
            }
        })
    }

    fun allDetailTeam(id: Array<String>) {
        id.forEachIndexed { index, s ->
            detailTeam(s, index)

        }
    }
}
