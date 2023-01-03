package tn.mbach.warnMe.Network;

import com.google.gson.JsonObject;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Response
import retrofit2.http.Body;
import retrofit2.http.GET
import retrofit2.http.POST;
import tn.mbach.warnMe.Models.Reservation
import tn.mbach.warnMe.Models.User
import tn.mbach.warnMe.Models.moviesss

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
