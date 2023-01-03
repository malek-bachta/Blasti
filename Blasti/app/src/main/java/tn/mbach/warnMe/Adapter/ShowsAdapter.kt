package tn.mbach.warnMe.Adapter

import android.app.Application
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.preference.PreferenceManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.*
import tn.mbach.warnMe.Data.eventInfo
import tn.mbach.warnMe.Models.FavoriteShows
import tn.mbach.warnMe.Models.Shows
import tn.mbach.warnMe.R
import tn.mbach.warnMe.front.ShowsDetail

class ShowsAdapter (var context: Context) : RecyclerView.Adapter<ShowsAdapter.ShowViewHolder> (){

    var DataList = mutableListOf<Shows>()
    internal fun setData(showsArray : ArrayList<Shows>)
    {
        this.DataList = showsArray
    }

    class ShowViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        //val ShowImg : ImageView = itemView.findViewById<ImageView>(R.id.showimageitem)
        val ShowLocation  : TextView = itemView.findViewById<TextView>(R.id.Locationshowitem)
        val ShowDate  : TextView = itemView.findViewById<TextView>(R.id.dateshowitem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.itemshow, parent, false)
        return ShowViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ShowViewHolder, position: Int) {
        val currentItem = DataList[position]

        //holder.ShowImg.setImageResource(currentItem.ShowImg)
        holder.ShowLocation.text = currentItem.title
//        holder.ShowTitle.text = currentItem.description
        holder.ShowDate.text = currentItem.date

        holder.itemView.setOnClickListener {
            val preferences = PreferenceManager.getDefaultSharedPreferences(context)
            val editor = preferences.edit()
//            editor.putString("ShowsDescription", currentItem.description)
            editor.putString("showsTitle", currentItem.title)
            editor.putString("showsDate", currentItem.date)
            editor.putString("showsDescription", currentItem.description)
            editor.putString("showsActors", currentItem.actor)
            editor.putString("showsPlaces", currentItem.place)
            editor.putString("showsGenre", currentItem.genre)
            editor.putString("showsid", currentItem.id)
            editor.apply()  //Save Data
//            println("Ratteeeeeeeeeeeee "+data.getRate())
            ///
//            t7ot fuction thezk lel page te3 details

            verifFavorite()


            val intent = Intent(context, ShowsDetail::class.java)
            context.startActivity(intent)
        }
    }

    override fun getItemCount() = DataList.size

    fun verifFavorite(){
        val androidFactory =
            ViewModelProvider.AndroidViewModelFactory(context.applicationContext as Application)
        val viewModell: FavoriteShows = androidFactory.create(FavoriteShows::class.java)
        //////////////////
        val Jooobbb = GlobalScope.launch(Dispatchers.Default) {
            viewModell.VerifFavoriteCoroutineScope(context)
            // delay the coroutine by 1sec
            delay(1000)
        }
        //////////////////
        runBlocking {
            Jooobbb.join()
            println("Blooocck")
        }
        //////////////////
    }

}