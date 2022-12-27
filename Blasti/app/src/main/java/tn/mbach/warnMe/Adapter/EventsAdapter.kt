package tn.mbach.warnMe.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.preference.PreferenceManager
import androidx.recyclerview.widget.RecyclerView
import tn.mbach.warnMe.Models.Events
import tn.mbach.warnMe.R
import tn.mbach.warnMe.front.EventDetail

class EventsAdapter (var context: Context) : RecyclerView.Adapter<EventsAdapter.eventViewHolder> (){

    var DataList = mutableListOf<Events>()
    internal fun setData(eventArray : ArrayList<Events>)
    {
        this.DataList = eventArray
    }
    class eventViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        //        val eventImg : ImageView = itemView.findViewById<ImageView>(R.id.eventimageitem)
        val eventTitle  : TextView = itemView.findViewById<TextView>(R.id.Titleeventitem)
        val eventDate  : TextView = itemView.findViewById<TextView>(R.id.dateeventitem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): eventViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.itemevent, parent, false)
        return eventViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: eventViewHolder, position: Int) {
        val currentItem = DataList[position]

//        holder.eventImg.setImageResource(currentItem.eventImg)
//        holder.eventLocation.text = currentItem.adress
        holder.eventTitle.text = currentItem.title
        holder.eventDate.text = currentItem.date

        holder.itemView.setOnClickListener {
            val preferences = PreferenceManager.getDefaultSharedPreferences(context)
            val editor = preferences.edit()
//            editor.putString("eventsDescription", currentItem.description)
            editor.putString("eventsTitle", currentItem.title)
            editor.putString("eventsDescription", currentItem.description)
            editor.putString("eventsDate", currentItem.date)
            editor.putString("eventsGenre", currentItem.genre)
            editor.putString("eventsGuest", currentItem.guest)
            editor.putString("eventsCost", currentItem.cost)
            editor.putString("eventsPlacesD", currentItem.pAvailable)
            editor.putString("eventsAdress", currentItem.adress)
            editor.apply()  //Save Data
//            println("Ratteeeeeeeeeeeee "+data.getRate())
            ///
//            t7ot fuction thezk lel page te3 details
            val intent = Intent(context, EventDetail::class.java)
            context.startActivity(intent)
        }
    }

    override fun getItemCount() = DataList.size

}