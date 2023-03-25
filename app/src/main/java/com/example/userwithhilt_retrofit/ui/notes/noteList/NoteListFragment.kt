package com.example.userwithhilt_retrofit.ui.notes.noteList

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.userwithhilt_retrofit.R
import com.example.userwithhilt_retrofit.ui.UIController
import com.example.userwithhilt_retrofit.ui.notes.NotesStateEvent
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NoteListFragment : Fragment(R.layout.fragment_note_list) {

    lateinit var uiController: UIController
    private val viewModel: NotesListViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeObservers()
        viewModel.onTriggerEvent(NotesStateEvent.GetNotesEvent)
    }

    private fun subscribeObservers() {
        viewModel.viewState.observe(viewLifecycleOwner) { state ->

            state.listOfNotes?.let {
                print("Wojtas $state")
            }

            state.note?.let {
                print("Wojtas $state")
            }
        }
        viewModel.shouldDisplayProgressBar.observe(viewLifecycleOwner) {
            displayProgressBar(it)
        }
    }

    private fun displayProgressBar(isDisplayed: Boolean) {
        uiController.displayProgressBar(isDisplayed)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            uiController = context as UIController
        } catch (e: ClassCastException) {
            e.printStackTrace()
        }
    }
}
