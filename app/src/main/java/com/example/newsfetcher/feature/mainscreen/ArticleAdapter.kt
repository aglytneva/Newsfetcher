package com.example.newsfetcher.feature.mainscreen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.newsfetcher.R
import com.example.newsfetcher.feature.domain.ArticleModel

class ArticleAdapter : RecyclerView.Adapter<ArticleAdapter.ViewHolder>() {

        // передаем в эту переменную список статей
        private var articlesData:List <ArticleModel> = emptyList ()

        /**Условие использования IPI
         * Лучший пример внутреннего класса kotlin
         * Provide a reference to the type of views that you are using
         * (custom ViewHolder).
         */
        class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val textView: TextView

            init {
                // Define click listener for the ViewHolder's View.
                textView = view.findViewById(R.id.tvTittle)
            }
        }

        // Create new views (invoked by the layout manager)
        override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
            // Create a new view, which defines the UI of the list item
            val view = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.item_article, viewGroup, false)

            return ViewHolder(view)
        }

        // Replace the contents of a view (invoked by the layout manager)
        override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

            // Get element from your dataset at this position and replace the
            // contents of the view with that element
            viewHolder.textView.text = articlesData[position].title
        }

        // Return the size of your dataset (invoked by the layout manager)
        override fun getItemCount() = articlesData.size

        fun setData (articles :List <ArticleModel>) {
            articlesData = articles
            notifyDataSetChanged()

    }

}