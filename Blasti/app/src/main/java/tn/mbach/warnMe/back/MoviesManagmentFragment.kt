package tn.mbach.warnMe.back

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import tn.mbach.warnMe.R
import tn.mbach.warnMe.Utils.Validator
import tn.mbach.warnMe.ViewModel.MoviesViewModel
import tn.mbach.warnMe.ViewModel.UserViewModel
import tn.mbach.warnMe.databinding.FragmentMoviesManagmentBinding
import tn.mbach.warnMe.front.MovieGenre


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

    private val viewModel by viewModels<MoviesViewModel>()



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

        txttestin = view.findViewById(R.id.testin)
        txttestedit = view.findViewById(R.id.testedit)

        txttestin.setOnClickListener{
            val intent = Intent (context, MovieGenre::class.java)
            startActivity(intent)
        }


/*
        btnGet.setOnClickListener { tvw.setText("Selected Date: " + picker.dayOfMonth + "/" + (picker.month + 1) + "/" + picker.year) }
*/

        initView()
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
                viewModel.addMovie(txtTitle,txtGenre,txtDescription,txtproduction,txtlanguage,txtrating,txtduration,dataTime,requireContext(),requireActivity())

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



}