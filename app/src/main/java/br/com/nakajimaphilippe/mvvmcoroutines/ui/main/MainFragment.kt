package br.com.nakajimaphilippe.mvvmcoroutines.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import br.com.nakajimaphilippe.mvvmcoroutines.R
import kotlinx.android.synthetic.main.main_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val viewModel: MainViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.movieLiveData.observe(viewLifecycleOwner, Observer { movies ->
            val allTitles = StringBuilder()
            movies.map { movie ->
                allTitles.append(movie.id).append(" - ").append(movie.title).append("\n")
            }
            tfMovies.text = allTitles.toString()
            progressBar.visibility = View.GONE
            containerText.visibility = View.VISIBLE
        })

        //viewModel.getMovies()
        viewModel.getMoviesCoroutines()

    }

}