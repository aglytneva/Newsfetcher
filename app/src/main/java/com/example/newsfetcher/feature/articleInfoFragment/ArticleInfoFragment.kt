package com.example.newsfetcher.feature.articleInfoFragment

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.TextUtils.replace
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.newsfetcher.R
import com.example.newsfetcher.feature.domain.ArticleModel
import com.example.newsfetcher.feature.mainscreen.MainScreenFragment
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.CollapsingToolbarLayout
import org.koin.androidx.fragment.android.replace
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.concurrent.Executors

class ArticleInfoFragment:Fragment (R.layout.fragment_newsinfo) {

//    private val viewModel: ArticleScreenViewModel by viewModel()
    private val articleImage: ImageView by lazy { requireActivity().findViewById(R.id.newImage) }
    private val btnBack: ImageView by lazy { requireActivity().findViewById(R.id.btnBackToArticleList) }
    private val collTullBar: CollapsingToolbarLayout by lazy { requireActivity().findViewById(R.id.main_collapsing)}
    private val decriptopnInfo: TextView by lazy { requireActivity().findViewById(R.id.tvNewInfo) }
    private val urlInfo: TextView by lazy { requireActivity().findViewById(R.id.tvNewUrl) }

    companion object {
        fun getNewInstance(args: Bundle?) : ArticleInfoFragment {
            val articleInfoFragment = ArticleInfoFragment()
            articleInfoFragment.arguments = args
            return articleInfoFragment
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        viewModel.viewState.observe(viewLifecycleOwner, ::render)

        val title = arguments?.get("title").toString()
        val author = arguments?.get("author").toString()
        val url = arguments?.get("url").toString()
        val content = arguments?.get("content").toString()
        val description = arguments?.get("description").toString()
        val publishedAt = arguments?.get("publishedAt").toString()
        val urlToImage = arguments?.get("urlToImage").toString()

        getImageOfArticleFromUrl(urlToImage)

        collTullBar.title = title
        decriptopnInfo.text = description
        urlInfo.text = url


        btnBack.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .remove(this).commit()
        }
//        title.text = this.arguments?.get("title").toString()
//
//        val currentArticle :ArticleModel = this.arguments?.get("article") as ArticleModel
//        viewModel.processUiEvent(DataEvent.ShowArticle(currentArticle))
    }


    private fun getImageOfArticleFromUrl(urlToImage: String) {
        val executor = Executors.newSingleThreadExecutor()
        val handler = Handler(Looper.getMainLooper())
        var image: Bitmap?
        executor.execute {
            try {
                val `in` = java.net.URL(urlToImage).openStream()
                image = BitmapFactory.decodeStream(`in`)
                handler.post {
                    articleImage.setImageBitmap(image)
                }
            }
            catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

//    private fun getArgs(viewState: ViewState) {
//        title.text = viewState.title
//
//    }

}