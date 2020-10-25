package com.example.movies.ui.main

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.movies.data.DataRepository
import com.example.movies.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val repository = DataRepository.getInstance(this)
        mainViewModel = ViewModelProvider(
            this,
            MainViewModelFactory(repository)
        ).get(MainViewModel::class.java)

        mainViewModel.movieWithActors.observe(this, Observer {
            if(it != null) {
                Log.d("MovieWithActors", it.toString())
            } else {
                Log.d("MovieWithActors", "is null")
            }
        })
    }
}