package com.andressanchez.pruebaapirest.controller

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.andressanchez.pruebaapirest.entidades.albums.Album
import com.andressanchez.pruebaapirest.entidades.albums.AlbumDTO
import com.andressanchez.pruebaapirest.entidades.albums.AlbumMapper
import com.andressanchez.pruebaapirest.services.AlbumAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object AlbumController {

    public fun recuperarAlbums(context: Context) {
        val clientREST = AlbumAPI.service
        Log.i("Album","Se ha entrado a recupear album")
        val call: Call<List<AlbumDTO>> = clientREST.albumGetAll()
        call.enqueue((object : Callback<List<AlbumDTO>> {
            override fun onResponse(call: Call<List<AlbumDTO>>, response: Response<List<AlbumDTO>>) {
                Log.i("Album","Se ha entrado a onResponse")
                if (response.isSuccessful) {
                    Log.i("Album", "AlbumGetAll ok")
                    var albums = (AlbumMapper.fromDTO(response.body() as MutableList<AlbumDTO>)) as MutableList<Album>
                    for (album in albums){
                        print(album)
                        Log.i("Album", album.title)
                    }
                } else {
                    Log.i("Album", "Error: AlbumGetAll isSuccessful")
                }
            }

            override fun onFailure(call: Call<List<AlbumDTO>>, t: Throwable) {
                Toast.makeText(context,
                    "Error al acceder al servicio: " + t.localizedMessage,
                    Toast.LENGTH_LONG)
                    .show()
            }
        }))
    }

     fun insertarAlbum(Album: Album) {
        val clientREST = AlbumAPI.service
        val call: Call<AlbumDTO> = clientREST.createAlbum((AlbumMapper.toDTO(Album)))
        call.enqueue((object : Callback<AlbumDTO>  {

            override fun onResponse(call: Call<AlbumDTO>, response: Response<AlbumDTO>) {
                if (response.isSuccessful) {
                    Log.i("Album", "AlbumPost ok")
                } else {
                    Log.i("Album", "Error AlbumPost isSeccesful")
                    Log.i("Insertar", "Error al insertar: " + response.message())
                }
            }

            override fun onFailure(call: Call<AlbumDTO>, t: Throwable) {
                Log.i("REST", "Error al acceder al servicio: " + t.localizedMessage)
            }
        }))
    }


     fun actualizarAlbum(album: Album) {
        val clientREST = AlbumAPI.service
        val albumDTO = AlbumMapper.toDTO(album)

        val call: Call<AlbumDTO> = clientREST.albumsUpdate(album.id, albumDTO)
        call.enqueue((object : Callback<AlbumDTO> {

            override fun onResponse(call: Call<AlbumDTO>, response: Response<AlbumDTO>) {
                if (response.isSuccessful) {
                    Log.i("Album", "AlbumUpdate ok")

                } else {
                    Log.i("Album", "Error: AlbumUpdate isSuccessful")
                }
            }

            override fun onFailure(call: Call<AlbumDTO>, t: Throwable) {
            }
        }))

    }

     fun eliminarAlbum(album: Album) {
        val clientREST = AlbumAPI.service
        val call: Call<AlbumDTO> = clientREST.albumDelete(album.id)
        call.enqueue((object : Callback<AlbumDTO> {

            override fun onResponse(call: Call<AlbumDTO>, response: Response<AlbumDTO>) {
                if (response.isSuccessful) {
                    Log.i("Album", "AlbumDelete ok")
                } else {
                    Log.i("Album", "Error: AlbumDelete isSuccessful")
                    Log.i("Eliminar", "Error al eliminar: " + response.message())
                }
            }

            override fun onFailure(call: Call<AlbumDTO>, t: Throwable) {
                Log.i("Album", "Error al acceder al servicio: " + t.localizedMessage)
            }
        }))
    }

}