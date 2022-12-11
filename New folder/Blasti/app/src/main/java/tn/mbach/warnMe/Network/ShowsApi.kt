package tn.mbach.warnMe.Network;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET
import retrofit2.http.POST;
import tn.mbach.warnMe.Models.Shows


interface ShowsApi {


     @GET("api/shows/all")
     fun  affShows(): Call<List<Shows>>

    @POST("api/shows/add")
    fun addShow(@Body map :HashMap<String, String>): Call<HashMap<String, String>>


}
