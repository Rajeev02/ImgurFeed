package io.github.rajeev02.imgurfeed.ui.feed

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import io.github.rajeev02.imgurfeed.databinding.FragmentFeedBinding

class FeedFragment : Fragment() {

    companion object {
        fun newInstance() = FeedFragment()
    }

    private val viewModel: FeedViewModel by activityViewModels()

    private val feedRecycleAdapter = FeedRecycleAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val feed = arguments?.getString("feed");
        viewModel.updateFeed(feed!!)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentFeedBinding.inflate(inflater, container, false)
        binding.rvGalleryFeed.layoutManager = LinearLayoutManager(requireContext())
      binding.rvGalleryFeed.adapter = feedRecycleAdapter

        viewModel.feed.observe(viewLifecycleOwner){
            feedRecycleAdapter.submitList(it)
//            binding.tvFeedType.text = it?.toString()
//            Log.d("DATA", it.toString())
//            Toast.makeText(requireContext(), "Downloaded ${it} images", Toast.LENGTH_LONG).show()
        }
        return binding.root;
    }
}