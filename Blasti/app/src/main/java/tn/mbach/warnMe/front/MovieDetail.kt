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
        val txtGenre = findViewById<TextView>(R.id.textdetailGenre)
        val txtProduction = findViewById<TextView>(R.id.textdetailProduction)
        val txtLanguage = findViewById<TextView>(R.id.textdetailLanguage)
        val txtDuration = findViewById<TextView>(R.id.textdetailDuration)
//        val txtRating = findViewById<TextView>(R.id.textdetailRating)

        val sharedPreference = PreferenceManager.getDefaultSharedPreferences(this)
        //
        val moviesDescription = sharedPreference.getString("moviesDescription", null)
        val moviesTitle = sharedPreference.getString("moviesTitle", null)
        val moviesDate = sharedPreference.getString("moviesDate", null)
        val moviesGenre = sharedPreference.getString("moviesGenre", null)
        val moviesProduction = sharedPreference.getString("moviesProduction", null)
        val moviesLanguage = sharedPreference.getString("moviesLanguage", null)
        val moviesDuration = sharedPreference.getString("moviesDuration", null)

        txtTitle.text=moviesTitle
        txtDescription.text=moviesDescription
        txtDate.text=moviesDate
        txtGenre.text=moviesGenre
        txtProduction.text=moviesProduction
        txtLanguage.text=moviesLanguage
        txtDuration.text=moviesDuration

    }
}