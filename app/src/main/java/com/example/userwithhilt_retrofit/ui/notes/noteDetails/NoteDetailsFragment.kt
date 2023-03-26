package com.example.userwithhilt_retrofit.ui.notes.noteDetails

import androidx.fragment.app.Fragment
import com.example.userwithhilt_retrofit.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NoteDetailsFragment : Fragment(R.layout.fragment_note_details) {

//    @Inject
//    lateinit var requestManager: RequestManager

//    private var _binding: FragmentNoteDetailsBinding? = null
//    private val binding get() = _binding!!

   // private val viewModel: NotesViewModel by viewModels()

//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        _binding = FragmentNoteDetailsBinding.inflate(inflater, container, false);
//        binding.apply {
//            lifecycleOwner = this@NoteDetailsFragment
//        }
//        return binding.root
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        subscribeObservers()
//        getSelectedNoteFromPreviousFragment()
//    }
//
//    private fun subscribeObservers() {
//        viewModel.viewState.observe(viewLifecycleOwner) { state ->
//
////            state.note?.let { note ->
////                requestManager
////                    .load(note.featuredImage)
////                    .transition(DrawableTransitionOptions.withCrossFade())
////                    .into(binding.imageView)
////            }
//        }
//        viewModel.shouldDisplayProgressBar.observe(viewLifecycleOwner) {
//            //  displayProgressBar(it)
//        }
//    }

//    private fun getSelectedNoteFromPreviousFragment() {
//        arguments?.let { args ->
//            (args.getParcelable("note") as Note?)?.let { selectedNote ->
//                viewModel.setNote(selectedNote)
//            }
//        }
//    }
}
