package io.github.rajeev02.imgurfeed

import androidx.fragment.app.viewModels
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import io.github.rajeev02.imgurfeed.databinding.FragmentFeedBinding
import io.github.rajeev02.imgurlib.models.Image

class FeedFragment : Fragment() {

    companion object {
        fun newInstance() = FeedFragment()
    }

    private val viewModel: FeedViewModel by activityViewModels()

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
        viewModel.feed.observe(viewLifecycleOwner){
            Log.d("DATA", it.toString())
            Toast.makeText(requireContext(), "Downloaded ${it} images", Toast.LENGTH_LONG).show()
        }
        return binding.root;
    }
}