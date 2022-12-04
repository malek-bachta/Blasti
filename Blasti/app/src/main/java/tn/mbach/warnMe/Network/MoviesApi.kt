package tn.mbach.warnMe.Network;

import com.google.gson.JsonObject;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET
import retrofit2.http.POST;
import tn.mbach.warnMe.Models.moviesss

interface MoviesApi {


     @GET("api/movies/all")
     fun  showmovies(): Call<List<moviesss>>

    @POST("api/movies/add")
    fun addmovie(@Body map :HashMap<String, String>): Call<HashMap<String, String>>


}
