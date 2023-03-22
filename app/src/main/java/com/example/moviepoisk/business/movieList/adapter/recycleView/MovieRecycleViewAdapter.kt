package com.example.moviepoisk.business.movieList.adapter.recycleView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.moviepoisk.R
import com.example.moviepoisk.data.model.Doc
import com.squareup.picasso.Picasso

class MovieRecycleViewAdapter(var docs: List<Doc>): RecyclerView.Adapter<MovieRecycleViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v: View = LayoutInflater.from(parent.context).inflate(R.layout.film_item, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return docs.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val doc = docs[position]

        holder.filmNameTv.text = doc.name
        if (doc.poster.url != null) {
            val picasso = Picasso.get()
            picasso.load(doc.poster.url).into(holder.filmImage)
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val filmNameTv: TextView
        val filmImage: ImageView

        init {
            filmNameTv = itemView.findViewById(R.id.filme_name)
            filmImage = itemView.findViewById(R.id.film_image)
        }
    }
}