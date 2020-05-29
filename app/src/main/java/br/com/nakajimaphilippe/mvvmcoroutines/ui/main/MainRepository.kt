package br.com.nakajimaphilippe.mvvmcoroutines.ui.main

class MainRepository {

    fun getMoviesCallback(callback: (movies: List<Movie>) -> Unit) {
        Thread(Runnable {
            Thread.sleep(3000)
            callback.invoke(
                listOf(
                    Movie(1, "Titulo 1"),
                    Movie(1, "Titulo 2")
                )
            )
        }).start()
    }

}