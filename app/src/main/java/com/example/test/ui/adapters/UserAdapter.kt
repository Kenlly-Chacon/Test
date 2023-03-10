package com.example.test.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.test.R
import com.example.test.databinding.CountriesRvBinding
import com.example.test.model.entities.api.Countries
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso

class UserAdapter(private val itemClick : (Countries) -> Unit) :

    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    var dataList: List<Countries> = emptyList()

    class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private var binding: CountriesRvBinding = CountriesRvBinding.bind(view)

        fun render(item: Countries, itemClick : (Countries) -> Unit) {
            binding.txtV1.text = item.alternateName
            binding.txtV2.text = item.country
            Picasso.get().load("https://countryflagsapi.com/png/" + item.alternateName)
                .into(binding.countryImage);

//           para solo uno un seccion
            /* binding.countryImage.setOnClickListener(){
                itemClick(item)
            }*/

            //Para todo el elemento
            itemView.setOnClickListener{
                itemClick(item)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return UserViewHolder(inflater.inflate(R.layout.countries_rv, parent, false))
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.render(dataList[position], itemClick)
    }

    override fun getItemCount(): Int = dataList.size

}