package com.example.mynews.ui.newsfragment

import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.mynews.FetchNewsListener
import com.example.mynews.R
import com.example.mynews.ui.MainViewModel


class MainNewsFragment : Fragment(R.layout.fragment_main_news), FetchNewsListener {

    private val viewModel by activityViewModels<MainViewModel>()

    override fun onFetchData(query: String?) {
        viewModel.fetchNews(query)
    }
}