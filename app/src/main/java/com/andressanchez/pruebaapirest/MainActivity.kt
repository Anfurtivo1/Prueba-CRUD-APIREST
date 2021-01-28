package com.andressanchez.pruebaapirest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.andressanchez.pruebaapirest.controller.AlbumController
import com.andressanchez.pruebaapirest.entidades.albums.Album

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lista: MutableList<Album>

        AlbumController.recuperarAlbums(this)
        val album=Album(999,999,"Un titulo de album")
        AlbumController.insertarAlbum(album)

        album.title="Titulo cambiado por otro"
        AlbumController.actualizarAlbum(album)

        AlbumController.eliminarAlbum(album)

    }
}