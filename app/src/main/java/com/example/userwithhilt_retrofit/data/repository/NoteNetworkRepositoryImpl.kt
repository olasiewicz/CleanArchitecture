package com.example.userwithhilt_retrofit.data.repository

import com.example.userwithhilt_retrofit.data.datasource.cache.NoteDao
import com.example.userwithhilt_retrofit.data.datasource.cache.mapers.CacheMapper
import com.example.userwithhilt_retrofit.data.datasource.network.UserApiService
import com.example.userwithhilt_retrofit.data.datasource.network.mappers.NetworkMapper
import com.example.userwithhilt_retrofit.domain.model.Note
import com.example.userwithhilt_retrofit.domain.repository.NoteNetworkRepository
import com.example.userwithhilt_retrofit.domain.util.DataState
import com.example.userwithhilt_retrofit.ui.notes.NotesViewState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class NoteNetworkRepositoryImpl(
    private val service: UserApiService,
    private val dao: NoteDao,
    private val networkMapper: NetworkMapper,
    private val cacheMapper: CacheMapper
) : NoteNetworkRepository {
    override fun getNotes(
        token: String,
        page: Int,
        query: String,
    ): Flow<DataState<NotesViewState>> = flow {

//        try {
//            emit(DataState.loading())
//        } catch (e: Exception) {
//            emit(DataState.error(e.message ?: "Unknown Error"))
//        }
//
//        try {
//            // Convert: NetworkRecipeEntity -> Recipe -> RecipeCacheEntity
//            val recipes = getRecipesFromNetwork(
//                token = token,
//                page = page,
//                query = query,
//            )
//
//            emit(
//                DataState.success(
//                    NotesViewState(
//                        listOfNotes = recipes
//                    )
//                )
//            )
//
//            // insert into cache
//            //   recipeDao.insertRecipes(entityMapper.toEntityList(recipes))
//        } catch (e: Exception) {
//            // There was a network issue
//            e.printStackTrace()
//        }


//        emit(
//            DataState.success(
//                NotesViewState(
//                    listOfNotes = recipes
//                )
//            )
//        )


        try {
            emit(DataState.loading())

            try {
                // Convert: NetworkRecipeEntity -> Recipe -> RecipeCacheEntity
                val recipes = getRecipesFromNetwork(
                    token = token,
                    page = page,
                    query = query,
                )

                // insert into cache
                dao.insertNotes(cacheMapper.noteListToEntityList(recipes))
            } catch (e: Exception) {
                e.printStackTrace()
            }

            // query the cache
            val cacheResult = dao.getNotes()

            // emit List<Recipe> from cache
            val list = cacheMapper.entityListToNoteList(cacheResult)

            emit(
                DataState.success(
                    NotesViewState(
                        listOfNotes = list,
                        message = "SUCCESS"
                    )
                )
            )
        } catch (e: Exception) {
            emit(
                DataState.error(
                    message = "ERROR"
                )
            )
        }
    }

    // WARNING: This will throw exception if there is no network connection
    private suspend fun getRecipesFromNetwork(
        token: String,
        page: Int,
        query: String
    ): List<Note> {
        return networkMapper.entityListToNoteList(
            service.search(
                token = token,
                page = page,
                query = query,
            ).recipes
        )

    }


    override suspend fun getNoteById(id: Int): Note? {
        TODO("Not yet implemented")
    }

    override suspend fun insertNote(note: Note) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteNote(note: Note) {
        TODO("Not yet implemented")
    }


}

//
//fun execute(
//    token: String,
//    page: Int,
//    query: String,
//): Flow<DataState<List<Recipe>>> = flow {
//    try {
//        emit(DataState.loading())
//
//        // just to show pagination, api is fast
////      delay(1000)
//
//        // force error for testing
//        if (query == "error") {
//            throw Exception("Search FAILED!")
//        }
//
//        try {
//            // Convert: NetworkRecipeEntity -> Recipe -> RecipeCacheEntity
//            val recipes = getRecipesFromNetwork(
//                token = token,
//                page = page,
//                query = query,
//            )
//
//            // insert into cache
//            recipeDao.insertRecipes(entityMapper.toEntityList(recipes))
//        } catch (e: Exception) {
//            // There was a network issue
//            e.printStackTrace()
//        }
//
//        // query the cache
//        val cacheResult = if (query.isBlank()) {
//            recipeDao.getAllRecipes(
//                pageSize = RECIPE_PAGINATION_PAGE_SIZE,
//                page = page
//            )
//        } else {
//            recipeDao.searchRecipes(
//                query = query,
//                pageSize = RECIPE_PAGINATION_PAGE_SIZE,
//                page = page
//            )
//        }
//
//        // emit List<Recipe> from cache
//        val list = entityMapper.fromEntityList(cacheResult)
//
//        emit(DataState.success(list))
//    } catch (e: Exception) {
//        emit(DataState.error<List<Recipe>>(e.message ?: "Unknown Error"))
//    }
//}


