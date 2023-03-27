package com.example.userwithhilt_retrofit.ui.notes.noteDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.userwithhilt_retrofit.R
import com.example.userwithhilt_retrofit.databinding.FragmentNoteDetailsBinding
import com.example.userwithhilt_retrofit.domain.model.Note
import com.example.userwithhilt_retrofit.ui.notes.NotesViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class NoteDetailsFragment : Fragment(R.layout.fragment_note_details) {

    @Inject
    lateinit var requestManager: RequestManager

    private var _binding: FragmentNoteDetailsBinding? = null
    private val binding get() = _binding!!

    private val viewModel: NotesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNoteDetailsBinding.inflate(inflater, container, false);
        binding.apply {
            lifecycleOwner = this@NoteDetailsFragment
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // subscribeObservers()
        getSelectedNoteFromPreviousFragment()
    }

//    private fun subscribeObservers() {
//        viewModel.viewState.observe(viewLifecycleOwner) { state ->
//
//            state.note?.let { note ->
//                requestManager
//                    .load(note.featuredImage)
//                    .transition(DrawableTransitionOptions.withCrossFade())
//                    .into(binding.imageView)
//            }
//        }
//        viewModel.shouldDisplayProgressBar.observe(viewLifecycleOwner) {
//            //  displayProgressBar(it)
//        }
//    }

    private fun getSelectedNoteFromPreviousFragment() {
        val note = arguments?.let { args ->
            (args.getParcelable("note") as Note?)
        }

        binding.apply {
            requestManager
                .load(note?.featuredImage)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(imageView)
            textView.text = note?.publisher
        }

    }

}
