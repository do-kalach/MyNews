package com.example.mynews.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.mynews.FetchNewsListener
import com.example.mynews.ui.newsfragment.MainNewsFragment
import com.example.mynews.ui.newsfragment.NewsFragment
import com.example.mynews.ui.topnewsfragment.TopNewsFragment

class ViewPagerAdapter(fragmentActivity: FragmentActivity, private val listFragment:List<Fragment>) :
    FragmentStateAdapter(fragmentActivity) {

    private var currentFragment: Fragment = listFragment[0]

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                currentFragment = listFragment[0]
                listFragment[0]
            }
            1 -> {
               currentFragment = listFragment[1]
                return listFragment[1]
            }
            else -> {
               currentFragment = listFragment[0]
                return listFragment[0]
            }
        }
    }

    fun currentFragment(): FetchNewsListener = currentFragment as FetchNewsListener

}