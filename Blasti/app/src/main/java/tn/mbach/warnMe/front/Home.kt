package tn.mbach.Blasti.front

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import tn.mbach.Blasti.R
import tn.mbach.Blasti.databinding.HomeBinding


class Home : AppCompatActivity() {

    /*private lateinit var MySharedPref: SharedPreferences
    private lateinit var binding: HomeBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //        setContentView(R.layout.home)
        binding = HomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(HomeFragment())
        binding.bottomNavigation.setOnItemSelectedListener {

            when (it.itemId) {
                R.id.profile -> replaceFragment(ProfileFragment())
                R.id.home -> replaceFragment(HomeFragment())
                R.id.notification -> replaceFragment(NotificationFragment())
                R.id.settings -> replaceFragment(SettingsFragment())
            }
            true
        }

        //

    }

    private fun replaceFragment(fragment: Fragment) {
        if (fragment != null) {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.frame_layout, fragment)
            transaction.commit()
        }
    }*/

    lateinit var BottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home)
        //
        BottomNavigationView = findViewById(R.id.bottom_navigation)
        //
        ///////////////////////////////////////////////////////////////////////////////////////////
        supportFragmentManager.beginTransaction().replace(R.id.frame_layout, HomeFragment()).commit();
        BottomNavigationView.setSelectedItemId(R.id.home)
        BottomNavigationView.setOnItemSelectedListener { item ->
            var selectedFragment: Fragment? = null
            when (item.itemId) {
                R.id.home -> {
                    selectedFragment = HomeFragment()
                }
                R.id.notification -> {
                    selectedFragment = NotificationFragment()
                }
                R.id.profile -> {
                    selectedFragment = ProfileFragment()
                }
                R.id.settings -> {
                    selectedFragment = SettingsFragment()
                }
            }
            val transaction = supportFragmentManager.beginTransaction()
            transaction.setCustomAnimations(
                R.anim.slide_in,
                R.anim.slide_out
            )
            transaction.replace(R.id.frame_layout, selectedFragment!!)
            transaction.commit()
            true
        }
        ///////////////////////////////////////////////////////////////////////////////////////////
    }

}