package com.dicoding.githubappuser.ui.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dicoding.githubappuser.api.RetrofitClient
import com.dicoding.githubappuser.data.model.DetailUserResponse
import retrofit2.Response

class DetailUserViewModel: ViewModel() {
    var user = MutableLiveData<DetailUserResponse>()

    fun setUserDetail(username: String?){
        RetrofitClient.apiInstance
            .getUserDetail(username)
            .enqueue(object : retrofit2.Callback<DetailUserResponse>{
                override fun onResponse(
                    call: retrofit2.Call<DetailUserResponse>,
                    response: Response<DetailUserResponse>
                ) {
                    if(response.isSuccessful){
                        user.postValue(response.body())
                    }
                }

                override fun onFailure(call: retrofit2.Call<DetailUserResponse>, t: Throwable) {
                    Log.d("Failure", t.message!!)
                }

            })
    }
    fun getUserDetail(): LiveData<DetailUserResponse> {
        return user
    }
}