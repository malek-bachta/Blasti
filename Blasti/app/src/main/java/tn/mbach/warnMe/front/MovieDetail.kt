package tn.mbach.warnMe.front

import android.content.Context
import android.content.SharedPreferences
import android.graphics.Bitmap
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.preference.PreferenceManager
import com.google.gson.JsonObject
import com.google.zxing.BarcodeFormat
import com.google.zxing.WriterException
import com.google.zxing.qrcode.QRCodeWriter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import tn.mbach.warnMe.Data.ID
import tn.mbach.warnMe.Data.PREF_NAME
import tn.mbach.warnMe.Network.MoviesApi
import tn.mbach.warnMe.Network.retrofit
import tn.mbach.warnMe.R
import tn.mbach.warnMe.Utils.CustomToast


class MovieDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.movie_detail)

        val txtTitle = findViewById<TextView>(R.id.textDetailTtitle)
        val txtDescription = findViewById<TextView>(R.id.textdetailDescription)
        val txtDate = findViewById<TextView>(R.id.textdetailDate)
        val txtGenre = findViewById<TextView>(R.id.textdetailGenre)
        val txtProduction = findViewById<TextView>(R.id.textdetailProduction)
        val txtLanguage = findViewById<TextView>(R.id.textdetailLanguage)
        val txtDuration = findViewById<TextView>(R.id.textdetailDuration)
//        val txtRating = findViewById<TextView>(R.id.textdetailRating)

        val QRCode = findViewById<ImageView>(R.id.QRCode)
        val resever = findViewById<Button>(R.id.reserver)

        //////////////////
        val favoriteMovie = findViewById<Button>(R.id.favouriteM)

        val sharedPreference = PreferenceManager.getDefaultSharedPreferences(this)
        //
        val moviesDescription = sharedPreference.getString("moviesDescription", null)
        val moviesTitle = sharedPreference.getString("moviesTitle", null)
        val moviesDate = sharedPreference.getString("moviesDate", null)
        val moviesGenre = sharedPreference.getString("moviesGenre", null)
        val moviesProduction = sharedPreference.getString("moviesProduction", null)
        val moviesLanguage = sharedPreference.getString("moviesLanguage", null)
        val moviesDuration = sharedPreference.getString("moviesDuration", null)

        txtTitle.text=moviesTitle
        txtDescription.text=moviesDescription
        txtDate.text=moviesDate
        txtGenre.text=moviesGenre
        txtProduction.text=moviesProduction
        txtLanguage.text=moviesLanguage
        txtDuration.text=moviesDuration


        ///////////////////////////////////////////

        val settings = PreferenceManager.getDefaultSharedPreferences(this)
        val VerifFavorite = settings.getBoolean("VerifFavorite", false)
        println("Favorite From SharedPref ============>>>>>>>>>> "+VerifFavorite)

        // println("Favorite From SharedPref ============>>>>>>>>>> "+VerifFavorite)

        if (VerifFavorite == true) {
            favoriteMovie!!.setBackgroundResource(R.drawable.likefill)
        } else {
            favoriteMovie!!.setBackgroundResource(R.drawable.like)
        }


///////////////////////////////
        favoriteMovie.setOnClickListener {
            if(VerifFavorite == true){
                DeleteFavoriteFromDB(this)
                favoriteMovie!!.setBackgroundResource(R.drawable.like)
            }else{
                AddFavoriteToDB(this)
                favoriteMovie!!.setBackgroundResource(R.drawable.likefill)
            }
        }



        resever.setOnClickListener{
            val data = txtTitle.text.toString().trim()


            val writer = QRCodeWriter()
            try {
                val bitMatrix = writer.encode(data, BarcodeFormat.QR_CODE,720,720)
                val width = bitMatrix.width
                val height = bitMatrix.height
                val bmp = Bitmap.createBitmap(width,height, Bitmap.Config.RGB_565)
                for (x in 0 until width){
                    for (y in 0 until height){
                        bmp.setPixel(x, y, if (bitMatrix[x,y]) Color.BLACK else Color.WHITE)
                    }
                }
                QRCode.setImageBitmap(bmp)

            }catch (e: WriterException){
                e.printStackTrace()
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
        val idPost = sharedPreference.getString("moviesid", null)
        //
        val retrofi: Retrofit = retrofit.getInstance()
        val service: MoviesApi = retrofi.create(MoviesApi::class.java)

        val map: HashMap<String, String> = HashMap()
        map["idMovie"] = idPost.toString()
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
        val idPost = sharedPreference.getString("moviesid", null)
        //
        val retrofi: Retrofit = retrofit.getInstance()
        val service: MoviesApi = retrofi.create(MoviesApi::class.java)

        val map: HashMap<String, String> = HashMap()
        map["idMovie"] = idPost.toString()
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