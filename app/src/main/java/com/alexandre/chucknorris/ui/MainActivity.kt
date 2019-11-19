package com.alexandre.chucknorris.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.alexandre.chucknorris.BaseApp
import com.alexandre.chucknorris.DetalhesActivity
import com.alexandre.chucknorris.R
import com.alexandre.chucknorris.data.adapter.ChuckNorrisAdapter
import com.alexandre.chucknorris.data.repository.ChuckNorrisRepository
import com.alexandre.chucknorris.data.response.CategoriesResponse
import com.alexandre.chucknorris.di.ApplicationComponent
import com.alexandre.chucknorris.di.CategoryComponent
import com.alexandre.chucknorris.presenter.MainPresenter
import com.alexandre.chucknorris.ui.interfaces.ImainFunction
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), ImainFunction {

    val presenter = MainPresenter(this, ChuckNorrisRepository() )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        repository_progress.visibility = View.VISIBLE
        presenter.getCategories()
    }

    override fun getCategorias(lista: List<CategoriesResponse>) {
        lista?.let { chuckDados ->

            with(recicleChuck) {
                layoutManager = androidx.recyclerview.widget.LinearLayoutManager(
                    this@MainActivity,
                    androidx.recyclerview.widget.RecyclerView.VERTICAL,
                    false
                )
                setHasFixedSize(true)
                adapter = ChuckNorrisAdapter(chuckDados){
                    val intent: Intent =
                        Intent(
                            this@MainActivity,
                            DetalhesActivity::class.java
                        ).apply {
                            putExtra("categoryType", it.categories)
                        }
                    startActivity(intent)
                }
                repository_progress.visibility = android.view.View.GONE
            }
        }
    }

}
