package tn.mbach.Blasti

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.internal.ContextUtils
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import tn.mbach.Blasti.Data.*
import tn.mbach.Blasti.Network.Loginresponse
import tn.mbach.Blasti.Network.UserApi
import tn.mbach.Blasti.Network.retrofit
import tn.mbach.Blasti.Utils.CustomToast
import tn.mbach.Blasti.back.HomeAdmin
import tn.mbach.Blasti.front.Home

class AutoLogin : AppCompatActivity() {
    //
    private lateinit var MySharedPref: SharedPreferences
    private lateinit var llProgressBar: ProgressBar
    private lateinit var NameAutoLogin: TextView

    //
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.auto_login)

        llProgressBar = findViewById(R.id.progressBar)
        NameAutoLogin = findViewById(R.id.NameAutoLogin)
        MySharedPref = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        val RememberEmail = MySharedPref.getString(RememberEmail, null)
        val RememberPassword = MySharedPref.getString(RememberPassword, null)
        val nameUser = MySharedPref.getString(NAME, null)
        //
        llProgressBar.visibility = View.VISIBLE
        NameAutoLogin.text = nameUser
        //
        if ((RememberEmail != null && RememberPassword != null) && (RememberEmail.isNotEmpty() && RememberPassword.isNotEmpty())) {
            ServiceLogin(RememberEmail, RememberPassword)
            //GoToHome(this@AutoLogin)
        } else {
            GoToLogin(this@AutoLogin)
            llProgressBar.visibility = View.GONE
        }
    }

    @SuppressLint("RestrictedApi")
    fun ServiceLogin(email: String, password: String) {
        // sessionManager = SessionManager(this)
        // Create Retrofit
        val retrofi: Retrofit = retrofit.getInstance()
        val service: UserApi = retrofi.create(UserApi::class.java)
        val User = Loginresponse()
        User.setEmail(email)
        User.setPassword(password)
        CoroutineScope(Dispatchers.IO).launch {
            // Do the POST request and get response
            try {
                val response = service.login2(User)
                withContext(Dispatchers.Main) {
                    if (response.isSuccessful) {
                        println("Token =============>>>>>>>>>  " + response.body()?.getToken())
                        println("ID =============>>>>>>>>>  " + response.body()?.getID())
                        println("Name =============>>>>>>>>>  " + response.body()?.getName())
                        MySharedPref.edit().apply {
                            putString(ID, response.body()?.getID())
                            putString(NAME, response.body()?.getName())
                            putString(EMAIL, response.body()?.getEmail())
                            putString(BIO, response.body()?.getBio())
                            putString(AVATAR, response.body()?.getAvatar())
                            putString(TOKEN, response.body()?.getToken())
                            putString(ROLE, response.body()?.getRole())
                        }.apply()

                        val role = response.body()?.getRole()
                        if (role == "admin") {
                            //Sleep lehna chnjem ProgressBar tchef l'animation t3ha
                            Handler().postDelayed({
                                CustomToast(this@AutoLogin, "Login Successful!", "GREEN").show()
                                GoToHomeAdmin(this@AutoLogin) //GoTo Page Home
                            }, 2000) // 3000 ms = 3 Seconde

                        } else {

                            //Sleep lehna chnjem ProgressBar tchef l'animation t3ha
                            Handler().postDelayed({
                                CustomToast(this@AutoLogin, "Login Successful!", "GREEN").show()
                                GoToHome(this@AutoLogin) //GoTo Page Home
                            }, 2000) // 3000 ms = 3 Seconde
                        }
                    } else {
                        Log.e("RETROFIT_ERROR", response.code().toString())
                        println("Message :" + response.errorBody()?.string())
                        //
                        MySharedPref.edit().apply {
                            putString(RememberEmail, "")
                            putString(RememberPassword, "")
                        }.apply()
                        //
                        CustomToast(this@AutoLogin, "Email or password is incorrect!", "RED").show()
                        GoToLogin(this@AutoLogin)
                    }
                }
            } catch (e: Exception) {
                println(e.printStackTrace())
                println("Error")
                ContextUtils.getActivity(this@AutoLogin)?.runOnUiThread(java.lang.Runnable {
                    CustomToast(this@AutoLogin, "Sorry, Something Goes Wrong!", "RED").show()
                    GoToLogin(this@AutoLogin)
                })
            }
        }
    }

    fun GoToHome(context: Context) {
        val intent = Intent(context, Home::class.java)
        context.startActivity(intent)
        finish()
    }

    fun GoToHomeAdmin(context: Context) {
        val intent = Intent(context, HomeAdmin::class.java)
        context.startActivity(intent)
        finish()
    }

    fun GoToLogin(context: Context) {
        val intent = Intent(context, Login::class.java)
        context.startActivity(intent)
        finish()
    }
}