package com.example.newsfetcher

import com.google.gson.annotations.SerializedName

data class SimpleModel (

    @SerializedName ("country")
    val country:String,

    @SerializedName("count")
    val count:Int,

    @SerializedName("list")
    val list:List<String>
)