package tn.mbach.Blasti.front

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import tn.mbach.Blasti.Adapter.moviesAdapter
import tn.mbach.Blasti.Adapter.EventsAdapter
import tn.mbach.Blasti.Adapter.ShowsAdapter
import tn.mbach.Blasti.Data.ShowInfo
import tn.mbach.Blasti.Models.Events
import tn.mbach.Blasti.Models.Shows
import tn.mbach.Blasti.Models.moviesss
import tn.mbach.Blasti.Network.EventsApi
import tn.mbach.Blasti.Network.MoviesApi
import tn.mbach.Blasti.Network.ShowsApi
import tn.mbach.Blasti.Network.retrofit
import tn.mbach.Blasti.R


class HomeFragment : Fragment() {


    private lateinit var RecyclerShow: RecyclerView
    private lateinit var RecyclerShowAdapter: ShowsAdapter
    //
    private lateinit var Recyclerevent: RecyclerView
    private lateinit var RecyclereventAdapter: EventsAdapter
    //
    private lateinit var searchView: SearchView
    //
    private lateinit var Recyclermovies: RecyclerView
    private lateinit var RecyclermoviesAdapter: moviesAdapter

    var postM: ArrayList<moviesss> = ArrayList<moviesss>()
    var postE: ArrayList<Events> = ArrayList<Events>()
    var postS: ArrayList<Shows> = ArrayList<Shows>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        RecyclerShow = view.findViewById(R.id.RecyclerShow)
        Recyclerevent = view.findViewById(R.id.Recyclerevents)
        Recyclermovies = view.findViewById(R.id.RecyclerMovies)
        searchView = view.findViewById(R.id.searchViewHome)


        RecyclerShow.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        RecyclerShowAdapter = ShowsAdapter(requireContext())
        RecyclerShow.adapter = RecyclerShowAdapter


        Recyclerevent.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        RecyclereventAdapter = EventsAdapter(requireContext())
        Recyclerevent.adapter = RecyclereventAdapter

       // RecyclermoviesAdapter = showAdapter(listitem as ArrayList<ShowInfo>)


        Recyclermovies.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        RecyclermoviesAdapter = moviesAdapter(requireContext())
        Recyclermovies.adapter = RecyclermoviesAdapter

        ShowAllMovies()
        ShowAllevents()
        ShowAllShows()
        println("Sizzzzzzeeeeeeee "+postS.size)

        OpenSearch()

    }
    fun OpenSearch()
    {
        searchView.setOnClickListener {
            searchView.isIconified = false
        }
    }

    fun ShowAllMovies() {
        val retrofi: Retrofit = retrofit.getInstance()
        val service: MoviesApi = retrofi.create(MoviesApi::class.java)
        val call: Call<List<moviesss>> = service.showmovies()
        call.enqueue(object : Callback<List<moviesss>> {
            override fun onResponse(call: Call<List<moviesss>>, response: Response<List<moviesss>>) {

                println("Body ==== "+response.body().toString())
                postM = ArrayList(response.body())
                RecyclermoviesAdapter.setData(postM)
//                println("Sizzzzzzeeeeeeee "+postM.size)
                RecyclermoviesAdapter.notifyDataSetChanged()

//                 MoviesList.add(response.body())
            }
            override fun onFailure(call: Call<List<moviesss>>, t: Throwable) {
                println("Message :" + t.stackTrace)
                Log.d("*", "Opppsss" + t.message)
            }
        })
    }


    fun ShowAllevents() {
        val retrofi: Retrofit = retrofit.getInstance()
        val service: EventsApi = retrofi.create(EventsApi::class.java)
        val call: Call<List<Events>> = service.showEvents()
        call.enqueue(object : Callback<List<Events>> {
            override fun onResponse(call: Call<List<Events>>, response: Response<List<Events>>) {

                println("Body ==== "+response.body().toString())
                postE = ArrayList(response.body())
                RecyclereventAdapter.setData(postE)
                println("Sizzzzzzeeeeeeee event "+postE.size)

                RecyclereventAdapter.notifyDataSetChanged()

            }
            override fun onFailure(call: Call<List<Events>>, t: Throwable) {
                println("Message :" + t.stackTrace)
                Log.d("*", "Opppsss" + t.message)
            }
        })
    }



    fun ShowAllShows() {
        val retrofi: Retrofit = retrofit.getInstance()
        val service: ShowsApi = retrofi.create(ShowsApi::class.java)
        val call: Call<List<Shows>> = service.affShows()
        call.enqueue(object : Callback<List<Shows>> {
            override fun onResponse(call: Call<List<Shows>>, response: Response<List<Shows>>) {

                println("Body ==== "+response.body().toString())
                postS = ArrayList(response.body())
                RecyclerShowAdapter.setData(postS)
                println("Sizzzzzzeeeeeeee "+postS.size)

                RecyclerShowAdapter.notifyDataSetChanged()
                // MoviesList.add(response.body())

            }
            override fun onFailure(call: Call<List<Shows>>, t: Throwable) {
                println("Message :" + t.stackTrace)
                Log.d("*", "Opppsss" + t.message)
            }
        })
    }

}