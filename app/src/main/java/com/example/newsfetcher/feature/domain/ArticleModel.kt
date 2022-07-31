package com.example.newsfetcher.feature.domain

import android.os.Parcel
import android.os.Parcelable

data class ArticleModel(

    val author: String?,
    var title: String,
    val description: String?,
    val url: String?,
    val urlToImage: String?,
    val publishedAt: String?,
    val content: String?,
)
//    : Parcelable {
//
//    constructor(parcel: Parcel) : this(
//        parcel.readString(),
//        parcel.readString().toString(),
//        parcel.readString(),
//        parcel.readString(),
//        parcel.readString(),
//        parcel.readString(),
//        parcel.readString()
//
//    )
//
//
//    override fun writeToParcel(parcel: Parcel, flags: Int) {
//        parcel.writeString(author)
//        parcel.writeString(title)
//        parcel.writeString(description)
//        parcel.writeString(url)
//        parcel.writeString(urlToImage)
//        parcel.writeString(publishedAt)
//        parcel.writeString(content)
//    }
//
//    override fun describeContents(): Int {
//        return 0
//    }
//
//    companion object CREATOR : Parcelable.Creator<ArticleModel> {
//        override fun createFromParcel(parcel: Parcel): ArticleModel {
//            return ArticleModel(parcel)
//        }
//
//        override fun newArray(size: Int): Array<ArticleModel?> {
//            return arrayOfNulls(size)
//        }
//    }
//}