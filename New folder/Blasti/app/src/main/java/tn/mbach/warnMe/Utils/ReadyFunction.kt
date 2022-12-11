package tn.mbach.warnMe.Utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.text.TextUtils
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.view.animation.AlphaAnimation
import android.view.inputmethod.InputMethodManager
import tn.mbach.warnMe.front.Home
import tn.mbach.warnMe.Login


class ReadyFunction {

    fun isOnline(context:Context): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val netInfo = cm.activeNetworkInfo
        return netInfo != null && netInfo.isConnectedOrConnecting
    }

     fun setFadeAnimation(view: View) {
        val FADE_DURATION = 1000 //FADE_DURATION in milliseconds
        val anim = AlphaAnimation(0.0f, 1.0f)
        anim.duration = FADE_DURATION.toLong()
        view.startAnimation(anim)
    }

     fun hideKeyboard(view: View,context:Context) {
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken,0)
    }

    fun String.isEmailValid(): Boolean {
        return !TextUtils.isEmpty(this) && android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches()
    }

    fun showView(view : View) {
        view.visibility = View.VISIBLE
    }
     fun hideView(view : View) {
        view.visibility = View.GONE
    }

    fun GoToActivityHome(context: Context,Activity : Activity) {
        val intent = Intent(context, Home::class.java)
        context.startActivity(intent)
        Activity.finish()
    }
    fun GoToActivityLogin(context: Context,Activity : Activity) {
        val intent = Intent(context, Login::class.java)
        context.startActivity(intent)
        Activity.finish()
    }
    fun BlockTouch(Activity : Activity)
    {
        val window: Window = Activity.getWindow()
        window.setFlags(
            WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL,
            WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
        )
    }
    fun ActiveTouch(Activity : Activity)
    {
        val window: Window = Activity.getWindow()
        window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
    }

}