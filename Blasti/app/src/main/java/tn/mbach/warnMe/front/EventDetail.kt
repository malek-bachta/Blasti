package tn.mbach.warnMe.front

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.preference.PreferenceManager
import tn.mbach.warnMe.R

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
    }
}