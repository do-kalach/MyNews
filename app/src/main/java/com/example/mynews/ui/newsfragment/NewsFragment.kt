package com.example.mynews.ui.newsfragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.domain.data.NetworkResult
import com.example.domain.news.entitie.News
import com.example.mynews.R
import com.example.mynews.adapter.NewsAdapter
import com.example.mynews.databinding.FragmentNewsBinding
import com.example.mynews.network.ConnectionLiveData
import com.example.mynews.ui.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class NewsFragment : Fragment(R.layout.fragment_news), NewsAdapter.SetOnClickListener {

    private lateinit var binding: FragmentNewsBinding
    private val viewModel by activityViewModels<MainViewModel>()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentNewsBinding.bind(view)
        val connectivityLiveData = ConnectionLiveData(requireContext())
        val newsAdapter = NewsAdapter(this)
        connectivityLiveData.observe(viewLifecycleOwner) { connectivity ->
            if (connectivity) {
                lifecycleScope.launch {
                    viewModel.fetchNews("bitcoin")
                        .flowOn(Dispatchers.IO)
                        .collectLatest { result ->
                            when (result) {
                                is NetworkResult.Success -> {
                                    binding.progressDialog.visibility = View.GONE
                                    newsAdapter.submitList(result.value)
                                }
                                is NetworkResult.Loading -> {
                                    binding.progressDialog.visibility = View.VISIBLE
                                }
                                else -> {}
                            }
                        }
                }
            }
        }

        binding.recyclerView.adapter = newsAdapter

    }


    override fun onClickListener(news: News) {
        findNavController().navigate(
            NewsFragmentDirections.actionNewsFragmentToDetailsNewsFragment(
                news
            )
        )
    }

}