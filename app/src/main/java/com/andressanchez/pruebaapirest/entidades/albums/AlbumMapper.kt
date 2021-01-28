package com.andressanchez.pruebaapirest.entidades.albums

object AlbumMapper {
    fun fromDTO(items: List<AlbumDTO>): List<Album> {
        return items.map { fromDTO(it) }
    }

    fun fromDTO(dto: AlbumDTO): Album {
        return Album(
            dto.userId,
            dto.id,
            dto.title
        )
    }

    fun toDTO(model: Album): AlbumDTO {
        return AlbumDTO(
            model.userId,
            model.id,
            model.title
        )
    }

}