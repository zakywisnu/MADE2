package com.example.submission2bro.View


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.submission2bro.Adapter.MovieAdapter
import com.example.submission2bro.Model.Movie
import com.example.submission2bro.R
import com.google.android.material.bottomnavigation.BottomNavigationMenu
import com.google.android.material.bottomnavigation.BottomNavigationView


class MovieFragment : Fragment() {

    private var movie: MutableList<Movie> = mutableListOf()
    private lateinit var adapter: MovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_movie, container, false)
        val rv = view.findViewById<RecyclerView>(R.id.rv_movie)
        rv.layoutManager = GridLayoutManager(context, 2)
        rv.setHasFixedSize(true)
//        rv.adapter = MovieAdapter(movie,)
        initData()
        return view
    }

    private fun initData() {
        val movieName = resources.getStringArray(R.array.movie_name)
        val movieYear = resources.getStringArray(R.array.movie_year)
        val movieRate = resources.getStringArray(R.array.movie_rate)
        val movieDescription = resources.getStringArray(R.array.movie_desc)
        val imgMovie = resources.obtainTypedArray(R.array.img_movie)
        movie.clear()
        for (i in movieName.indices) {
            movie.add(
                Movie(
                    movieName[i],
                    movieYear[i],
                    movieRate[i],
                    imgMovie.getResourceId(i, 0),
                    movieDescription[i]
                )
            )
        }
    }
}
