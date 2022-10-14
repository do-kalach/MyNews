package com.example.mynews

import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuProvider

class CustomMenuProvider(private val fetchNewsListener: FetchNewsListener) : MenuProvider {

    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.menu_search, menu)

        val itemView = menu.findItem(R.id.action_search)
        val searchView = itemView.actionView as SearchView
        searchView.let { searchView ->
            searchView.queryHint = searchView.context.getString(R.string.search_in_everything)
            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    fetchNewsListener.onFetchData(query)
                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    return false
                }
            })
            searchView.isSubmitButtonEnabled = true
        }
    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        return true
    }
}

interface FetchNewsListener {
    fun onFetchData(query: String?)
}