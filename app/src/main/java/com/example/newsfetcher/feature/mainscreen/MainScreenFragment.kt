package com.example.newsfetcher.feature.mainscreen

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.newsfetcher.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainScreenFragment : Fragment(R.layout.fragment_main_screen) {

    private val viewModel : MainScreenViewModel by viewModel()
    private val recyclerView: RecyclerView by lazy {requireActivity().findViewById (R.id.rvArticles) }
    private val ivSearch: ImageView by lazy {requireActivity().findViewById (R.id.ivSearch) }
    private val tvTittle: TextView by lazy {requireActivity().findViewById (R.id.tvTittle) }
    private val etSearch: EditText by lazy {requireActivity().findViewById (R.id.etSearch) }
    private val adapter: ArticleAdapter by lazy {
        ArticleAdapter { index ->
            viewModel.processUiEvent(UiEvent.OnArticleClicked(index))

        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.viewState.observe (viewLifecycleOwner, :: render)
        recyclerView.adapter=adapter

        ivSearch.setOnClickListener {
            viewModel.processUiEvent(UiEvent.OnSearchButtonClicked)
        }
    }
    private fun render (viewState: ViewState) {
        tvTittle.isVisible =!viewState.isSearchEnabled
        etSearch.isVisible = viewState.isSearchEnabled
        adapter.setData(viewState.articlesShown)
    }

}