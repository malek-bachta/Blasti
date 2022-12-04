package tn.mbach.warnMe.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import tn.mbach.warnMe.Data.moviesInfo
import tn.mbach.warnMe.Models.Movies
import tn.mbach.warnMe.Models.moviesss
import tn.mbach.warnMe.R

class moviesAdapter () : RecyclerView.Adapter<moviesAdapter.moviesViewHolder> (){

    var DataList = mutableListOf<moviesss>()
    internal fun setData(movieArray : ArrayList<moviesss>)
    {
      this.DataList = movieArray
    }
  /*  //video fi android 
    exoplayer*/

    class moviesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

       // val moviesImg : ImageView = itemView.findViewById<ImageView>(R.id.moviesimageitem)
        val moviesDescription  : TextView = itemView.findViewById<TextView>(R.id.description)
        val moviesTitle  : TextView = itemView.findViewById<TextView>(R.id.title)
        val moviesDate  : TextView = itemView.findViewById<TextView>(R.id.datemoviesitem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): moviesViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.itemmovies, parent, false)
        return moviesViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: moviesViewHolder, position: Int) {
        val currentItem = DataList[position]

       // holder.moviesImg.setImageResource(currentItem.moviesImg)
        holder.moviesDescription.text = currentItem.description
        holder.moviesTitle.text = currentItem.title
        holder.moviesDate.text = currentItem.date

        println("currentItem.title "+currentItem.title)
    }

    override fun getItemCount() = DataList.size


}