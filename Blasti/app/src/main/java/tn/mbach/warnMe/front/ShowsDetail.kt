package tn.mbach.warnMe.front

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.preference.PreferenceManager
import tn.mbach.warnMe.R


class ShowsDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.shows_detail)

        val txtTitle = findViewById<TextView>(R.id.ShowDetailTtitle)
        val txtDescription = findViewById<TextView>(R.id.ShowDetailDescription)
        val txtDate = findViewById<TextView>(R.id.ShowDetailDate)

        val sharedPreference = PreferenceManager.getDefaultSharedPreferences(this)
        //
        val showsDescription = sharedPreference.getString("showsDescription", null)
        val showsTitle = sharedPreference.getString("showsTitle", null)
        val showsDate = sharedPreference.getString("showsDate", null)

        txtTitle.text=showsTitle
        txtDescription.text=showsDescription
        txtDate.text=showsDate
    }
}