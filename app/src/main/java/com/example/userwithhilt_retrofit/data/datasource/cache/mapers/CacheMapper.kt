package com.example.userwithhilt_retrofit.data.datasource.cache.mapers

import com.example.userwithhilt_retrofit.data.datasource.cache.model.NoteCacheEntity
import com.example.userwithhilt_retrofit.data.datasource.network.model.NoteNetworkEntity
import com.example.userwithhilt_retrofit.domain.model.Note
import com.example.userwithhilt_retrofit.domain.util.EntityMapper
import java.util.*
import javax.inject.Inject

class CacheMapper
@Inject
constructor(
): EntityMapper<NoteCacheEntity, Note>
{
    override fun mapFromEntity(entity: NoteCacheEntity): Note {
        return Note(
            id = entity.id,
            title = entity.title,
            publisher = entity.publisher,
            featuredImage = entity.featuredImage,
            rating = entity.rating,
            sourceUrl = entity.sourceUrl,
            ingredients = convertIngredientsToList(entity.ingredients),
            dateAdded = Date(entity.dateAdded),
            dateUpdated = Date(entity.dateUpdated),
        )
    }

    override fun mapToEntity(domainModel: Note): NoteCacheEntity {
        return NoteCacheEntity(
            id = domainModel.id,
            title = domainModel.title,
            publisher = domainModel.publisher,
            featuredImage = domainModel.featuredImage,
            rating = domainModel.rating,
            sourceUrl = domainModel.sourceUrl,
            ingredients = convertIngredientListToString(domainModel.ingredients),
            dateAdded = (domainModel.dateAdded).time,
            dateUpdated = (domainModel.dateUpdated).time,
            dateCached = (domainModel.dateUpdated).time
        )
    }

    private fun convertIngredientListToString(ingredients: List<String>): String {
        val ingredientsString = StringBuilder()
        for(ingredient in ingredients){
            ingredientsString.append("$ingredient,")
        }
        return ingredientsString.toString()
    }

    private fun convertIngredientsToList(ingredientsString: String?): List<String>{
        val list: ArrayList<String> = ArrayList()
        ingredientsString?.let {
            for(ingredient in it.split(",")){
                list.add(ingredient)
            }
        }
        return list
    }
}