package tn.mbach.Blasti

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)

        Handler().postDelayed({
            val intent = Intent(this, AutoLogin::class.java)
            startActivity(intent)
            finish()
        }, 3000) // 3000 ms = 3 Seconde
    }
}