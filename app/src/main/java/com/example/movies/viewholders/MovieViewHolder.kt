package com.example.movies.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.example.movies.data.entity.Movie
import com.example.movies.databinding.MovieItemBinding

class MovieViewHolder(private val binding: MovieItemBinding) :
    RecyclerView.ViewHolder(binding.root) {


    fun bind(movie: Movie) {
        binding.movieNameTV.text = movie.movieName
    }

}