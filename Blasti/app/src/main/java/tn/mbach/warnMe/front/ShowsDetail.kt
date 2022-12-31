package tn.mbach.warnMe.front

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.preference.PreferenceManager
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import tn.mbach.warnMe.Data.ID
import tn.mbach.warnMe.Data.PREF_NAME
import tn.mbach.warnMe.Network.ShowsApi
import tn.mbach.warnMe.Network.retrofit
import tn.mbach.warnMe.R
import tn.mbach.warnMe.Utils.CustomToast


class ShowsDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.shows_detail)

        val txtTitle = findViewById<TextView>(R.id.ShowDetailTtitle)
        val txtDescription = findViewById<TextView>(R.id.ShowDetailDescription)
        val txtDate = findViewById<TextView>(R.id.ShowDetailDate)
        val txtGenre = findViewById<TextView>(R.id.ShowDetailGenre)
        val txtActors = findViewById<TextView>(R.id.ShowDetailActors)
        val txtPlaces = findViewById<TextView>(R.id.ShowDetailPlaces)

        val favoriteShow = findViewById<Button>(R.id.favouriteS)


        val sharedPreference = PreferenceManager.getDefaultSharedPreferences(this)
        //
        val showsDescription = sharedPreference.getString("showsDescription", null)
        val showsTitle = sharedPreference.getString("showsTitle", null)
        val showsDate = sharedPreference.getString("showsDate", null)
        val showsGenre = sharedPreference.getString("showsGenre", null)
        val showsActors = sharedPreference.getString("showsActors", null)
        val showsPlaces = sharedPreference.getString("showsPlaces", null)

        txtTitle.text=showsTitle
        txtDescription.text=showsDescription
        txtDate.text=showsDate
        txtGenre.text=showsGenre
        txtPlaces.text=showsPlaces
        txtActors.text=showsActors


        ///////////////////////////////////////////

        val settings = PreferenceManager.getDefaultSharedPreferences(this)
        val VerifFavorite = settings.getBoolean("VerifFavorite", false)
        println("Favorite From SharedPref ============>>>>>>>>>> "+VerifFavorite)

        // println("Favorite From SharedPref ============>>>>>>>>>> "+VerifFavorite)

        if (VerifFavorite == true) {
            favoriteShow!!.setBackgroundResource(R.drawable.likefill)
        } else {
            favoriteShow!!.setBackgroundResource(R.drawable.like)
        }


///////////////////////////////
        favoriteShow.setOnClickListener {
            if(VerifFavorite == true){
                DeleteFavoriteFromDB(this)
                favoriteShow!!.setBackgroundResource(R.drawable.like)
            }else{
                AddFavoriteToDB(this)
                favoriteShow!!.setBackgroundResource(R.drawable.likefill)
            }
        }

    }


    fun AddFavoriteToDB(context: Context) {
        var MySharedPref: SharedPreferences
        MySharedPref =
            context.getSharedPreferences(PREF_NAME, AppCompatActivity.MODE_PRIVATE);
        val idUser = MySharedPref.getString(ID, null)
        //
        val sharedPreference = PreferenceManager.getDefaultSharedPreferences(context)
        val idPost = sharedPreference.getString("showsid", null)
        //
        val retrofi: Retrofit = retrofit.getInstance()
        val service: ShowsApi = retrofi.create(ShowsApi::class.java)

        val map: HashMap<String, String> = HashMap()
        map["idShow"] = idPost.toString()
        map["idUser"] = idUser.toString()
        /////////////////////////////////////////////////////////////////////////////////////////////////////
        service.AddFavorite(map).enqueue(object : Callback<JsonObject> {
            override fun onResponse(
                call: Call<JsonObject>,
                response: Response<JsonObject>
            ) {
                if (response.code() == 200) {
                    CustomToast(context, "Favorite Added!", "GREEN").show()
                    //
                } else {
                    Log.e("RETROFIT_ERROR", response.code().toString())
                    println("Message :" + response.errorBody()?.string())
                    CustomToast(context, "Sorry, Something Goes Wrong!", "RED").show()
                }
            }

            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                Log.e("Error", t.message.toString())
                CustomToast(context, "Sorry, Something Goes Wrong!", "RED").show()
            }
        })
    }

    ///////////////////////////////////////////////////////////////////////////////////
    fun DeleteFavoriteFromDB(context: Context) {
        var MySharedPref: SharedPreferences
        MySharedPref =
            context.getSharedPreferences(PREF_NAME, AppCompatActivity.MODE_PRIVATE);
        val idUser = MySharedPref.getString(ID, null)
        //
        val sharedPreference = PreferenceManager.getDefaultSharedPreferences(context)
        val idPost = sharedPreference.getString("showsid", null)
        //
        val retrofi: Retrofit = retrofit.getInstance()
        val service: ShowsApi = retrofi.create(ShowsApi::class.java)

        val map: HashMap<String, String> = HashMap()
        map["idShow"] = idPost.toString()
        map["idUser"] = idUser.toString()
        /////////////////////////////////////////////////////////////////////////////////////////////////////
        service.FavoriteDelete(map).enqueue(object : Callback<JsonObject> {
            override fun onResponse(
                call: Call<JsonObject>,
                response: Response<JsonObject>
            ) {
                if (response.code() == 200) {
                    CustomToast(context, "Favorite Deleted!", "GREEN").show()
                } else {
                    Log.e("RETROFIT_ERROR", response.code().toString())
                    println("Message :" + response.errorBody()?.string())
                    CustomToast(context, "Sorry, Something Goes Wrong!", "RED").show()
                }
            }
            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                Log.e("Error", t.message.toString())
                CustomToast(context, "Sorry, Something Goes Wrong!", "RED").show()
            }
        })
    }


}