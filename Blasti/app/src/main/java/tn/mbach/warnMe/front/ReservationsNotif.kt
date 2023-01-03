package tn.mbach.Blasti.front

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import tn.mbach.Blasti.R

class ReservationsNotif : AppCompatActivity() {

    private lateinit var buttonback: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_reservations_notif)


//        Goback();

    }
    /*fun initView() {
        buttonback = findViewById(R.id.buttonback)
    }

    fun Goback() {
        buttonback.setOnClickListener {
            val intent = Intent(this, ProfileFragment::class.java).apply {}
            startActivity(intent)
        }

    }*/

}