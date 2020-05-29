package br.com.nakajimaphilippe.mvvmcoroutines.di

import br.com.nakajimaphilippe.mvvmcoroutines.ui.main.MainRepository
import br.com.nakajimaphilippe.mvvmcoroutines.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainModule = module {

    // Quando mais de um model precisar dessa dependência, podese utilizar single
    // Assim todos os models estarão com a mesma instância da dependência.
    factory {
        MainRepository()
    }

    viewModel {
        MainViewModel(repository = get())
    }
}