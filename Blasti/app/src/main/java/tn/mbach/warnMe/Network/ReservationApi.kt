package tn.mbach.Blasti.Network;

import com.google.gson.JsonObject;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Response
import retrofit2.http.Body;
import retrofit2.http.GET
import retrofit2.http.POST;
import tn.mbach.Blasti.Models.Reservation
import tn.mbach.Blasti.Models.User
import tn.mbach.Blasti.Models.moviesss

interface ReservationApi {


    @GET("api/reservation/all")
    fun  ShowReservationsbyUser(): Call<List<Reservation>>

    @POST("api/reservation/addM")
    fun AddReservationM(@Body map : HashMap<String, String>): Call<JsonObject>

    @POST("api/reservation/addE")
    fun AddReservationE(@Body map : HashMap<String, String>): Call<JsonObject>

    @POST("api/reservation/addS")
    fun AddReservationS(@Body map : HashMap<String, String>): Call<JsonObject>


}
