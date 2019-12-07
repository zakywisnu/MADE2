package com.example.submission2bro.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.submission2bro.Model.TvShow
import com.example.submission2bro.R
import com.example.submission2bro.View.MovieFragment
import com.example.submission2bro.View.TvShowFragment
import com.squareup.picasso.Picasso
import kotlinx.android.extensions.LayoutContainer

class TvShowAdapter(
    private val list: List<TvShow>
) :
    RecyclerView.Adapter<TvShowAdapter.TvShowViewHolder>() {

//    private var onItemClickCallback: OnItemClickCallback? = null
//
//    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback){
//        this.onItemClickCallback = onItemClickCallback
//    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TvShowViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.fragment_tv_show, parent, false)
        return TvShowViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        holder.bindItem(list[position])
    }

    class TvShowViewHolder(override val containerView: View) :
        RecyclerView.ViewHolder(containerView), LayoutContainer {
        var tvShowName: TextView = itemView.findViewById(R.id.tv_tv_name)
        var tvShowYear: TextView = itemView.findViewById(R.id.tv_tv_year)
        var tvShowRate: TextView = itemView.findViewById(R.id.tv_tv_rate)
        var imgTvShow: ImageView = itemView.findViewById(R.id.img_tv_show)

        fun bindItem(tvShow: TvShow) {
            tvShowName.text = tvShow.tvShowName
            tvShowRate.text = tvShow.tvShowRate
            tvShowYear.text = tvShow.tvShowYear

            tvShow.imgTvShow.let { Picasso.get().load(it).into(imgTvShow) }
            containerView.setOnClickListener{}
        }

    }
    interface OnItemClickCallback {
        fun onItemClicked(tvShow: TvShow)

    }
}


