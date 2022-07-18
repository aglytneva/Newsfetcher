package com.example.newsfetcher.feature.data

import com.example.newsfetcher.feature.data.model.ArticleRemoteModel
import com.example.newsfetcher.feature.domain.ArticleModel

fun ArticleRemoteModel.toDomain ()= ArticleModel (

    author = author ?:"",
    title =title ?:"",
    description =description ?:"" ,
    url =url ?:"",
    urlToImage =urlToImage ?:"",
    publishedAt =publishedAt ?:"",
    content = content ?:""
)