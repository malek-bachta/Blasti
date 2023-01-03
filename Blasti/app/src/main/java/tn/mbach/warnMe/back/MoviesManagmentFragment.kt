package tn.mbach.warnMe.back

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import tn.mbach.warnMe.Data.ID
import tn.mbach.warnMe.Data.PREF_NAME
import tn.mbach.warnMe.R
import tn.mbach.warnMe.Utils.CustomToast
import tn.mbach.warnMe.Utils.Validator
import tn.mbach.warnMe.ViewModel.MoviesViewModel
import tn.mbach.warnMe.databinding.FragmentMoviesManagmentBinding
import tn.mbach.warnMe.front.MovieGenre
import java.io.File
import java.io.FileOutputStream

class MoviesManagmentFragment : Fragment() {
    private var _binding: FragmentMoviesManagmentBinding? = null
    private val binding get() = _binding!!
    //
    private lateinit var txttestin: TextInputLayout
    private lateinit var txttitleLayout: TextInputLayout
    private lateinit var txtgenreLayout: TextInputLayout
    private lateinit var txtdescriptiondLayout: TextInputLayout
    private lateinit var txtproductionLayout: TextInputLayout
    private lateinit var txtlanguageLayout: TextInputLayout
    private lateinit var txtratingLayout: TextInputLayout
    private lateinit var txtdurationLayout: TextInputLayout
    //
    private lateinit var txttestedit : TextInputEditText
    private lateinit var txtTitle: TextInputEditText
    private lateinit var txtGenre: TextInputEditText
    private lateinit var txtDescription: TextInputEditText
    private lateinit var txtproduction: TextInputEditText
    private lateinit var txtlanguage: AutoCompleteTextView
    private lateinit var txtrating: TextInputEditText
    private lateinit var txtduration: TextInputEditText
    //
    private  lateinit var picker : DatePicker
    private lateinit var btnGet : Button
    private lateinit var tvw : TextView
    //
    val Validator = Validator()

    var viewModell = MoviesViewModel()
    //
    private var imgUri: Uri? = null
    private val STORAGE_PERMISSION_CODE = 111
    private val IMAGE_GALLERY_REQUEST_CODE: Int = 2001
        lateinit var  uploadimgM:ImageView
    private lateinit var MySharedPref: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_movies_managment, container, false)

        _binding = FragmentMoviesManagmentBinding.inflate(inflater,container,false)
//        val moviegenre = resources.getStringArray(R.array.)


        val items = listOf("English","Arabic","French")
        val adapter = ArrayAdapter(requireContext(), R.layout.language, items)
        binding.languageedit.setAdapter(adapter)


        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        tvw = view.findViewById(R.id.date)
        picker = view.findViewById(R.id.datepick)
        btnGet = view.findViewById(R.id.addMovie)

        //txttestin = view.findViewById(R.id.testin)
        //txttestedit = view.findViewById(R.id.testedit)

//        txttestin.setOnClickListener{
//            val intent = Intent (context, MovieGenre::class.java)
//            startActivity(intent)
//        }


/*
        btnGet.setOnClickListener { tvw.setText("Selected Date: " + picker.dayOfMonth + "/" + (picker.month + 1) + "/" + picker.year) }
*/

        initView()
        SelectImage()
        DoActionaddmovie()
    }

    fun initView()
    {
        txttitleLayout =  requireView().findViewById(R.id.titlein)
        txtgenreLayout = requireView().findViewById(R.id.genrein)
        txtdescriptiondLayout = requireView().findViewById(R.id.descriptionin)
        txtproductionLayout = requireView().findViewById(R.id.productionin)
        txtlanguageLayout = requireView().findViewById(R.id.languagein)
        txtratingLayout = requireView().findViewById(R.id.ratingin)
        txtdurationLayout = requireView().findViewById(R.id.durationin)
        //

        txtTitle = requireView().findViewById(R.id.titleedit)
        txtGenre = requireView().findViewById(R.id.genreedit)
        txtDescription = requireView().findViewById(R.id.descriptionedit)
        txtproduction = requireView().findViewById(R.id.productionedit)
        txtlanguage = requireView().findViewById(R.id.languageedit)
        txtrating = requireView().findViewById(R.id.ratingedit)
        txtduration = requireView().findViewById(R.id.durationedit)
//
        uploadimgM = requireView().findViewById(R.id.uploadimgM)

    }

    fun DoActionaddmovie() {
        gettextwathceraddmovie()
        btnGet.setOnClickListener {
            if (!Validator.VerifisEmpty(txtTitle,txttitleLayout)
                or !Validator.VerifisEmpty(txtGenre,txtgenreLayout)
                or !Validator.VerifisEmpty(txtproduction,txtproductionLayout)
                or !Validator.VerifisEmptyauto(txtlanguage,txtlanguageLayout)
                or !Validator.VerifisEmpty(txtduration,txtdurationLayout)
                or !Validator.VerifisEmpty(txtDescription,txtdescriptiondLayout)) {
                println("Something is Empty!")
                return@setOnClickListener
            } else {
                println("let's Go!!!!!")
                val dataTime ="" + picker.dayOfMonth + "/" + (picker.month + 1) + "/" + picker.year
               // viewModell.addMovie(txtTitle,txtGenre,txtDescription,txtproduction,txtlanguage,txtrating,txtduration,dataTime,requireContext(),requireActivity())
                uploadimgM.setOnClickListener {
                    openGallery()
                }
                addmoviewithupload(requireContext())
            }
        }
    }

    private fun gettextwathceraddmovie() {
        txtTitle.addTextChangedListener(TitletxtWatcher)
        txtGenre.addTextChangedListener(GenretxtWatcher)
        txtDescription.addTextChangedListener(DescriptiontxtWatcher)
    }


    private val TitletxtWatcher: TextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        override fun afterTextChanged(s: Editable) {
            Validator.VerifisEmpty(txtTitle,txttitleLayout)
        }
    }

    private val GenretxtWatcher: TextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        override fun afterTextChanged(s: Editable) {
            Validator.VerifisEmpty(txtGenre,txtgenreLayout)
        }
    }

    private val DescriptiontxtWatcher: TextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        override fun afterTextChanged(s: Editable) {
            Validator.VerifisEmpty(txtDescription,txtdescriptiondLayout)
        }
    }



    ///////////
    @SuppressLint("Recycle")
    fun addmoviewithupload(context: Context){
        //
        MySharedPref =
            context.getSharedPreferences(PREF_NAME, AppCompatActivity.MODE_PRIVATE);
        val IdUser = MySharedPref.getString(ID, null)

        //
        val fileDir=context.filesDir
        val file= File(fileDir,"image.jpg")
        val inputStream=context.contentResolver.openInputStream(imgUri!!)
        val outputStream= FileOutputStream(file)
        inputStream!!.copyTo(outputStream)
        val requestBody=file.asRequestBody("image/*".toMediaTypeOrNull())
        val image = MultipartBody.Part.createFormData("image", file.name,requestBody)

        viewModell= ViewModelProvider(requireActivity()).get(MoviesViewModel::class.java)

       // viewModell.addMovie(txtTitle,txtGenre,txtDescription,txtproduction,txtlanguage,txtrating,txtduration,dataTime,requireContext(),requireActivity())


        val txtdescription = txtDescription.text .toString().trim().toRequestBody("text/plain".toMediaTypeOrNull())
        //val idUser=IdUser.toString().trim().toRequestBody("text/plain".toMediaTypeOrNull())
        val txttitle= txtTitle.text.toString().trim().toRequestBody("text/plain".toMediaTypeOrNull())
        val txtgenre=txtGenre.text.toString().trim().toRequestBody("text/plain".toMediaTypeOrNull())
        val txtproduction= txtproduction.text.toString().trim().toRequestBody("text/plain".toMediaTypeOrNull())
        val txtlanguage=txtlanguage.text.toString().trim().toRequestBody("text/plain".toMediaTypeOrNull())
        val txtrating= txtrating.text.toString().trim().toRequestBody("text/plain".toMediaTypeOrNull())
        val txtduration=txtduration.text.toString().trim().toRequestBody("text/plain".toMediaTypeOrNull())
        val dataTime=tvw.text.toString().trim().toRequestBody("text/plain".toMediaTypeOrNull())

        viewModell.addmovie( txttitle, dataTime, txtdescription, txtgenre, image, txtduration, txtlanguage,txtproduction,txtrating,context)
        //
        viewModell._UserLiveData.observe(viewLifecycleOwner,{
            if (it!=null){
                CustomToast(requireContext(), "Post Added Successfully!","GREEN").show()
            }else{
                CustomToast(requireContext(), "Sorry, Something Goes Wrong!","RED").show()
            }
        })
    }

/*
    fun BackToProfile() {
        //fragmentManager?.beginTransaction()?.replace(R.id.container, EditProfil())?.commit()
        fragmentManager?.beginTransaction()?.replace(R.id.container, ProfileFragment())
            ?.addToBackStack("profile")?.commit()
        (requireActivity() as Navigation).BottomNavigationView.visibility = View.VISIBLE

    }
*/

    //////////////////////////////////////////////////////////////

    fun SelectImage()
    {
        uploadimgM.setOnClickListener {
            openGallery()
        }
    }

    private fun openGallery() {
        //requestStoragePermission()
        Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI).apply {
            type="image/*"
            startActivityForResult(this,IMAGE_GALLERY_REQUEST_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == IMAGE_GALLERY_REQUEST_CODE) {
            if (data != null && data.data != null) {
                if (Build.VERSION.SDK_INT >= 28) {
                    imgUri= data.data!!
                    uploadimgM.setImageURI(imgUri)
                    ////
                }
            }
        }
    }

    private fun requestStoragePermission() {
        if(ActivityCompat.shouldShowRequestPermissionRationale(requireActivity(), Manifest.permission.READ_EXTERNAL_STORAGE))
        {
            AlertDialog.Builder(requireContext())
                .setTitle("Autorisation nécessaire")
                .setMessage("Cette autorisation est nécessaire pour ajouter une image")
                .setPositiveButton("D'accord",
                    DialogInterface.OnClickListener { dialog, which ->
                        requestPermissions(arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),STORAGE_PERMISSION_CODE)
                    })
                .setNegativeButton("Annuler",
                    DialogInterface.OnClickListener { dialog, which -> dialog.dismiss() })
                .create().show()
        } else {
            requestPermissions(arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),STORAGE_PERMISSION_CODE)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String?>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == STORAGE_PERMISSION_CODE) {
            if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                openGallery()
                Toast.makeText(requireContext(), "Permission accordée", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(requireContext(), "Permission refusée", Toast.LENGTH_SHORT).show()
            }
        }
    }

}