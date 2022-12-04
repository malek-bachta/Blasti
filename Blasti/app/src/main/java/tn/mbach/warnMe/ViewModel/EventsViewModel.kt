package tn.mbach.warnMe.ViewModel

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.material.textfield.TextInputEditText
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import tn.mbach.warnMe.Models.Events
import tn.mbach.warnMe.Network.EventsApi
import tn.mbach.warnMe.Network.retrofit
import tn.mbach.warnMe.Utils.CustomToast
import tn.mbach.warnMe.Utils.ReadyFunction

class EventsViewModel : ViewModel() {
    val retrofi: Retrofit = retrofit.getInstance()
    val service: EventsApi = retrofi.create(EventsApi::class.java)


    val ReadyFunction = ReadyFunction()


    private var eventsList: MutableLiveData<List<Events>>? = null

    private val statusMessage = MutableLiveData<String>()
    private lateinit var MySharedPref: SharedPreferences

   /* fun GetAllEvents(): MutableLiveData<List<Events>>? {
        if (eventsList == null) {
            eventsList = MutableLiveData<List<Events>>()
            println("add something first")
        }
        return eventsList
    }*/

    fun addEvent(
        txttitle: TextInputEditText,
        txtgenre: TextInputEditText,
        txtdescription: TextInputEditText,
//        txtdate: TextInputEditText,
        context: Context,
        Activity: Activity
    ) {
        val map: HashMap<String, String> = HashMap()
        map["title"] = txttitle.text.toString()
        map["adress"] = txtgenre.text.toString()
        map["type"] = txtdescription.text.toString()
//        map["date"] = txtdate.text.toString()
        service.addEvent(map).enqueue(object : Callback<java.util.HashMap<String, String>> {
            override fun onResponse(call: Call<java.util.HashMap<String, String>>, response: Response<java.util.HashMap<String, String>>) {
                //
                println(response)
                println(response.body()!!.get("message"))
                println(response.message())
   /*             val Body = response.body().toString()
                var json = JsonParser()
                var Data = json.parse(Body).asJsonObject
                val message = Data!!.asJsonObject.get("message")!!.asString
                print("waaaaaaaaaa"+message)
                //
                if (message == "Movie added successfully!") {
                    CustomToast(context, "Success! added a movie", "GREEN").show()
                    ReadyFunction.GoToActivityHome(context, Activity) //GoTo Page Home
                } else {
                    CustomToast(context, "This Movie Already Exist!", "RED").show()
                }*/
            }

            override fun onFailure(call: Call<java.util.HashMap<String, String>>, t: Throwable) {
                CustomToast(context, "Sorry, Something Goes Wrong!", "RED").show()
            }
        })
    }
}