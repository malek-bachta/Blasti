package tn.mbach.warnMe.Network

import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Response

import retrofit2.http.*
import tn.mbach.warnMe.Models.User
import java.util.*


interface UserApi {
    //Login Méthode 1
    @POST("api/user/login")
    fun login1(
        @Body body: JsonObject
    ): Call<JsonObject>
    // A suspending function is simply a function that can be paused and resumed at a later time. They can execute a long running operation and wait for it to complete without blocking.
    //Login Méthode 2
    @POST("api/user/login")
    suspend fun login2(@Body User: Loginresponse): Response<Loginresponse>
    //
    @POST("api/user/register")
    fun signup(@Body map : HashMap<String, String> ): Call<JsonObject>

}