package com.example.userwithhilt_retrofit.ui.notes.noteList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.userwithhilt_retrofit.data.datasource.cache.mapers.CacheMapper
import com.example.userwithhilt_retrofit.databinding.UserListItemBinding
import com.example.userwithhilt_retrofit.domain.model.Note
import com.example.userwithhilt_retrofit.ui.notes.noteList.NotesListAdapter.CustomViewHolder

class NotesListAdapter(
    private val requestManager: RequestManager,
    private val cacheMapper: CacheMapper,
    private val clickListener:(Note)->Unit
) : ListAdapter<Note, CustomViewHolder>(NoteItemDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): CustomViewHolder {
        val binding =
            UserListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CustomViewHolder(binding, requestManager)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.bindTo(getItem(position), cacheMapper, clickListener)
    }

    class CustomViewHolder(
        val binding: UserListItemBinding,
        val requestManager: RequestManager
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bindTo(note: Note, cacheMapper: CacheMapper, clickListener: (Note) -> Unit) {
            binding.apply {
                requestManager
                    .load(note.featuredImage)
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .into(recipeImage)
                recipeTitle.text = note.title
                recipePublisher.text = cacheMapper.convertIngredientListToString(note.ingredients)

                //setVariable(model, note)
               // binding.executePendingBindings()
                root.setOnClickListener {
                    clickListener(note)
                }
            }
        }
    }

    class NoteItemDiffCallback : DiffUtil.ItemCallback<Note>() {
        override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean = oldItem == newItem

        override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean = oldItem == newItem

    }
}
