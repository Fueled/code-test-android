package com.fueled.technicalchallenge.domain

import com.fueled.technicalchallenge.data.model.CharacterApiModel
import com.fueled.technicalchallenge.data.model.ImageApiModel
import com.fueled.technicalchallenge.data.model.ResourceApiModel
import com.fueled.technicalchallenge.data.model.ResourceItemsApiModel
import com.fueled.technicalchallenge.data.model.UrlApiModel
import com.fueled.technicalchallenge.domain.model.Character
import com.fueled.technicalchallenge.domain.model.Image
import com.fueled.technicalchallenge.domain.model.Resource
import com.fueled.technicalchallenge.domain.model.ResourceItems
import com.fueled.technicalchallenge.domain.model.ResourceType
import com.fueled.technicalchallenge.domain.model.Url
import com.fueled.technicalchallenge.domain.model.UrlType


internal fun UrlApiModel.toEntity() = Url(UrlType.fromString(type), url)
internal fun ResourceApiModel.toEntity() =
    Resource(resourceURI, name, ResourceType.fromString(type))

internal fun ResourceItemsApiModel.toEntity() =
    ResourceItems(available, returned, collectionURI, items.map { it.toEntity() })

internal fun ImageApiModel.toEntity() = Image(path, extension)
internal fun CharacterApiModel.toEntity() = Character(
    id,
    name,
    description,
    thumbnail.toEntity(),
    resourceURI,
    events.toEntity(),
    urls.map { it.toEntity() },
)
