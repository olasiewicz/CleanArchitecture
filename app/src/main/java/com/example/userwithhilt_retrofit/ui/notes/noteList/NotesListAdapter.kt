package com.example.userwithhilt_retrofit.ui.notes.noteList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.userwithhilt_retrofit.databinding.UserListItemBinding
import com.example.userwithhilt_retrofit.domain.model.Note
import com.example.userwithhilt_retrofit.ui.notes.noteList.NotesListAdapter.CustomViewHolder

class NotesListAdapter(
    private val requestManager: RequestManager
) : ListAdapter<Note, CustomViewHolder>(NoteItemDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): CustomViewHolder {
        val binding =
            UserListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CustomViewHolder(binding, requestManager)

    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.bindTo(getItem(position))
    }

    class CustomViewHolder(
        val binding: UserListItemBinding,
        val requestManager: RequestManager
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bindTo(note: Note) {
            binding.apply {
                requestManager
                    .load(note.featuredImage)
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .into(recipeImage)
                //setVariable(model, note)
               // binding.executePendingBindings()
            }
        }
    }

    class NoteItemDiffCallback : DiffUtil.ItemCallback<Note>() {
        override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean = oldItem == newItem

        override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean = oldItem == newItem

    }
}
