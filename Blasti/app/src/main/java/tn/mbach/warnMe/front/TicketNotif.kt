package tn.mbach.warnMe.front

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import tn.mbach.warnMe.R

class TicketNotif : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_ticket_notif)
    }
}