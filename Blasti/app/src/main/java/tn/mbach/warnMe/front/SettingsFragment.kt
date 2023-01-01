package tn.mbach.warnMe.front

import android.annotation.SuppressLint
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.facebook.shimmer.ShimmerFrameLayout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import tn.mbach.warnMe.Adapter.moviesAdapter
import tn.mbach.warnMe.Data.ID
import tn.mbach.warnMe.Data.PREF_NAME
import tn.mbach.warnMe.Models.User
import tn.mbach.warnMe.Network.MoviesApi
import tn.mbach.warnMe.Network.retrofit
import tn.mbach.warnMe.R


class SettingsFragment : Fragment() {

    lateinit var RecylerFavorite: RecyclerView
    lateinit var AdapterRecommended: moviesAdapter
    private lateinit var MySharedPref: SharedPreferences
    var PostsModels: ArrayList<User> = ArrayList()
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
        RecylerFavorite = view.findViewById(R.id.favouriterecycler)
        RecylerFavorite.setLayoutManager(StaggeredGridLayoutManager(2, 1))
        AdapterRecommended = moviesAdapter(requireContext())
        RecylerFavorite.adapter = AdapterRecommended
        //
        MySharedPref =
            requireContext().getSharedPreferences(PREF_NAME, AppCompatActivity.MODE_PRIVATE);
        val idUser = MySharedPref.getString(ID, null)
        //
        ShowMyFavorite(idUser.toString())
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

    fun ShowMyFavorite(idUser:String) {
        val map: HashMap<String, String> = HashMap()
        map["idUser"] = idUser
        //
        val retrofi: Retrofit = retrofit.getInstance()
        val service: MoviesApi = retrofi.create(MoviesApi::class.java)
        val call: Call<List<User>> = service.FavoritefindByUser(map)
        call.enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                PostsModels = ArrayList(response.body())
                //println("Boddddyyyyyyyyyy "+response.body())
                //println("Size in fun "+PostsModels.size)
//                AdapterRecommended.setDataList(PostsModels)
                AdapterRecommended.notifyDataSetChanged()
                // Stopping Shimmer Effect's animation after data is loaded to ListView
//                mShimmerViewContainer.stopShimmerAnimation();
//                mShimmerViewContainer.setVisibility(View.GONE);
            }
            @SuppressLint("RestrictedApi")
            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                println("Message :" + t.stackTrace)
                Log.d("***", "Opppsss" + t.message)
            }
        })
    }
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