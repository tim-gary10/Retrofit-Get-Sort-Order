package com.garyjmj.retrofit.api

import com.garyjmj.retrofit.model.Users
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface SimpleApi {

    // /posts/1
    @GET("/posts/1")
    suspend fun getPost() : Response<Users>

    // /posts/4/
    @GET("posts/{postNumber}")
    suspend fun getPost2( @Path("postNumber") number: Int): Response<Users>

    // /posts?userId=3 and add (/posts?userId=3&_sort=id&_order=desc)
    @GET("posts")
    suspend fun getCustomPosts(
            @Query("userId") userId: Int,
            @Query("_sort") sort: String,
            @Query("_order") order: String
    ):Response<List<Users>>

    @GET("posts")
    suspend fun getCustomPosts2(
            @Query("userId") userId: Int,
            @QueryMap options: Map<String, String>
    ): Response<List<Users>>


}