package com.example.newsfetcher.feature.bookmarks.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.newsfetcher.R
import com.example.newsfetcher.feature.articleInfoFragment.ArticleInfoFragment
import com.example.newsfetcher.feature.domain.ArticleModel
import com.example.newsfetcher.feature.mainscreen.ArticleAdapter


import org.koin.androidx.viewmodel.ext.android.viewModel

class BookmarksFragment:Fragment (R.layout.fragment_bookmarks) {
    private val viewModel: BookmarksScreenViewModel by viewModel()
    private val recyclerView: RecyclerView by lazy {requireActivity().findViewById (R.id.rvBookmarkedArticles)}
    private val adapter: ArticleAdapter by lazy {
        ArticleAdapter ({ index ->
            viewModel.processUiEvent(UiEvent.OnArticleClicked(index))
        }, {currentArticle -> openArticle(currentArticle)})
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.viewState.observe (viewLifecycleOwner, :: render)
        recyclerView.adapter=adapter

    }

    private fun render (viewState: ViewState) {

       adapter.setData(viewState.bookmarksArticles)
    }

    private fun openArticle(currentArticle: ArticleModel) {
        val bundle = Bundle()
        bundle.putString("title",currentArticle.title)
        bundle.putString("author",currentArticle.author)
        bundle.putString("url",currentArticle.url)
        bundle.putString("content",currentArticle.content)
        bundle.putString("description",currentArticle.description)
        bundle.putString("publishedAt",currentArticle.publishedAt)
        bundle.putString("urlToImage",currentArticle.urlToImage)

        parentFragmentManager.beginTransaction().add(
            R.id.container, ArticleInfoFragment.getNewInstance(bundle)).commit()
    }
}