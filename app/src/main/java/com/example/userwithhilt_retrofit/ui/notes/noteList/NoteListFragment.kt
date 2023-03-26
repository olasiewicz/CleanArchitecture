package com.example.userwithhilt_retrofit.ui.notes.noteList

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.RequestManager
import com.example.userwithhilt_retrofit.R
import com.example.userwithhilt_retrofit.databinding.FragmentNoteListBinding
import com.example.userwithhilt_retrofit.domain.model.Note
import com.example.userwithhilt_retrofit.ui.UIController
import com.example.userwithhilt_retrofit.ui.notes.NotesListViewModel
import com.example.userwithhilt_retrofit.ui.notes.NotesStateEvent
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class NoteListFragment : Fragment() {

    @Inject
    lateinit var requestManager: RequestManager
    lateinit var recyclerAdapter: NotesListAdapter
    lateinit var uiController: UIController

    private var _binding: FragmentNoteListBinding? = null
    private val binding get() = _binding!!

    private val viewModel: NotesListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNoteListBinding.inflate(inflater, container, false);
        binding.apply {
            lifecycleOwner = this@NoteListFragment
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        subscribeObservers()
        viewModel.onTriggerEvent(NotesStateEvent.GetNotesEvent)
    }

    private fun initRecyclerView() {

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@NoteListFragment.context)
            // val topSpacingDecorator = TopSpacingItemDecoration(30)
            // removeItemDecoration(topSpacingDecorator) // does nothing if not applied already
            // addItemDecoration(topSpacingDecorator)

            recyclerAdapter = NotesListAdapter(requestManager, ::listItemClicked)
//            addOnScrollListener(object: RecyclerView.OnScrollListener(){
//
//                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
//                    super.onScrollStateChanged(recyclerView, newState)
//                    val layoutManager = recyclerView.layoutManager as LinearLayoutManager
//                    val lastPosition = layoutManager.findLastVisibleItemPosition()
//                    if (lastPosition == recyclerAdapter.itemCount.minus(1)) {
//                        Log.d(TAG, "BlogFragment: attempting to load next page...")
//                        viewModel.nextPage()
//                    }
//                }
//            })
            adapter = recyclerAdapter
        }
    }

    private fun subscribeObservers() {
        viewModel.viewState.observe(viewLifecycleOwner) { state ->

            state.listOfNotes?.let { notesList ->
                print("Wojtas $state")
                recyclerAdapter.submitList(notesList)
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

    private fun listItemClicked(note: Note){
        navigateToDetailsFragment(note)

    }

        private fun navigateToDetailsFragment(note: Note) {
            val bundle = bundleOf("note" to note)
        findNavController().navigate(
            R.id.action_noteListFragment_to_noteDetailsFragment,
            bundle
        )
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            uiController = context as UIController
        } catch (e: ClassCastException) {
            e.printStackTrace()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
