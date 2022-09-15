package com.example.mynews.ui.newsfragment

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.mynews.R
import com.example.mynews.databinding.FragmentNewsBinding
import com.example.mynews.ui.MainViewModel

class NewsFragment : Fragment(R.layout.fragment_news) {

    private lateinit var binding: FragmentNewsBinding
    private val viewModel by activityViewModels<MainViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentNewsBinding.bind(view)
        binding.btn.setOnClickListener {
//            val calendar = CalendarPicker()
//            calendar.invoke(parentFragmentManager, "TAG"){
//
//            }
           // viewModel.fetchTopNews()
        }


    }

}