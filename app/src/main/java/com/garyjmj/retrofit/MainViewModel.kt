package com.garyjmj.retrofit

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.garyjmj.retrofit.model.Users
import com.garyjmj.retrofit.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response
import java.nio.ByteOrder

class MainViewModel(private val repository: Repository): ViewModel() {

    var myResponse: MutableLiveData<Response<Users>> = MutableLiveData()
    var myResponse2: MutableLiveData<Response<Users>> = MutableLiveData()
    var myCustomPosts: MutableLiveData<Response<List<Users>>> = MutableLiveData()
    var myCustomPosts2: MutableLiveData<Response<List<Users>>> = MutableLiveData()



    fun getPost(){
        viewModelScope.launch {
            val response = repository.getPost()
            myResponse.value = response
        }
    }

    fun getPost2(number: Int){
        viewModelScope.launch {
            val response = repository.getPost2(number)
            myResponse2.value = response
        }
    }

    fun getCustomPosts(userId : Int, sort: String, order: String){
        viewModelScope.launch {
            val response = repository.getCustomPosts(userId, sort, order)
            myCustomPosts.value = response
        }
    }

    fun getCustomPosts2(userId: Int, options: Map<String, String>){
        viewModelScope.launch {
            val response = repository.getCustomPosts2(userId, options)
            myCustomPosts2.value = response
        }
    }
}