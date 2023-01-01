package tn.mbach.warnMe.front

import android.app.Activity
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.app.ActivityCompat.startActivityForResult
import androidx.preference.PreferenceManager
import tn.mbach.warnMe.Data.*
import tn.mbach.warnMe.Login
import tn.mbach.warnMe.R
import tn.mbach.warnMe.Utils.CustomToast
import tn.mbach.warnMe.back.HomeAdmin

val REQUEST_CODE = 100

class ProfileFragment : Fragment() {

    private lateinit var MyName: TextView
    private lateinit var Myemail: TextView
    private lateinit var btnLogout: Button
    private lateinit var btndashboard: Button
    private lateinit var MySharedPref: SharedPreferences
    private lateinit var CardProfile: CardView
    private lateinit var imgUser : ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
        val sharedPreference = PreferenceManager.getDefaultSharedPreferences(context)
        val role = sharedPreference.getString("role", null)



    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        btnLogout = requireView().findViewById(R.id.btnLogout)
        MyName = requireView().findViewById(R.id.MyName)
        Myemail = requireView().findViewById(R.id.Myemail)
        imgUser = requireView().findViewById(R.id.profileimg)
        btndashboard = requireView().findViewById(R.id.dashboard)

        CardProfile = requireView().findViewById(R.id.cardprofile)


        //
        MySharedPref = requireContext().getSharedPreferences(PREF_NAME, AppCompatActivity.MODE_PRIVATE);
        val nameUser = MySharedPref.getString(NAME, null)
        val emailUser = MySharedPref.getString(EMAIL, null)
        val roleUser = MySharedPref.getString(ROLE, null)


        MyName.text = nameUser
        Myemail.text = emailUser

        btnLogout.setOnClickListener {
            MySharedPref.edit().apply {
                putString(RememberEmail, "")
                putString(RememberPassword, "")
            }.apply()


            activity?.let{
                val intent = Intent (it, Login::class.java)
                it.startActivity(intent)
                it.finish()
            }

        }
        gotoEditProfile()
        println("aaaaaaaaaaaaaaaaaaakzklkdzkdnclznkazqk"+roleUser)

        imgUser.setOnClickListener { openGalleryForImage() }


        if (roleUser == "admin") {
            btndashboard.visibility = View.VISIBLE
            btndashboard.setOnClickListener {
                val intent = Intent (context, HomeAdmin::class.java)
                startActivity(intent)
            }
        } else {
            btndashboard.visibility = View.GONE
        }

    }

    fun gotoEditProfile()
    {
        CardProfile.setOnClickListener {
            fragmentManager?.beginTransaction()?.replace(R.id.frame_layout, EditProfile())?.addToBackStack("Edit")?.commit()
            }


    }


    fun openGalleryForImage()
    {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, REQUEST_CODE)
    }

    override  fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?)
    {
        //val imgUser : ImageView = findViewById(R.id.profileimg)
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE){
            imgUser.setImageURI(data?.data) // handle chosen image
            imgUser.setTag("imageHasChanged");
        }
    }



}