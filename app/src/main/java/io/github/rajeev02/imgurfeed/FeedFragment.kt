package io.github.rajeev02.imgurfeed

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class FeedFragment : Fragment() {

    companion object {
        fun newInstance() = FeedFragment()
    }

    private val viewModel: FeedViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val feed = arguments?.getString("feed");

        val rootView =  inflater.inflate(R.layout.fragment_feed, container, false);
        feed?.let {
            rootView.findViewById<TextView>(R.id.tvFeedType).text = it
        }


        return rootView;
    }
}