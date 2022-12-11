package com.example.newsfetcher.feature.bookmarks.ui

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.newsfetcher.R
import com.example.newsfetcher.feature.articleInfoFragment.ArticleInfoFragment
import com.example.newsfetcher.feature.domain.ArticleModel


import org.koin.androidx.viewmodel.ext.android.viewModel

class BookmarksFragment:Fragment (R.layout.fragment_bookmarks) {
    private val viewModel: BookmarksScreenViewModel by viewModel()
    private val recyclerView: RecyclerView by lazy {requireActivity().findViewById (R.id.rvBookmarkedArticles)}
    private val adapter: BookmarksArticleAdapter by lazy {
        BookmarksArticleAdapter ({ index ->
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
//        val bundle = Bundle()
//        bundle.putString("title",currentArticle.title)
//        bundle.putString("author",currentArticle.author)
//        bundle.putString("url",currentArticle.url)
//        bundle.putString("content",currentArticle.content)
//        bundle.putString("description",currentArticle.description)
//        bundle.putString("publishedAt",currentArticle.publishedAt)
//        bundle.putString("urlToImage",currentArticle.urlToImage)


//      Использование KTX
        val bundle = bundleOf(
            "title" to currentArticle.title,
            "author" to currentArticle.author,
            "url" to currentArticle.url,
            "content" to currentArticle.content,
            "description" to currentArticle.description,
            "publishedAt" to currentArticle.publishedAt,
            "urlToImage" to currentArticle.urlToImage
        )
        parentFragmentManager.beginTransaction().add(
            R.id.container, ArticleInfoFragment.getNewInstance(bundle)).commit()
    }
}