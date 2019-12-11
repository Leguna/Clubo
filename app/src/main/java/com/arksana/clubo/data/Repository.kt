package com.arksana.clubo.data

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.arksana.clubo.model.League
import com.arksana.clubo.model.Leagues
import com.arksana.clubo.model.Matches
import com.arksana.clubo.model.Teams
import com.arksana.clubo.utils.EspressoIdlingResource
import com.arksana.clubo.utils.RetrofitClientInstance
import com.arksana.clubo.utils.RetrofitInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit


open class Repository : ViewModel() {

    val leagues = MutableLiveData<Leagues>()
    val league = MutableLiveData<League>()

    val matches = MutableLiveData<Matches>()
    val matches2 = MutableLiveData<Matches>()
    val matches3 = MutableLiveData<Matches>()

    val teams = ArrayList<Teams>(listOf(null, null))
    val team = MutableLiveData<ArrayList<Teams>>()

    private val retrofit: Retrofit? = RetrofitClientInstance.retrofitInstance
    private val service = retrofit?.create(RetrofitInterface::class.java)

    fun listLeague() {
        EspressoIdlingResource.increment()
        service?.getListLeague()?.enqueue(object : Callback<Leagues> {
            override fun onResponse(call: Call<Leagues>, response: Response<Leagues>) {
                if (response.isSuccessful) {
                    val data = response.body()
                    leagues.postValue(data)
                    EspressoIdlingResource.decrement()
                }
            }
            override fun onFailure(call: Call<Leagues>, error: Throwable) {
                println("ListLeague Error")
                EspressoIdlingResource.decrement()
            }
        })
    }

    fun prevMatch(id: String) {
        EspressoIdlingResource.increment()
        service?.getPrevMatch(id)?.enqueue(object : Callback<Matches> {
            override fun onFailure(call: Call<Matches>, t: Throwable) {
                println("PrevMatch Error")
                EspressoIdlingResource.decrement()
            }

            override fun onResponse(call: Call<Matches>, response: Response<Matches>) {
                var data = response.body()

                if (data?.matches == null) data =
                    Matches(emptyList())
                matches.postValue(data)
                EspressoIdlingResource.decrement()
            }
        })
    }

    fun nextMatch(id: String) {
        EspressoIdlingResource.increment()
        service?.getNextMatch(id)?.enqueue(object : Callback<Matches> {
            override fun onFailure(call: Call<Matches>, t: Throwable) {
                println("NextMatch Error")
                EspressoIdlingResource.decrement()
            }

            override fun onResponse(call: Call<Matches>, response: Response<Matches>) {
                var data = response.body()
                if (data?.matches == null) data =
                    Matches(emptyList())
                matches2.postValue(data)
                EspressoIdlingResource.decrement()
            }
        })
    }

    fun detailMatch(id: String) {
        EspressoIdlingResource.increment()
        service?.getDetailMatch(id)?.enqueue(object : Callback<Matches> {
            override fun onFailure(call: Call<Matches>, t: Throwable) {
                EspressoIdlingResource.decrement()
            }

            override fun onResponse(call: Call<Matches>, response: Response<Matches>) {
                val data = response.body()
                matches.postValue(data)
                EspressoIdlingResource.decrement()
            }
        })
    }

    fun search(query: String) {
        EspressoIdlingResource.increment()
        service?.getSearch(query)?.enqueue(object : Callback<Matches> {
            override fun onFailure(call: Call<Matches>, t: Throwable) {
                println("Fail Search Data.")
                EspressoIdlingResource.decrement()
            }

            override fun onResponse(call: Call<Matches>, response: Response<Matches>) {
                var data = response.body()
                if (data?.matches == null) data =
                    Matches(emptyList())
                matches3.postValue(Matches(data.matches.filter { it.strSport == "Soccer" }))
                EspressoIdlingResource.decrement()
            }
        })
    }

    fun detailLeague(id: String) {
        EspressoIdlingResource.increment()
        service?.getDetailLeague(id)?.enqueue(object : Callback<Leagues?> {
            override fun onResponse(call: Call<Leagues?>, response: Response<Leagues?>) {
                if (response.isSuccessful) {
                    val data = response.body()
                    league.postValue(data?.leagues?.get(0))
                }

                println("DetailLeague:" + call.request().url())
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<Leagues?>, t: Throwable) {
                println("Error: $t")
                EspressoIdlingResource.decrement()
            }
        })
    }

    private fun detailTeam(id: String, index: Int) {
        EspressoIdlingResource.increment()
        service?.getTeam(id)?.enqueue(object : Callback<Teams> {
            override fun onFailure(call: Call<Teams>, t: Throwable) {
                EspressoIdlingResource.decrement()
            }

            override fun onResponse(call: Call<Teams>, response: Response<Teams>) {
                if (response.isSuccessful) {
                    val data = response.body()
                    teams[index] = data!!
                    if (teams[0] != null && teams[1] != null)
                        team.postValue(teams)
                }
                EspressoIdlingResource.decrement()
            }

        })
    }

    fun allDetailTeam(ids: Array<String>) {
        ids.forEachIndexed { index, id ->
            detailTeam(id, index)
        }
    }


}
