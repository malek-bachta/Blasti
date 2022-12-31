package tn.mbach.warnMe.Network;

import com.google.gson.JsonObject;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Response
import retrofit2.http.Body;
import retrofit2.http.GET
import retrofit2.http.POST;
import tn.mbach.warnMe.Models.Events
import tn.mbach.warnMe.Models.User


interface EventsApi {


     @GET("api/events/all")
     fun  showEvents(): Call<List<Events>>

    @POST("api/events/add")
    fun addEvent(@Body map :HashMap<String, String>): Call<HashMap<String, String>>


    @POST("api/favoriteEvent/add")
    fun AddFavorite(@Body map : HashMap<String, String>): Call<JsonObject>

    @POST("api/favoriteEvent/FavoritefindByUser")
    fun FavoritefindByUser(@Body map : HashMap<String, String>): Call<List<User>>

    @POST("api/favoriteEvent/delete")
    fun FavoriteDelete(@Body map : HashMap<String, String>): Call<JsonObject>

    @POST("api/favoriteEvent/verif")
    suspend fun VerifFavorite(@Body map : HashMap<String, String>): Response<Events>


}
