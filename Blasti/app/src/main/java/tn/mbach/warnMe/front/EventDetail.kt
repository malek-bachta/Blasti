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
import tn.mbach.warnMe.Network.EventsApi
import tn.mbach.warnMe.Network.retrofit
import tn.mbach.warnMe.R
import tn.mbach.warnMe.Utils.CustomToast

class EventDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.event_detail)

        val txtTitle = findViewById<TextView>(R.id.EventDetailTtitle)
        val txtDate = findViewById<TextView>(R.id.EventDetailDate)
        val txtDescription = findViewById<TextView>(R.id.EventDetailDescription)
        val txtGenre = findViewById<TextView>(R.id.EventDetailGenre)
        val txtGuest = findViewById<TextView>(R.id.EventDetailGuest)
        val txtCost = findViewById<TextView>(R.id.EventDetailCost)
        val txtPlacesD = findViewById<TextView>(R.id.EventDetailPlacesD)
        val txtAdress = findViewById<TextView>(R.id.EventDetailAdress)

        val favoriteEvent = findViewById<Button>(R.id.favouriteE)
        val QRCode = findViewById<ImageView>(R.id.QRCode)
        val resever = findViewById<Button>(R.id.ReserveButton)


        val sharedPreference = PreferenceManager.getDefaultSharedPreferences(this)
        //
        val eventsTitle = sharedPreference.getString("eventsTitle", null)
        val eventsDescription = sharedPreference.getString("eventsDescription", null)
        val eventsDate = sharedPreference.getString("eventsDate", null)
        val eventsGenre = sharedPreference.getString("eventsGenre", null)
        val eventsGuest = sharedPreference.getString("eventsGuest", null)
        val eventsCost = sharedPreference.getString("eventsCost", null)
        val eventsPlacesD = sharedPreference.getString("eventsPlacesD", null)
        val eventsAdress = sharedPreference.getString("eventsAdress", null)

        txtTitle.text=eventsTitle
        txtDescription.text=eventsDescription
        txtDate.text=eventsDate
        txtGenre.text=eventsGenre
        txtGuest.text=eventsGuest
        txtCost.text=eventsCost
        txtPlacesD.text=eventsPlacesD
        txtAdress.text=eventsAdress

        ///////////////////////////////////////////

        val settings = PreferenceManager.getDefaultSharedPreferences(this)
        val VerifFavorite = settings.getBoolean("VerifFavorite", false)
        println("Favorite From SharedPref ============>>>>>>>>>> "+VerifFavorite)

        // println("Favorite From SharedPref ============>>>>>>>>>> "+VerifFavorite)

        if (VerifFavorite == true) {
            favoriteEvent!!.setBackgroundResource(R.drawable.likefill)
        } else {
            favoriteEvent!!.setBackgroundResource(R.drawable.like)
        }


///////////////////////////////
        favoriteEvent.setOnClickListener {
            if(VerifFavorite == true){
                DeleteFavoriteFromDB(this)
                favoriteEvent!!.setBackgroundResource(R.drawable.like)
            }else{
                AddFavoriteToDB(this)
                favoriteEvent!!.setBackgroundResource(R.drawable.likefill)
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
        val idPost = sharedPreference.getString("eventsid", null)
        //
        val retrofi: Retrofit = retrofit.getInstance()
        val service: EventsApi = retrofi.create(EventsApi::class.java)

        val map: HashMap<String, String> = HashMap()
        map["idEvent"] = idPost.toString()
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
        val idPost = sharedPreference.getString("eventsid", null)
        //
        val retrofi: Retrofit = retrofit.getInstance()
        val service: EventsApi = retrofi.create(EventsApi::class.java)

        val map: HashMap<String, String> = HashMap()
        map["idEvent"] = idPost.toString()
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