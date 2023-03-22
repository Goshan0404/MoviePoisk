package com.example.moviepoisk.business.movieList.adapter.recycleView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moviepoisk.R
import com.example.moviepoisk.data.model.Doc
import com.example.moviepoisk.databinding.ParentRecycleviewItemBinding

class ParentRecycleViewAdapter(private var allDocs: List<List<Doc>>):
    RecyclerView.Adapter<ParentRecycleViewAdapter.ParentViewHolder>() {

     private val viewPool = RecyclerView.RecycledViewPool()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParentViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemBinding = ParentRecycleviewItemBinding.inflate(layoutInflater, parent, false)
        return ParentViewHolder(itemBinding)
    }

    override fun getItemCount(): Int {
        return allDocs.size
    }

    override fun onBindViewHolder(holder: ParentViewHolder, position: Int) {
        val docs: List<Doc> = allDocs[position]
//        val category = docs[position].type

     //   holder.categoryText.text = category

        val linearLayoutManager = LinearLayoutManager(holder.movieRecycleView.context,
            LinearLayoutManager.HORIZONTAL, false)

        linearLayoutManager.initialPrefetchItemCount = docs.size

        val movieRecycleViewAdapter = MovieRecycleViewAdapter(docs)

        holder.movieRecycleView.layoutManager = linearLayoutManager
        holder.movieRecycleView.adapter = movieRecycleViewAdapter
        holder.movieRecycleView.hasFixedSize()
        holder.movieRecycleView.setRecycledViewPool(viewPool)
    }

    class ParentViewHolder(private val itemBinding: ParentRecycleviewItemBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        val categoryText: TextView
        var movieRecycleView: RecyclerView

        init {
            categoryText = itemBinding.categoryFilm
            movieRecycleView = itemBinding.parentRecycleView
        }

    }
}
