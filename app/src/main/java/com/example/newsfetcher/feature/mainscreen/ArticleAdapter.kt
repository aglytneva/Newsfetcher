package com.example.newsfetcher.feature.mainscreen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsfetcher.R
import com.example.newsfetcher.feature.domain.ArticleModel
//( val onItemClick:() ->Int ) передаем функцию высшего порядка
class ArticleAdapter (
    private val onAddToBookmarksClicked: (Int) -> Unit,
    private val onArticleClicked: (ArticleModel) -> Unit
) : RecyclerView.Adapter<ArticleAdapter.ViewHolder>() {

        // передаем в эту переменную список статей, создаем самостоятельно
        private var articlesData:List <ArticleModel> = emptyList ()


        /**Условие использования IPI
         * Лучший пример внутреннего класса kotlin
         * Provide a reference to the type of views that you are using
         * (custom ViewHolder).
         */
        class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val tvTittle: TextView
            val tvDate: TextView
            val ivFavorite: ImageView
            val image:ImageView

            init {
                tvTittle = view.findViewById(R.id.tvTittle)
                tvDate = view.findViewById(R.id.tvDate)
                ivFavorite = view.findViewById(R.id.ivFavorite)
                image=view.findViewById(R.id.ivImageNew)
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
        //здесь формируется вид карточки
        override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

            //нажатие на item вызывает номер
            viewHolder.ivFavorite.setOnClickListener {
                onAddToBookmarksClicked.invoke(position)
//                notifyDataSetChanged()
            }

            viewHolder.tvTittle.setOnClickListener{
                onArticleClicked.invoke(articlesData[position])
            }

            // Get element from your dataset at this position and replace the
            // contents of the view with that element
            viewHolder.tvTittle.text = articlesData[position].title
            viewHolder.tvDate.text = articlesData[position].publishedAt
            if (articlesData[position].favoriteArticlecChoice)
                viewHolder.ivFavorite.setBackgroundResource(R.drawable.ic_baseline_favorite_24)
            Glide
                .with(viewHolder.image)
                .load(articlesData[position].urlToImage)
                .placeholder(R.drawable.ic_baseline_article_24)
                .into(viewHolder.image)
        }

        // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = articlesData.size

    //создаем метод, который самостоятельно дергает дату
    fun setData (articles :List <ArticleModel>) {
            articlesData = articles
            notifyDataSetChanged()

    }

}