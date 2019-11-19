package com.alexandre.chucknorris.data.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alexandre.chucknorris.R
import com.alexandre.chucknorris.data.response.CategoriesResponse
import com.alexandre.chucknorris.data.response.ChuckJokesResponse
import com.alexandre.chucknorris.data.response.ChuckResultResponse
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_detalhes_categories.view.*
import kotlinx.android.synthetic.main.item_lista_categorias.view.*

class ChuckJokesAdapter(
    val lista: List<ChuckResultResponse>
) :
    RecyclerView.Adapter<ChuckJokesAdapter.ChuckJokesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChuckJokesViewHolder {

        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_detalhes_categories, parent, false)
        return ChuckJokesViewHolder(view)

    }

    override fun getItemCount() = lista.count()

    override fun onBindViewHolder(holder: ChuckJokesViewHolder, position: Int) {
        holder.bindView(lista[position])

    }


    inner class ChuckJokesViewHolder(
        view: View
    ) : RecyclerView.ViewHolder(view) {

        val txtFrase = view.txtFrase
        val txtUrl = view.txtUrl
        val txtimg = view.imgCategoria


        fun bindView(itemsResponse: ChuckResultResponse) {

            txtFrase.text = itemsResponse.value
            txtUrl.text = itemsResponse.url


            Picasso.with(itemView.context)
                .load(itemsResponse.icon_url)
                .into(txtimg)
        }
    }
}