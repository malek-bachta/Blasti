package tn.mbach.Blasti.back

import android.app.Activity
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import tn.mbach.Blasti.Data.*
import tn.mbach.Blasti.Login
import tn.mbach.Blasti.R
import tn.mbach.Blasti.front.EditProfile
import tn.mbach.Blasti.front.REQUEST_CODE

val REQUEST_CODE = 100

class HomeAdminFragment : Fragment() {

    private lateinit var MyName: TextView
    private lateinit var Myemail: TextView
    private lateinit var MySharedPref: SharedPreferences
    private lateinit var imgUser : ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_admin, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        MyName = requireView().findViewById(R.id.Name)
        Myemail = requireView().findViewById(R.id.Email)
        imgUser = requireView().findViewById(R.id.profileimgb)



        //
        MySharedPref = requireContext().getSharedPreferences(PREF_NAME, AppCompatActivity.MODE_PRIVATE);
        val nameUser = MySharedPref.getString(NAME, null)
        val emailUser = MySharedPref.getString(EMAIL, null)

        MyName.text = nameUser
        Myemail.text = emailUser


        imgUser.setOnClickListener { openGalleryForImage() }

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