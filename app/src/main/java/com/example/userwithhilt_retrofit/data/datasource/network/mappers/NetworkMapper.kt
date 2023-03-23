package com.example.userwithhilt_retrofit.data.datasource.network.mappers

import android.text.format.DateUtils
import com.example.userwithhilt_retrofit.data.datasource.network.model.NoteNetworkEntity
import com.example.userwithhilt_retrofit.domain.model.Note
import com.example.userwithhilt_retrofit.domain.util.EntityMapper
import java.util.*
import javax.inject.Inject

class NetworkMapper
@Inject
constructor(
): EntityMapper<NoteNetworkEntity, Note>
{

    fun entityListToNoteList(entities: List<NoteNetworkEntity>): List<Note>{
        val list: ArrayList<Note> = ArrayList()
        for(entity in entities){
            list.add(mapFromEntity(entity))
        }
        return list
    }
    override fun mapFromEntity(entity: NoteNetworkEntity): Note {
        return Note(
            id = entity.pk,
            title = entity.title,
            publisher = entity.publisher,
            featuredImage = entity.featuredImage,
            rating = entity.rating,
            sourceUrl = entity.sourceUrl,
            ingredients = entity.ingredients,
            dateAdded = Date(entity.longDateAdded),
            dateUpdated = Date(entity.longDateUpdated),
        )
    }

    override fun mapToEntity(domainModel: Note): NoteNetworkEntity {
        return NoteNetworkEntity(
            pk = domainModel.id,
            title = domainModel.title,
            publisher = domainModel.publisher,
            featuredImage = domainModel.featuredImage,
            rating = domainModel.rating,
            sourceUrl = domainModel.sourceUrl,
            ingredients = domainModel.ingredients,
            longDateAdded = (domainModel.dateAdded).time,
            longDateUpdated = (domainModel.dateUpdated).time,
        )
    }

}
