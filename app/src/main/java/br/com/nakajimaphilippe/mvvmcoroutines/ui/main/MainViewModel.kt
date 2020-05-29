package br.com.nakajimaphilippe.mvvmcoroutines.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainViewModel(private val repository: MainRepository) : ViewModel() {

    val movieLiveData = MutableLiveData<List<Movie>>()

    fun getMovies() {
        repository.getMoviesCallback { movies ->
            movieLiveData.postValue(movies)
        }
    }

    class MainViewModelFactory(private val repository: MainRepository): ViewModelProvider.Factory {

        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return  MainViewModel(repository) as T
        }

    }

}