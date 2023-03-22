package com.example.moviepoisk.presentation.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moviepoisk.R
import com.example.moviepoisk.RequestSuccessListener
import com.example.moviepoisk.business.movieList.adapter.recycleView.ParentRecycleViewAdapter
import com.example.moviepoisk.business.viewModel.MovieListViewModel
import com.example.moviepoisk.business.viewModel.factory.MovieListFactory
import com.example.moviepoisk.data.model.Doc
import com.example.moviepoisk.databinding.FragmentFilmsListBinding


class FilmsListFragment : Fragment(R.layout.fragment_films_list) {
    private lateinit var binding: FragmentFilmsListBinding
    private var docs: MutableList<List<Doc>> = mutableListOf()
    private lateinit var viewModel: MovieListViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var parentRecycleViewAdapter: ParentRecycleViewAdapter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFilmsListBinding.bind(view)

        viewModel = ViewModelProvider(this, MovieListFactory(requireActivity().application))
            .get(MovieListViewModel::class.java)

        recyclerView = binding.movieRecycleView

        setMainRecycleView()
        requestMovies()


    }

    override fun onStart() {
        super.onStart()

        viewModel.allDocs.observe(this) {
            if (it.size != 0)  {
                docs.add(it.get(it.size-1))
            }
            parentRecycleViewAdapter.notifyItemInserted(docs.size-1)
        }
    }


    private fun requestMovies() {
        viewModel.requestMovies()
    }

    private fun setMainRecycleView() {
        val layoutManager = LinearLayoutManager(context)

        parentRecycleViewAdapter = ParentRecycleViewAdapter(docs)
        recyclerView.adapter = parentRecycleViewAdapter
        recyclerView.layoutManager = layoutManager
    }

}