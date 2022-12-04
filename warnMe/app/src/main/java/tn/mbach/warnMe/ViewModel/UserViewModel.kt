package tn.mbach.warnMe.ViewModel


import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.util.Log
import android.view.View
import android.widget.CheckBox
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.material.textfield.TextInputEditText
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import tn.mbach.warnMe.Data.*
import tn.mbach.warnMe.Models.User
import tn.mbach.warnMe.Network.UserApi
import tn.mbach.warnMe.Network.retrofit
import tn.mbach.warnMe.Utils.CustomToast
import tn.mbach.warnMe.Utils.ReadyFunction
import tn.mbach.warnMe.back.HomeAdmin


class UserViewModel : ViewModel() {
    val retrofi: Retrofit = retrofit.getInstance()
    val service: UserApi = retrofi.create(UserApi::class.java)

    //
    val ReadyFunction = ReadyFunction()

    //
    private var usersList: MutableLiveData<List<User>>? = null

    //
    private val statusMessage = MutableLiveData<String>()
    private lateinit var MySharedPref: SharedPreferences

    //
    fun getUsers(): MutableLiveData<List<User>>? {
        if (usersList == null) {
            usersList = MutableLiveData<List<User>>()
            //loadUsers()
        }
        return usersList
    }

    // Login Méthode 1
    fun login1(
        loginemail: TextInputEditText,
        loginpassw: TextInputEditText,
        context: Context,
        view: View,
        Activity: Activity,
        cbRememberMe: CheckBox
    ) {
        //Block Touch To prevent user click to many on btn login (Too much Request of Login)
        ReadyFunction.BlockTouch(Activity)
        //
        val paramObject1 = JSONObject()
        paramObject1.put("email", loginemail.text.toString().trim())
        paramObject1.put("password", loginpassw.text.toString().trim())
        val jsonParser = JsonParser()
        var gsonObject1 = jsonParser.parse(paramObject1.toString()) as JsonObject
        /////////////////////////////////////////////////////////////////////////////////////////////////////
        service.login1(gsonObject1).enqueue(object : Callback<JsonObject> {
            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                if (response.code() == 200) {
                    val users = mutableListOf<User>()
                    var DataBody = response.body()?.toString()
                    if (DataBody != null && !DataBody.isEmpty()) {
                        var json = JsonParser()
                        var UserData = json.parse(DataBody).asJsonObject
                        //  for (UserData in jsonArray) { //Parcourir Array []
                        val id = UserData.asJsonObject.get("id").asString
                        val userName = UserData.asJsonObject.get("name").asString
                        val userEmail = UserData.asJsonObject.get("email").asString
                        val userBio = UserData.asJsonObject.get("bio").asString
                        val userAvatar = UserData.asJsonObject.get("avatar").asString
                        val token = UserData.asJsonObject.get("token").asString
                        val role = UserData.asJsonObject.get("role").asString


                        MySharedPref = context.getSharedPreferences(
                            PREF_NAME,
                            AppCompatActivity.MODE_PRIVATE
                        );
                        MySharedPref.edit().apply {
                            putString(ID, id)
                            putString(NAME, userName)
                            putString(EMAIL, userEmail)
                            putString(BIO, userBio)
                            putString(AVATAR, userAvatar)
                            putString(TOKEN, token)
                            if (cbRememberMe.isChecked) {
                                putString(RememberEmail, loginemail.text.toString().trim())
                                putString(RememberPassword, loginpassw.text.toString().trim())
                            }
                        }.apply()

                        if (role == "admin") {
                            val intent = Intent(context, HomeAdmin::class.java)
                            context.startActivity(intent)
                            Activity.finish()
                        } else {


                            // }
                            CustomToast(context, "Login Successful!", "GREEN").show()
                            //sessionManager.saveAuthToken(response.body()?.getToken().toString())
                        ReadyFunction.GoToActivityHome(context,Activity) //GoTo Page Home
                            statusMessage.value = "Sign in successful"
                            //Enable touch Again
                            ReadyFunction.ActiveTouch(Activity)
                            //
                        }
                    }
                } else {
                    ReadyFunction().hideView(view) //Hide ProgressBar
                    Log.e("RETROFIT_ERROR", response.code().toString())
                    println("Message :" + response.errorBody()?.string())
                    CustomToast(context, "Email or password is incorrect!", "RED").show()
                    statusMessage.value = "please enter all fields"
                    //Enable touch Again
                    ReadyFunction.ActiveTouch(Activity)
                    //
                }
            }

            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                ReadyFunction().hideView(view) //Hide ProgressBar
                Log.e("Error", t.message.toString())
                CustomToast(context, "Sorry, Something Goes Wrong!", "RED").show()
                ReadyFunction.hideView(view)
                //Enable touch Again
                ReadyFunction.ActiveTouch(Activity)
                //
            }
        })
    }

    fun Register(
        txtname: TextInputEditText,
        txtemail: TextInputEditText,
        txtpass: TextInputEditText,
        context: Context,
        Activity: Activity
    ) {
        val map: HashMap<String, String> = HashMap()
        map["username"] = txtname.text.toString()
        map["email"] = txtemail.text.toString()
        map["password"] = txtpass.text.toString()
        service.signup(map).enqueue(object : Callback<JsonObject> {
            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                //
                val Body = response.body().toString()
                var json = JsonParser()
                var Data = json.parse(Body).asJsonObject
                val message = Data!!.asJsonObject.get("message").asString
                //
                if (message == "SignUp Done!") {
                    CustomToast(context, "Success! you've joined warnMe", "GREEN").show()
                    ReadyFunction.GoToActivityLogin(context, Activity) //GoTo Page Home
                } else {
                    CustomToast(context, "This Email Already Exist!", "RED").show()
                }
            }

            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                CustomToast(context, "Sorry, Something Goes Wrong!", "RED").show()
            }
        })
    }


    // Login Méthode 2 Ne9sa Go To Home
    /*
    @SuppressLint("RestrictedApi")
    fun login2(loginemail: TextView,loginpassw:TextView) {
        val User = Loginresponse()
        User.setEmail(loginemail.text.toString())
        User.setPassword(loginpassw.text.toString())
        //
        CoroutineScope(Dispatchers.IO).launch {
            // Do the POST request and get response
            try {
                val response = service.login2(User)
                withContext(Dispatchers.Main) {
                    if (response.isSuccessful) {
                        println("Token =============>>>>>>>>>  " + response.body()?.getToken())
                        println("ID =============>>>>>>>>>  " + response.body()?.getID())
                        println("Name =============>>>>>>>>>  " + response.body()?.getName())
                        statusMessage.value = "Sign in successful"
                    } else {
                       // hideProgressBar() //Hide ProgressBar
                        Log.e("RETROFIT_ERROR", response.code().toString())
                        println("Message :" + response.errorBody()?.string())
                       // CustomToast(this@Login, "Email or password is incorrect!","RED").show()
                        statusMessage.value = "please enter all fields"
                    }
                }
            } catch (e: Exception)
            {
                println(e.printStackTrace())
                println("Error")
            }
        }
    }
*/


}