package cl.anchorbooks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import cl.anchorbooks.databinding.FragmentListingBinding

class ListingFragment: Fragment(){
    private lateinit var binding: FragmentListingBinding
    private val viewModel: BookViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListingBinding.inflate(layoutInflater)
        binding.rvBooksList.layoutManager = LinearLayoutManager(context)
        val adapter = BookAdapter()
        binding.rvBooksList.adapter = adapter

        adapter.selectedItem().observe(viewLifecycleOwner, {
            viewModel.selected(it)
            activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.main_container, DetailFragment())?.addToBackStack("fragmentDetail")?.commit()

        })
        viewModel.books().observe(viewLifecycleOwner, {
            adapter.update(it)
        })
        return binding.root
    }
}