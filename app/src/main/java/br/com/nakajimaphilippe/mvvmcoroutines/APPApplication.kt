package br.com.nakajimaphilippe.mvvmcoroutines

import android.app.Application
import br.com.nakajimaphilippe.mvvmcoroutines.di.mainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class APPApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidLogger()
            androidContext(this@APPApplication)
            modules(mainModule)
        }

    }

}