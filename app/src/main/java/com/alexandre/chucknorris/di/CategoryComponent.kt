package com.alexandre.chucknorris.di

import com.alexandre.chucknorris.ui.MainActivity
import dagger.Component



@Component(modules = arrayOf(ActivityModule::class))
interface CategoryComponent {

    fun inject(mainActivity: MainActivity)

}