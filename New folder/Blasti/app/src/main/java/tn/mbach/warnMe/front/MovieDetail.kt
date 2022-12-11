package tn.mbach.warnMe.front

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.preference.PreferenceManager
import tn.mbach.warnMe.R

class MovieDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.movie_detail)

        val txtTitle = findViewById<TextView>(R.id.textDetailTtitle)
        val txtDescription = findViewById<TextView>(R.id.textdetailDescription)
        val txtDate = findViewById<TextView>(R.id.textdetailDate)

        val sharedPreference = PreferenceManager.getDefaultSharedPreferences(this)
        //
        val moviesDescription = sharedPreference.getString("moviesDescription", null)
        val moviesTitle = sharedPreference.getString("moviesTitle", null)
        val moviesDate = sharedPreference.getString("moviesDate", null)

        txtTitle.text=moviesTitle
        txtDescription.text=moviesDescription
        txtDate.text=moviesDate

    }
}