package com.arksana.clubo.data

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.arksana.clubo.utils.RetrofitClientInstance
import com.arksana.clubo.utils.RetrofitInterface
import retrofit2.*


class Repository : ViewModel() {

    val leagues = MutableLiveData<Leagues>()
    var items: ArrayList<League> = ArrayList()

    val retrofit: Retrofit? = RetrofitClientInstance.retrofitInstance
    val service = retrofit?.create(RetrofitInterface::class.java)

    fun listLeague() {
        service?.getListLeague()?.enqueue(object : Callback<Leagues> {
            override fun onResponse(call: Call<Leagues>, response: Response<Leagues>) {
                if (response.isSuccessful) {
                    val data = response.body()
                    leagues.postValue(data)
                }
            }

            override fun onFailure(call: Call<Leagues>, error: Throwable) {
                Log.e("tag", "errornya ${error.message}")
            }
        })
    }

    fun detailLeague(id: Int) {
        service?.getDetailLeague(id)?.enqueue(object : Callback<League?> {


            override fun onResponse(call: Call<League?>, response: Response<League?>) {
                if (response.isSuccessful) {
                    val data = response.body()
                    Log.d("tag", "responsennya ${data}")
                }
            }

            override fun onFailure(call: Call<League?>, t: Throwable) {
                println("Errornya: " + t)
            }
        })
    }

    fun prevMatch() {

    }

    fun nextMatch() {

    }

    fun detailMatch() {

    }

    fun search() {

    }
}