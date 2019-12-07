package com.example.submission2bro.View


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.submission2bro.Adapter.TvShowAdapter
import com.example.submission2bro.Model.TvShow
import com.example.submission2bro.R

/**
 * A simple [Fragment] subclass.
 */
class TvShowFragment : Fragment() {
    private var tvShow: MutableList<TvShow> = mutableListOf()
    private lateinit var adapter: TvShowAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_tv_show, container, false)
        val rv = view.findViewById<RecyclerView>(R.id.rv_tv_show)
        rv.layoutManager = GridLayoutManager(context, 2)
//        adapter = TvShowAdapter(tvShow, listener)
        rv.adapter = adapter
        initData()
        return view
    }

    fun initData() {
        val tvShowName = resources.getStringArray(R.array.tv_show_name)
        val tvShowYear = resources.getStringArray(R.array.tv_show_year)
        val tvShowRate = resources.getStringArray(R.array.tv_show_rate)
        val tvShowDescription = resources.getStringArray(R.array.tv_show_desc)
        val imgTvShow = resources.obtainTypedArray(R.array.img_tv_show)
        tvShow.clear()
        for (i in tvShowName.indices) {
            tvShow.add(
                TvShow(
                    tvShowName[i],
                    tvShowYear[i],
                    tvShowRate[i],
                    imgTvShow.getResourceId(i, 0),
                    tvShowDescription[i]
                )
            )
        }
    }
}



