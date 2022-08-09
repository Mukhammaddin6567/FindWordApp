package uz.gita.findwordappMBF.app

import android.app.Application
import timber.log.Timber
import uz.gita.findwordappMBF.repository.Repository
import uz.gita.findwordappMBF.repository.local.MySharedPreferences

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        // init Timber
        val checkDebug = true
        if (checkDebug) Timber.plant(Timber.DebugTree())

        // init SharedPreferences
        MySharedPreferences.init(this)

        // init repository
        Repository.initRepository()
    }
}