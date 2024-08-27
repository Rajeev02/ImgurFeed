package io.github.rajeev02.imgurfeed.ui.feed

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import io.github.rajeev02.imgurfeed.databinding.FragmentFeedBinding

class FeedFragment : Fragment() {

    companion object {
        fun newInstance() = FeedFragment()
    }

    private val viewModel: FeedViewModel by viewModels()

    private val feedRecycleAdapter = FeedRecycleAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val feed = arguments?.getString("feed");
        viewModel.updateFeed(feed!!)
    }

    @SuppressLint("SuspiciousIndentation")
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