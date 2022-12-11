package tn.mbach.warnMe.back

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
import tn.mbach.warnMe.R
import tn.mbach.warnMe.Utils.Validator
import tn.mbach.warnMe.ViewModel.EventsViewModel

class EventsManagmentFragment : Fragment() {
    private lateinit var txttitleLayout: TextInputLayout
    private lateinit var txtgenreLayout: TextInputLayout
    private lateinit var txtdescriptiondLayout: TextInputLayout
    //
    private lateinit var txtTitle: TextInputEditText
    private lateinit var txtGenre: TextInputEditText
    private lateinit var txtDescription: TextInputEditText
    //
    private  lateinit var picker : DatePicker
    private lateinit var btnGet : Button
    private lateinit var tvw : TextView
    //
    val Validator = Validator()

    private val viewModel by viewModels<EventsViewModel>()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_events_managment, container, false)



    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        tvw = view.findViewById(R.id.date)
        picker = view.findViewById(R.id.datepick)
        btnGet = view.findViewById(R.id.addEvent)

/*
        btnGet.setOnClickListener { tvw.setText("Selected Date: " + picker.dayOfMonth + "/" + (picker.month + 1) + "/" + picker.year) }
*/

        initView()
        DoActionaddevent()
    }

    fun initView()
    {
        txttitleLayout =  requireView().findViewById(R.id.titlein)
        txtgenreLayout = requireView().findViewById(R.id.genrein)
        txtdescriptiondLayout = requireView().findViewById(R.id.descriptionin)

        //

        txtTitle = requireView().findViewById(R.id.titleedit)
        txtGenre = requireView().findViewById(R.id.genreedit)
        txtDescription = requireView().findViewById(R.id.descriptionedit)

    }

    fun DoActionaddevent() {
        gettextwathceraddevent()
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
                viewModel.addEvent(txtTitle,txtGenre,txtDescription,dataTime,requireContext(),requireActivity())
            }
        }
    }

    private fun gettextwathceraddevent() {
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