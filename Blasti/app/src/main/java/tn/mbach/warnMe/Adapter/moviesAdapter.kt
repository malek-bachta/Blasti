package tn.mbach.warnMe.Adapter

import android.app.Application
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.lifecycle.ViewModelProvider
import androidx.preference.PreferenceManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.*
import tn.mbach.warnMe.Models.FavoriteMovies
import tn.mbach.warnMe.Models.moviesss
import tn.mbach.warnMe.R
import tn.mbach.warnMe.front.MovieDetail

class moviesAdapter (var context: Context) : RecyclerView.Adapter<moviesAdapter.moviesViewHolder> (){

    var DataList = mutableListOf<moviesss>()
    internal fun setData(movieArray : ArrayList<moviesss>)
    {
      this.DataList = movieArray
    }
  /*  //video fi android 
    exoplayer*/

    class moviesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

       // val moviesImg : ImageView = itemView.findViewById<ImageView>(R.id.moviesimageitem)
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
//        holder.moviesDescription.text = currentItem.description
        holder.moviesTitle.text = currentItem.title
        holder.moviesDate.text = currentItem.date

        println("currentItem.title "+currentItem.title)

        holder.itemView.setOnClickListener {
            val preferences = PreferenceManager.getDefaultSharedPreferences(context)
            val editor = preferences.edit()
            editor.putString("moviesDescription", currentItem.description)
            editor.putString("moviesTitle", currentItem.title)
            editor.putString("moviesDate", currentItem.date)
            editor.putString("moviesGenre", currentItem.genre)
            editor.putString("moviesProduction", currentItem.production)
            editor.putString("moviesLanguage", currentItem.language)
            editor.putString("moviesDuration", currentItem.duration)
            editor.putString("moviesid", currentItem.id)
            editor.apply()  //Save Data
//            println("Ratteeeeeeeeeeeee "+data.getRate())
            ///
//            t7ot fuction thezk lel page te3 details

            verifFavorite()


            val intent = Intent(context, MovieDetail::class.java)
            context.startActivity(intent)
        }

    }

    override fun getItemCount() = DataList.size

    fun verifFavorite(){
        val androidFactory =
            ViewModelProvider.AndroidViewModelFactory(context.applicationContext as Application)
        val viewModell: FavoriteMovies = androidFactory.create(FavoriteMovies::class.java)
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