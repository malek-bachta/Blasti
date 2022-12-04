package tn.mbach.warnMe.Network;

import com.google.gson.JsonObject;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET
import retrofit2.http.POST;
import tn.mbach.warnMe.Models.Events


interface EventsApi {


     @GET("api/events/all")
     fun  showEvents(): Call<List<Events>>

    @POST("api/events/add")
    fun addEvent(@Body map :HashMap<String, String>): Call<HashMap<String, String>>


}
