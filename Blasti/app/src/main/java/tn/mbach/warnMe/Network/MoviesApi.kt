package tn.mbach.warnMe.Network;

import com.google.gson.JsonObject;
import okhttp3.MultipartBody
import okhttp3.RequestBody
import org.intellij.lang.annotations.Language

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Response
import retrofit2.http.*
import tn.mbach.warnMe.Models.User
import tn.mbach.warnMe.Models.moviesss
import tn.mbach.warnMe.front.MovieGenre

interface MoviesApi {


     @GET("api/movies/all")
     fun  showmovies(): Call<List<moviesss>>

   // @POST("api/movies/add")
    //fun addmovie(@Body map :HashMap<String, String>): Call<HashMap<String, String>>

/////////////////////////

    @POST("api/favoriteMovie/add")
    fun AddFavorite(@Body map : HashMap<String, String>): Call<JsonObject>

    @POST("api/favoriteMovie/FavoritefindByUser")
    fun FavoritefindByUser(@Body map : HashMap<String, String>): Call<List<moviesss>>

    @POST("api/favoriteMovie/delete")
    fun FavoriteDelete(@Body map : HashMap<String, String>): Call<JsonObject>

    @POST("api/favoriteMovie/verif")
    suspend fun VerifFavorite(@Body map : HashMap<String, String>): Response<moviesss>

    @Multipart
    @POST("api/movies/add")
    fun addmovie(
        @Part("title") title: RequestBody,
        @Part("date") date: RequestBody,
        @Part("description") description: RequestBody,
        @Part("genre") genre: RequestBody,
        @Part image: MultipartBody.Part,
        @Part("duration") duration: RequestBody,
        @Part("language") language: RequestBody,
        @Part("production") production: RequestBody,
        @Part("rating") rating: RequestBody,

        ):Call<Loginresponse>
}
