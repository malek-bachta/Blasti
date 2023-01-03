package tn.mbach.Blasti.front

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import tn.mbach.Blasti.R


class NotificationFragment : Fragment() {

    private lateinit var CardReservation: CardView
    private lateinit var CardTicket: CardView



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_notification, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        CardReservation = view.findViewById(R.id.cardreservation)
        CardTicket = view.findViewById(R.id.cardtickets)


        gototicket()
        gotoreservations()

    }

    fun gototicket()
    {
        CardTicket.setOnClickListener {
            activity?.let{
                val intent = Intent (it, TicketNotif::class.java)
                it.startActivity(intent)
            }
        }
    }

    fun gotoreservations()
    {
        CardReservation.setOnClickListener {
            activity?.let{
                val intent = Intent (it, ReservationsNotif::class.java)
                it.startActivity(intent)
            }
        }
    }



}