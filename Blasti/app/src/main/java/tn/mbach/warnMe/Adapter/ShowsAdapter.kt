package tn.mbach.warnMe.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import tn.mbach.warnMe.Data.clubbInfo
import tn.mbach.warnMe.Models.Shows
import tn.mbach.warnMe.Models.moviesss
import tn.mbach.warnMe.R

class ShowsAdapter () : RecyclerView.Adapter<ShowsAdapter.ClubViewHolder> (){

    var DataList = mutableListOf<Shows>()
    internal fun setData(showsArray : ArrayList<Shows>)
    {
        this.DataList = showsArray
    }

    class ClubViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

//        val ClubImg : ImageView = itemView.findViewById<ImageView>(R.id.Clubimageitem)
        val ClubLocation  : TextView = itemView.findViewById<TextView>(R.id.LocationClubitem)
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
        holder.ClubLocation.text = currentItem.description
        holder.ClubTitle.text = currentItem.title
        holder.ClubDate.text = currentItem.date
    }

    override fun getItemCount() = DataList.size


}