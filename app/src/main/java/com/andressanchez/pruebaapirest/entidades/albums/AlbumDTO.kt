package com.andressanchez.pruebaapirest.entidades.albums

import com.google.gson.annotations.SerializedName

class AlbumDTO (
    @SerializedName("userId") val userId: Int,
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String
)