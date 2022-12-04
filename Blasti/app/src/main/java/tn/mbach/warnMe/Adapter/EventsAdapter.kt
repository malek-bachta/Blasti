package tn.mbach.warnMe.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import tn.mbach.warnMe.Data.ShowInfo
import tn.mbach.warnMe.Models.Events
import tn.mbach.warnMe.Models.moviesss
import tn.mbach.warnMe.R

class EventsAdapter () : RecyclerView.Adapter<EventsAdapter.ShowViewHolder> (){

    var DataList = mutableListOf<Events>()
    internal fun setData(eventArray : ArrayList<Events>)
    {
        this.DataList = eventArray
    }

    class ShowViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        //val ShowImg : ImageView = itemView.findViewById<ImageView>(R.id.showimageitem)
        val ShowLocation  : TextView = itemView.findViewById<TextView>(R.id.Locationshowitem)
        val ShowTitle  : TextView = itemView.findViewById<TextView>(R.id.Titleshowitem)
        val ShowDate  : TextView = itemView.findViewById<TextView>(R.id.dateshowitem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.itemshow, parent, false)
        return ShowViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ShowViewHolder, position: Int) {
        val currentItem = DataList[position]

        //holder.ShowImg.setImageResource(currentItem.ShowImg)
        holder.ShowLocation.text = currentItem.adress
        holder.ShowTitle.text = currentItem.title
        holder.ShowDate.text = currentItem.date
    }

    override fun getItemCount() = DataList.size


}