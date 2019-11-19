package com.alexandre.chucknorris

import android.app.Application
import com.alexandre.chucknorris.di.ApplicationComponent
import com.alexandre.chucknorris.di.ApplicationModule
import com.alexandre.chucknorris.di.DaggerApplicationComponent

class BaseApp : Application() {

    lateinit var component: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        instance = this
        setup()

        if (BuildConfig.DEBUG) {
            // Maybe TimberPlant etc.
        }
    }

    fun setup() {
        component = DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this)).build()
        component.inject(this)
    }

    fun getApplicationComponent(): ApplicationComponent {
        return component
    }

    companion object {
        lateinit var instance: BaseApp private set
    }
}