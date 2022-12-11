package tn.mbach.warnMe.front

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.preference.PreferenceManager
import tn.mbach.warnMe.R

class EventDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_detail)

        val txtTitle = findViewById<TextView>(R.id.EventDetailTtitle)
        val txtDescription = findViewById<TextView>(R.id.EventDetailDescription)
        val txtDate = findViewById<TextView>(R.id.EventDetailDate)

        val sharedPreference = PreferenceManager.getDefaultSharedPreferences(this)
        //
        val eventsDescription = sharedPreference.getString("eventsDescription", null)
        val eventsTitle = sharedPreference.getString("eventsTitle", null)
        val eventsDate = sharedPreference.getString("eventsDate", null)

        txtTitle.text=eventsTitle
        txtDescription.text=eventsDescription
        txtDate.text=eventsDate
    }
}