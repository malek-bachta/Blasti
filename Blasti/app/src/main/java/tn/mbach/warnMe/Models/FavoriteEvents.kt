package tn.mbach.warnMe.Models

import android.content.ContentValues
import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.preference.PreferenceManager
import kotlinx.coroutines.*
import retrofit2.Retrofit
import tn.mbach.warnMe.Data.ID
import tn.mbach.warnMe.Data.PREF_NAME
import tn.mbach.warnMe.Network.EventsApi
import tn.mbach.warnMe.Network.retrofit
import tn.mbach.warnMe.Utils.ReadyFunction

class FavoriteEvents : ViewModel()  {
    val retrofi: Retrofit = retrofit.getInstance()
    val service: EventsApi = retrofi.create(EventsApi::class.java)
    //
    val ReadyFunction = ReadyFunction()
    //
    var errorMessage = MutableLiveData<String>()
    var UserLiveData: MutableLiveData<Events> = MutableLiveData()
    val _UserLiveData : LiveData<Events> = UserLiveData
    //
    private val statusMessage = MutableLiveData<String>()
    private lateinit var MySharedPref: SharedPreferences
//    private lateinit var sessionManager: SessionManager
    //

    suspend fun VerifFavoriteCoroutineScope(context: Context) : String {
        var MySharedPref: SharedPreferences
        MySharedPref =
            context.getSharedPreferences(PREF_NAME, AppCompatActivity.MODE_PRIVATE);
        val idUser = MySharedPref.getString(ID, null)
        //
        val sharedPreference = PreferenceManager.getDefaultSharedPreferences(context)
        val idPost = sharedPreference.getString("eventsid", null)
        val retrofi: Retrofit = retrofit.getInstance()
        val service: EventsApi = retrofi.create(EventsApi::class.java)
        //
        val map: HashMap<String, String> = HashMap()
        map["idEvent"] = idPost.toString()
        map["idUser"] = idUser.toString()
        var value = ""
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = service.VerifFavorite(map)
                val deferred = GlobalScope.async(Dispatchers.Default) {
                    // events.teamResults[0].strEvent
                    response.body()!!.message
                }
                value = deferred.await()
                println("value value value value value value =====> "+value)
                if(response.body()!!.message=="Exist!")
                {
                    println("IF Exist ViewModel =====> "+response.body()?.message)
                    val sharedPreference = PreferenceManager.getDefaultSharedPreferences(context)
                    val editor = sharedPreference.edit()
                    editor.putBoolean("VerifFavorite",true)
                    editor.commit()  //Save Data
                }
                if(response.body()!!.message=="Not Exist!")
                {
                    println("IF NOT Exist ViewModel =====> "+response.body()?.message)
                    val sharedPreference = PreferenceManager.getDefaultSharedPreferences(context)
                    val editor = sharedPreference.edit()
                    editor.putBoolean("VerifFavorite",false)
                    editor.commit()  //Save Data
                }
            } catch (exception: Exception) {
                withContext(Dispatchers.Main) {
                    Log.d(ContentValues.TAG, "Dispatcher: " + exception.message)
                }
            }
        }
        return value
    }

}