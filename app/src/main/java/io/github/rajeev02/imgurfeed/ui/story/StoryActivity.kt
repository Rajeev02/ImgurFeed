package io.github.rajeev02.imgurfeed.ui.story

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import io.github.rajeev02.imgurfeed.R
import io.github.rajeev02.imgurfeed.databinding.ActivityStoryBinding

class StoryActivity : AppCompatActivity() {

    private val storyViewModel by viewModels<StoryViewModel>()
    private lateinit var _binding: ActivityStoryBinding
    private val storyPagerAdapter = StoryPagerAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        _binding = ActivityStoryBinding.inflate(layoutInflater)
        setContentView(_binding.root) // Corrected line

        ViewCompat.setOnApplyWindowInsetsListener(_binding.main) { v, insets -> // Accessing the binding's view directly
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val tagName = intent.getStringExtra("tag")
        tagName?.let {
            Log.d("StoryActivity", "Tag name: $it")
            storyViewModel.fetchTagGallery(it)
        }

        _binding.storyViewPager.adapter = storyPagerAdapter
    }

    override fun onResume() {
        super.onResume()
        storyViewModel.images.observe(this) {
            storyPagerAdapter.submitList(it)
        }
    }
}
