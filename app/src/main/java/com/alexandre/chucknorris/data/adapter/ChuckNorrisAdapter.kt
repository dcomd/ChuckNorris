package com.alexandre.chucknorris.data.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alexandre.chucknorris.R
import com.alexandre.chucknorris.data.response.CategoriesResponse
import kotlinx.android.synthetic.main.item_lista_categorias.view.*

class ChuckNorrisAdapter(
    val lista: List<CategoriesResponse>,
    val onClickListener: ((BodyZapItemsResponse: CategoriesResponse) -> Unit)
) :
    RecyclerView.Adapter<ChuckNorrisAdapter.ChuckNorrissViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChuckNorrissViewHolder {

        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_lista_categorias, parent, false)
        return ChuckNorrissViewHolder(view, onClickListener)

    }

    override fun getItemCount() = lista.count()

    override fun onBindViewHolder(holder: ChuckNorrissViewHolder, position: Int) {
        holder.bindView(lista[position])

    }


    inner class ChuckNorrissViewHolder(
        view: View,
        onClickListener: ((BodyZapItemsResponse: CategoriesResponse) -> Unit)
    ) : RecyclerView.ViewHolder(view) {

        val txtCategory = view.texCategory


        fun bindView(itemsResponse: CategoriesResponse) {

            txtCategory.text = itemsResponse.categories

            itemView.setOnClickListener {
                onClickListener.invoke(itemsResponse)
            }
        }
    }
}