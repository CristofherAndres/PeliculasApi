package com.example.pelicukasapi.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pelicukasapi.Model.Movie
import kotlinx.android.synthetic.main.movie_item.view.*
import com.bumptech.glide.Glide
import com.example.pelicukasapi.R

class MovieAdapter(private val movies: List<Movie>)
    :RecyclerView.Adapter<MovieAdapter.ViewHolder>()
{

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.movie_item,parent,false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindMovie(movies.get(position))
    }

    override fun getItemCount(): Int = movies.size

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
            private val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/"

            fun bindMovie(movie: Movie){
                itemView.titulo.text = movie.title
                itemView.fecha.text = movie.release
                Glide.with(itemView).load(IMAGE_BASE+movie.poster)
                    .into(itemView.poster)
            }

        }

}




