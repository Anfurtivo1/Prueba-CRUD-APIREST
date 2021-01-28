package com.andressanchez.pruebaapirest.services

import com.andressanchez.pruebaapirest.entidades.albums.Album
import com.andressanchez.pruebaapirest.entidades.albums.AlbumDTO
import retrofit2.Call
import retrofit2.http.*


interface AlbumREST {

    @GET("albums/")
    fun albumGetAll(): Call<List<AlbumDTO>>

    @POST("albums/")
    fun createAlbum(@Body album: AlbumDTO): Call<AlbumDTO>

    @PUT("albums/{id}")
    fun albumsUpdate(@Path("id") id: Int, @Body albumDTO: AlbumDTO): Call<AlbumDTO>

    @DELETE("albums/{id}")
    fun albumDelete(@Path("id") id: Int): Call<AlbumDTO>

}