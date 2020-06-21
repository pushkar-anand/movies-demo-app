package com.example.movies.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movies.data.entity.Movie
import com.example.movies.databinding.MovieItemBinding
import com.example.movies.viewholders.MovieViewHolder

class MoviesAdapter : RecyclerView.Adapter<MovieViewHolder>() {

    var movies = emptyList<Movie>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = MovieItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return MovieViewHolder(binding)
    }

    override fun getItemCount() = movies.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        with(movies[position]) {
            holder.bind(this)
        }
    }
}