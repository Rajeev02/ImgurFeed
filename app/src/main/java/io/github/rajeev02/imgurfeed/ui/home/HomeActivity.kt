package io.github.rajeev02.imgurfeed.ui.home

import android.os.Bundle
import androidx.activity.viewModels
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import io.github.rajeev02.imgurfeed.R
import io.github.rajeev02.imgurfeed.databinding.ActivityMainBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val homeViewModel by viewModels<HomeViewModel>()
    private val storiesAdapter = HomeRecyclerAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


      binding.rvStoryFeed.apply {
          layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
          adapter = storiesAdapter
      }
        setupNav()
        homeViewModel.fetchTags()
    }


    private fun setupNav(){
        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
//        val appBarConfiguration = AppBarConfiguration(
//            setOf(
//                R.id.navigation_hot, R.id.navigation_top)
//        )
        //setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onResume() {
        super.onResume()
        homeViewModel.tags.observe(this){
            storiesAdapter.submitList(it)
        }
    }
}