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

class EventsAdapter (var context: Context) : RecyclerView.Adapter<EventsAdapter.ClubViewHolder> (){

    var DataList = mutableListOf<Events>()
    internal fun setData(eventArray : ArrayList<Events>)
    {
        this.DataList = eventArray
    }
    class ClubViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        //        val ClubImg : ImageView = itemView.findViewById<ImageView>(R.id.Clubimageitem)
        val ClubLocation  : TextView = itemView.findViewById<TextView>(R.id.DescriptionClubItem)
        val ClubTitle  : TextView = itemView.findViewById<TextView>(R.id.TitleClubitem)
        val ClubDate  : TextView = itemView.findViewById<TextView>(R.id.dateClubitem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClubViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.itemclubb, parent, false)
        return ClubViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ClubViewHolder, position: Int) {
        val currentItem = DataList[position]

//        holder.ClubImg.setImageResource(currentItem.ClubImg)
        holder.ClubLocation.text = currentItem.adress
        holder.ClubTitle.text = currentItem.title
        holder.ClubDate.text = currentItem.date

        holder.itemView.setOnClickListener {
            val preferences = PreferenceManager.getDefaultSharedPreferences(context)
            val editor = preferences.edit()
            editor.putString("eventsDescription", currentItem.description)
            editor.putString("eventsTitle", currentItem.title)
            editor.putString("eventsDate", currentItem.date)
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