package com.example.newsfetcher

import android.app.PendingIntent.getActivity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.newsfetcher.feature.articleInfoFragment.ArticleInfoFragment
import com.example.newsfetcher.feature.articleInfoFragment.ArticleInfoViewModel
import com.example.newsfetcher.feature.bookmarks.ui.BookmarksFragment
import com.example.newsfetcher.feature.mainscreen.MainScreenFragment
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private val bottomNavigationMenu: BottomNavigationView by lazy {findViewById(R.id.bnvBar)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        supportFragmentManager.beginTransaction().replace(R.id.container, MainScreenFragment())
            .commit()


        bottomNavigationMenu.setOnItemSelectedListener {

            when (it.itemId) {
                R.id.itemMain -> {

                    if (bottomNavigationMenu.selectedItemId != it.itemId) {

                        selectTab(MainScreenFragment())
                        removeTab(ArticleInfoFragment())
                    }
                }
                R.id.itemBookmarks -> {
                    if (bottomNavigationMenu.selectedItemId != it.itemId) {
                        selectTab(BookmarksFragment())
                        removeTab(ArticleInfoFragment())
                    }
                }

                else ->{
                    removeTab(ArticleInfoFragment())}
            }
            true
        }

//        bottomNavigationMenu.selectedItemId = R.id.itemMain

    }

    private fun selectTab (fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.container, fragment).commit()
    }

    private fun removeTab (fragment: Fragment) {
        supportFragmentManager.beginTransaction().remove(fragment).commit()
//        supportFragmentManager.clearBackStack(fragment.toString())
    }


}