package com.example.mynews.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mynews.CustomMenuProvider
import com.example.mynews.DataStorePreferences
import com.example.mynews.R
import com.example.mynews.adapter.MenuAdapter
import com.example.mynews.adapter.ViewPagerAdapter
import com.example.mynews.databinding.ActivityMain2Binding
import com.example.mynews.ui.newsfragment.MainNewsFragment
import com.example.mynews.ui.topnewsfragment.TopNewsFragment
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val dataStore by lazy { DataStorePreferences(this) }

        binding = ActivityMain2Binding.inflate(layoutInflater).also {
            setContentView(it.root)
        }


        val fragment1 = MainNewsFragment()
        val fragment2 = TopNewsFragment()
        val listFragment = listOf<Fragment>(fragment1, fragment2)

        val menuAdapter = MenuAdapter(object : MenuAdapter.OnClickListener {
            override fun onClick(position: Int) {
                Toast.makeText(this@MainActivity, position.toString(), Toast.LENGTH_LONG).show()
            }

        })
        binding.headMenu.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.headMenu.adapter = menuAdapter

        val adapter = ViewPagerAdapter(this, listFragment)

        binding.toolbar.addMenuProvider(CustomMenuProvider(adapter.currentFragment()))

        binding.viewPager2.adapter = adapter

        TabLayoutMediator(
            binding.tabLayout, binding.viewPager2
        ) { tab, position ->
            when (position) {
                0 -> tab.text = getString(R.string.news)
                1 -> tab.text = getString(R.string.top_news)
            }
        }.attach()

    }
}