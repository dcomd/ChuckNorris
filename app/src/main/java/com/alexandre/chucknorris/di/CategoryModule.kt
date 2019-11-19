package com.alexandre.chucknorris.di

import android.app.Activity
import com.alexandre.chucknorris.data.repository.ChuckNorrisRepository
import com.alexandre.chucknorris.presenter.MainPresenter
import com.alexandre.chucknorris.ui.interfaces.ImainFunction
import dagger.Module
import dagger.Provides


@Module
class ActivityModule(private var activity: Activity) {

    @Provides
    fun provideActivity(): Activity {
        return activity
    }

    @Provides
    fun providePresenter(view: ImainFunction, repository: ChuckNorrisRepository): MainPresenter {
        return MainPresenter(view, repository)
    }
}

