package tn.mbach.Blasti.back

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.replace
import com.google.android.material.navigation.NavigationView
import tn.mbach.Blasti.Data.PREF_NAME
import tn.mbach.Blasti.Data.RememberEmail
import tn.mbach.Blasti.Data.RememberPassword
import tn.mbach.Blasti.Login
import tn.mbach.Blasti.R
import tn.mbach.Blasti.front.Home

class HomeAdmin : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle
    lateinit var drawerLayout: DrawerLayout
    lateinit var navView: NavigationView

    private lateinit var MySharedPref: SharedPreferences






    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_admin)


        drawerLayout=findViewById(R.id.drawerLayout)
        navView=findViewById(R.id.navView)

        toggle = ActionBarDrawerToggle(this@HomeAdmin, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {

            it.isChecked = true

            when(it.itemId){
                R.id.NavHome -> replaceFragment(HomeAdminFragment())
                R.id.NavMovies -> replaceFragment(MoviesManagmentFragment())
                R.id.NavEvents -> replaceFragment(EventsManagmentFragment())
                R.id.NavShows -> replaceFragment(ShowsManagmentFragment())
                R.id.logout->logout()
                R.id.gotofront ->gotohome()

            }
            true
        }

        MySharedPref = getSharedPreferences(PREF_NAME, MODE_PRIVATE);






    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.adminframe,fragment)
        fragmentTransaction.commit()
        drawerLayout.closeDrawers()
    }

     fun onOptionItemSelected(item: MenuItem):Boolean{
        if (toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun logout(){
            MySharedPref.edit().apply {
                putString(RememberEmail, "")
                putString(RememberPassword, "")
            }.apply()

            val intent = Intent(this, Login::class.java).apply {}
            startActivity(intent)
            finish()
        }

    fun gotohome(){
        val intent = Intent(this, Home::class.java).apply {}
        startActivity(intent)
        finish()
    }


}