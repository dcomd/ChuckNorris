package com.alexandre.chucknorris

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.alexandre.chucknorris.data.adapter.ChuckJokesAdapter
import com.alexandre.chucknorris.data.repository.ChuckNorrisRepository
import com.alexandre.chucknorris.data.response.ChuckResultResponse
import com.alexandre.chucknorris.presenter.DetalhesPresenter
import com.alexandre.chucknorris.ui.interfaces.IdetalhesFunction
import kotlinx.android.synthetic.main.activity_main.*

class DetalhesActivity : AppCompatActivity(),IdetalhesFunction {


    val presenter = DetalhesPresenter(this, ChuckNorrisRepository() )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes)
        val query = intent.getStringExtra("categoryType")
        repository_progress.visibility = View.VISIBLE
        presenter.getCategories(query)
    }

    override fun getDetalhes(lista: List<ChuckResultResponse>) {
        lista?.let { chuckDados ->

            with(recicleChuck) {
                layoutManager = androidx.recyclerview.widget.LinearLayoutManager(
                    this@DetalhesActivity,
                    androidx.recyclerview.widget.RecyclerView.VERTICAL,
                    false
                )
                setHasFixedSize(true)
                adapter = ChuckJokesAdapter(chuckDados)
                repository_progress.visibility = android.view.View.GONE
            }
        }
    }
}
