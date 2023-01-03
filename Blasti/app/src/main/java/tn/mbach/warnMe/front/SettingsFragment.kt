package tn.mbach.Blasti.front

import android.annotation.SuppressLint
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.facebook.shimmer.ShimmerFrameLayout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import tn.mbach.Blasti.Adapter.FavoriteEventAdapter
import tn.mbach.Blasti.Adapter.FavoriteMovieAdapter
import tn.mbach.Blasti.Adapter.FavoriteShowAdapter
import tn.mbach.Blasti.Data.ID
import tn.mbach.Blasti.Data.PREF_NAME
import tn.mbach.Blasti.Models.Events
import tn.mbach.Blasti.Models.Shows
import tn.mbach.Blasti.Models.User
import tn.mbach.Blasti.Models.moviesss
import tn.mbach.Blasti.Network.EventsApi
import tn.mbach.Blasti.Network.MoviesApi
import tn.mbach.Blasti.Network.ShowsApi
import tn.mbach.Blasti.Network.retrofit
import tn.mbach.Blasti.R


class SettingsFragment : Fragment() {

    lateinit var favouriterecyclerM: RecyclerView
    lateinit var favouriterecyclerE: RecyclerView
    lateinit var favouriterecyclerS: RecyclerView
    lateinit var AdapterFavoriteMovie: FavoriteMovieAdapter
    lateinit var AdapterFavoriteEvent: FavoriteEventAdapter
    lateinit var AdapterFavoriteShow: FavoriteShowAdapter
    private lateinit var MySharedPref: SharedPreferences
    var PostsModelsM: ArrayList<moviesss> = ArrayList()
    var PostsModelsE: ArrayList<Events> = ArrayList()
    var PostsModelsS: ArrayList<Shows> = ArrayList()

//    lateinit var mShimmerViewContainer: ShimmerFrameLayout
//    private lateinit var SwipeRefreshFavorite: SwipeRefreshLayout


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        favouriterecyclerM = view.findViewById(R.id.favouriterecyclerM)
        favouriterecyclerE = view.findViewById(R.id.favouriterecyclerE)
        favouriterecyclerS = view.findViewById(R.id.favouriterecyclerS)
        //
        favouriterecyclerM.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        AdapterFavoriteMovie = FavoriteMovieAdapter(requireContext())
        favouriterecyclerM.adapter = AdapterFavoriteMovie
        //
        favouriterecyclerE.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        AdapterFavoriteEvent = FavoriteEventAdapter(requireContext())
        favouriterecyclerE.adapter = AdapterFavoriteEvent
        //
        favouriterecyclerS.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        AdapterFavoriteShow = FavoriteShowAdapter(requireContext())
        favouriterecyclerS.adapter = AdapterFavoriteShow
        //
        MySharedPref =
            requireContext().getSharedPreferences(PREF_NAME, AppCompatActivity.MODE_PRIVATE);
        val idUser = MySharedPref.getString(ID, null)
        //
        ShowMyFavoriteM(idUser.toString())
        ShowMyFavoriteE(idUser.toString())
//        ShowMyFavoriteS(idUser.toString())
        //
       /* mShimmerViewContainer = view.findViewById(R.id.shimmer_Favorite);
        //
        SwipeRefreshFavorite=view.findViewById(R.id.SwipeRefreshFavorite)
        //
        SwipeRefreshFavorite.setOnRefreshListener {
            ShowMyFavorite(idUser.toString())
            SwipeRefreshFavorite.isRefreshing = false   // reset the SwipeRefreshLayout (stop the loading spinner)
        }*/
    }

    fun ShowMyFavoriteM(idUser:String) {
        val map: HashMap<String, String> = HashMap()
        map["idUser"] = idUser
        //
        val retrofi: Retrofit = retrofit.getInstance()
        val service: MoviesApi = retrofi.create(MoviesApi::class.java)
        val call: Call<List<moviesss>> = service.FavoritefindByUser(map)
        call.enqueue(object : Callback<List<moviesss>> {
            override fun onResponse(call: Call<List<moviesss>>, response: Response<List<moviesss>>) {
                PostsModelsM = ArrayList(response.body())
                AdapterFavoriteMovie.setData(PostsModelsM)
                AdapterFavoriteMovie.notifyDataSetChanged()
                if (AdapterFavoriteMovie.itemCount==0)
                {
                    favouriterecyclerM.visibility = View.GONE
                }
            }
            @SuppressLint("RestrictedApi")
            override fun onFailure(call: Call<List<moviesss>>, t: Throwable) {
                println("Message :" + t.stackTrace)
                Log.d("***", "Opppsss" + t.message)
            }
        })
    }

    fun ShowMyFavoriteE(idUser:String) {
        val map: HashMap<String, String> = HashMap()
        map["idUser"] = idUser
        //
        val retrofi: Retrofit = retrofit.getInstance()
        val service: EventsApi = retrofi.create(EventsApi::class.java)
        val call: Call<List<Events>> = service.FavoritefindByUser(map)
        call.enqueue(object : Callback<List<Events>> {
            override fun onResponse(call: Call<List<Events>>, response: Response<List<Events>>) {
                PostsModelsE = ArrayList(response.body()!!)
                AdapterFavoriteEvent.setData(PostsModelsE)
                AdapterFavoriteEvent.notifyDataSetChanged()
                if (AdapterFavoriteEvent.itemCount==0)
                {
                    favouriterecyclerE.visibility = View.GONE
                }
            }
            @SuppressLint("RestrictedApi")
            override fun onFailure(call: Call<List<Events>>, t: Throwable) {
                println("Message :" + t.stackTrace)
                Log.d("***", "Opppsss" + t.message)
            }
        })
    }
/*

    fun ShowMyFavoriteS(idUser:String) {
        val map: HashMap<String, String> = HashMap()
        map["idUser"] = idUser
        //
        val retrofi: Retrofit = retrofit.getInstance()
        val service: ShowsApi = retrofi.create(ShowsApi::class.java)
        val call: Call<List<Shows>> = service.FavoritefindByUser(map)
        call.enqueue(object : Callback<List<Shows>> {
            override fun onResponse(call: Call<List<Shows>>, response: Response<List<Shows>>) {
                PostsModelsS = ArrayList(response.body()!!)
                AdapterFavoriteShow.setData(PostsModelsS)
                AdapterFavoriteShow.notifyDataSetChanged()
                if (AdapterFavoriteShow.itemCount==0)
                {
                    favouriterecyclerS.visibility = View.GONE
                }
            }
            @SuppressLint("RestrictedApi")
            override fun onFailure(call: Call<List<Shows>>, t: Throwable) {
                println("Message :" + t.stackTrace)
                Log.d("***", "Opppsss" + t.message)
            }
        })
    }
*/
//
//    override fun onResume() {
//        super.onResume()
//        mShimmerViewContainer.startShimmerAnimation()
//    }
//
//    override fun onPause() {
//        mShimmerViewContainer.stopShimmerAnimation()
//        super.onPause()
//    }

}