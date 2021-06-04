package com.taksuinterview.kaisinema.presentation.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.taksuinterview.kaisinema.R
import com.taksuinterview.kaisinema.domain.result.MovieSum
import kotlinx.android.synthetic.main.item_movie_list.view.*

class MovieListAdapter(private val onClickItem: (MovieSum) -> Unit) :
    RecyclerView.Adapter<MovieListAdapter.Holder>() {
    private val items: MutableList<MovieSum> = arrayListOf()

    fun setItems(items: MutableList<MovieSum>) {
        this.items.clear()
        this.items.addAll(items)
        notifyItemRangeChanged(0, items.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_movie_list, parent, false)
        return Holder(v)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val appointment = items[position]
        holder.bind(appointment, onClickItem)
    }

    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: MovieSum, onClickItem: (MovieSum) -> Unit) {
            Glide.with(itemView.context).load(item.posterSmall)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(itemView.iv_poster)

            itemView.tv_title.text = item.originalTitle
            itemView.tv_release_date.text = item.releaseDate
            itemView.tv_overview.text = item.overview
            itemView.tv_rate.text = item.voteAverage.toString()

            itemView.setOnClickListener { onClickItem(item) }
        }
    }
}