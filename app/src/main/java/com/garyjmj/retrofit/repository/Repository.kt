package com.garyjmj.retrofit.repository

import com.garyjmj.retrofit.api.RetrofitInstance
import com.garyjmj.retrofit.model.Users
import retrofit2.Response

class Repository {

    suspend fun getPost(): Response<Users>{
        return RetrofitInstance.api.getPost()
    }

    suspend fun getPost2(number: Int): Response<Users>{
        return RetrofitInstance.api.getPost2(number)
    }

    suspend fun getCustomPosts(userId: Int, sort: String, order: String): Response<List<Users>>{
        return RetrofitInstance.api.getCustomPosts(userId, sort, order)
    }

    suspend fun getCustomPosts2(userId: Int, options: Map<String, String>): Response<List<Users>>{
        return RetrofitInstance.api.getCustomPosts2(userId, options)
    }

}