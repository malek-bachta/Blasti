package tn.mbach.warnMe.front

import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import tn.mbach.warnMe.Data.PREF_NAME
import tn.mbach.warnMe.R

class EditProfile : Fragment() {

    lateinit var buttonbackedit: ImageView
    private lateinit var MySharedPref: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.edit_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        (requireActivity() as Home).BottomNavigationView.visibility =
            View.GONE // Hide Bottom Nav (Par prof)

        initView()
        BackToProfile()

    }


    fun initView() {
        MySharedPref =
            requireContext().getSharedPreferences(PREF_NAME, AppCompatActivity.MODE_PRIVATE);

        buttonbackedit = requireView().findViewById(R.id.buttonbackedit)
    }
    fun BackToProfile() {
        buttonbackedit.setOnClickListener {
            //fragmentManager?.beginTransaction()?.replace(R.id.container, EditProfil())?.commit()
            fragmentManager?.beginTransaction()?.replace(R.id.frame_layout, ProfileFragment())
                ?.addToBackStack("profile")?.commit()
            (requireActivity() as Home).BottomNavigationView.visibility = View.VISIBLE
        }
    }
}