package com.example.userwithhilt_retrofit.data.datasource.network.model

import com.google.gson.annotations.SerializedName

data class NotesResponse(

    @SerializedName("count")
    var count: Int,

    @SerializedName("results")
    var recipes: List<NoteNetworkEntity>,
)