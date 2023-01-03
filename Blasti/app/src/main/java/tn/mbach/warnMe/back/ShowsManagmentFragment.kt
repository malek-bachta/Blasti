package tn.mbach.Blasti.back

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import androidx.fragment.app.viewModels
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import tn.mbach.Blasti.R
import tn.mbach.Blasti.Utils.Validator
import tn.mbach.Blasti.ViewModel.ShowsViewModel


class ShowsManagmentFragment : Fragment() {
    //
    private lateinit var txttitleLayout: TextInputLayout
    private lateinit var txtgenreLayout: TextInputLayout
    private lateinit var txtdescriptiondLayout: TextInputLayout
    private lateinit var txtactorsLayout: TextInputLayout
    private lateinit var txtticketsLayout: TextInputLayout
    //
    private lateinit var txtTitle: TextInputEditText
    private lateinit var txtGenre: TextInputEditText
    private lateinit var txtDescription: TextInputEditText
    private lateinit var txtactors: TextInputEditText
    private lateinit var txttickets: TextInputEditText

    //
    private  lateinit var picker : DatePicker
    private lateinit var btnGet : Button
    //
    val Validator = Validator()

    private val     viewModel by viewModels<ShowsViewModel>()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_shows_managment, container, false)



    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        picker = view.findViewById(R.id.datepick)
        btnGet = view.findViewById(R.id.addShow)

/*
        btnGet.setOnClickListener { tvw.setText("Selected Date: " + picker.dayOfMonth + "/" + (picker.month + 1) + "/" + picker.year) }
*/

        initView()
        DoActionaddshow()
    }

    fun initView()
    {
        txttitleLayout =  requireView().findViewById(R.id.titlein)
        txtgenreLayout = requireView().findViewById(R.id.genrein)
        txtdescriptiondLayout = requireView().findViewById(R.id.descriptionin)
        txtactorsLayout = requireView().findViewById(R.id.actorsin)
        txtticketsLayout = requireView().findViewById(R.id.ticketsin)

        //

        txtTitle = requireView().findViewById(R.id.titleedit)
        txtGenre = requireView().findViewById(R.id.genreedit)
        txtDescription = requireView().findViewById(R.id.descriptionedit)
        txtactors = requireView().findViewById(R.id.actorsedit)
        txttickets = requireView().findViewById(R.id.ticketsedit)

    }

    fun DoActionaddshow() {
        gettextwathceraddshow()
//        btnGet.setOnClickListener { tvw.setText("Selected Date: " + picker.dayOfMonth + "/" + (picker.month + 1) + "/" + picker.year) }
        btnGet.setOnClickListener {
            println("bbbbbbbbbbbbbbbbbbbbbbbb")
            if (!Validator.VerifisEmpty(txtTitle,txttitleLayout) or !Validator.VerifisEmpty(txtGenre,txtgenreLayout)
                or !Validator.VerifisEmpty(txtDescription,txtdescriptiondLayout)) {
                println("Something is Empty!")
                return@setOnClickListener
            } else {
                println("let's Go!!!!!")
                val dataTime ="" + picker.dayOfMonth + "/" + (picker.month + 1) + "/" + picker.year
                viewModel.addShow(txtTitle,txtGenre,txtDescription,txtactors,txttickets,dataTime,requireContext(),requireActivity())
            }
        }
    }

    private fun gettextwathceraddshow() {
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