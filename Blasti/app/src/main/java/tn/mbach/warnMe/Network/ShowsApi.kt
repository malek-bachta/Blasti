package tn.mbach.Blasti.Network;

import com.google.gson.JsonObject
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Response
import retrofit2.http.Body;
import retrofit2.http.GET
import retrofit2.http.POST;
import tn.mbach.Blasti.Models.Shows
import tn.mbach.Blasti.Models.User


interface ShowsApi {


     @GET("api/shows/all")
     fun  affShows(): Call<List<Shows>>

    @POST("api/shows/add")
    fun addShow(@Body map :HashMap<String, String>): Call<HashMap<String, String>>


    @POST("api/favoriteShow/add")
    fun AddFavorite(@Body map : HashMap<String, String>): Call<JsonObject>

    @POST("api/favoriteShow/FavoritefindByUser")
    fun FavoritefindByUser(@Body map : HashMap<String, String>): Call<List<Shows>>

    @POST("api/favoriteShow/delete")
    fun FavoriteDelete(@Body map : HashMap<String, String>): Call<JsonObject>

    @POST("api/favoriteShow/verif")
    suspend fun VerifFavorite(@Body map : HashMap<String, String>): Response<Shows>



}
