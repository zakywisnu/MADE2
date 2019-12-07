package com.example.submission2bro.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.submission2bro.Model.Movie
import com.example.submission2bro.R
import com.example.submission2bro.View.MovieFragment
import com.squareup.picasso.Picasso
import kotlinx.android.extensions.LayoutContainer

class MovieAdapter(
    private val list: List<Movie>
) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    private var onItemClickCallback: OnItemClickCallback? = null

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieViewHolder {
        val inflater =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_movie_list, parent, false)
        return MovieViewHolder(inflater)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindItem(list[position])
    }

    class MovieViewHolder(override val containerView: View) :
        RecyclerView.ViewHolder(containerView), LayoutContainer {
        var movieName: TextView = itemView.findViewById(R.id.tv_movie_name)
        var movieYear: TextView = itemView.findViewById(R.id.tv_movie_year)
        var movieRate: TextView = itemView.findViewById(R.id.tv_movie_rate)
        var imgMovie: ImageView = itemView.findViewById(R.id.img_movie)

        fun bindItem(movie: Movie) {
            movieName.text = movie.movieName
            movieRate.text = movie.movieRate
            movieYear.text = movie.movieYear

            movie.imgMovie.let { Picasso.get().load(it).into(imgMovie) }
            containerView.setOnClickListener{}
        }
    }
    interface OnItemClickCallback {
        fun onItemClicked(movie: Movie)

    }

}

