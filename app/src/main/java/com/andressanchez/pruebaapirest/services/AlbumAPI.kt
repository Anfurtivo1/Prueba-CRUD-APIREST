package com.andressanchez.pruebaapirest.services

object AlbumAPI {

    private const val server = "192.168.1.50"

    private const val port = "6969"
    private const val API_URL = "http://$server:$port/"

    val service: AlbumREST
        get() = AlbumClient.getClient(API_URL)!!.create(AlbumREST::class.java)

}