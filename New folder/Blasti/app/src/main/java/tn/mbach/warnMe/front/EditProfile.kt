package tn.mbach.warnMe.front

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import tn.mbach.warnMe.R

class EditProfile : AppCompatActivity() {

    private lateinit var btnback: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_edit_profile)
        initView()
        BackToProfile()
    }

    fun initView() {
        btnback = findViewById(R.id.buttonback)
    }


    fun BackToProfile() {
        btnback.setOnClickListener {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.frame_layout, ProfileFragment())
            transaction.commit()
        }
    }
}