package tn.mbach.warnMe.front

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import tn.mbach.warnMe.R
import tn.mbach.warnMe.databinding.HomeBinding


class Home : AppCompatActivity() {

    private lateinit var MySharedPref: SharedPreferences
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
    }
}