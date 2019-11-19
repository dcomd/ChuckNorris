package com.alexandre.chucknorris.di

import com.alexandre.chucknorris.BaseApp
import dagger.Component

@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {

    fun inject(application: BaseApp)

}