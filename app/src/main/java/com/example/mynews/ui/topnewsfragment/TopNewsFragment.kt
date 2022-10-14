package com.example.mynews.ui.topnewsfragment

import androidx.fragment.app.Fragment
import com.example.mynews.FetchNewsListener
import com.example.mynews.R

class TopNewsFragment : Fragment(R.layout.fragment_top_news), FetchNewsListener {

    override fun onFetchData(query: String?) {

    }
}