package com.nabiha.artikel.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nabiha.artikel.databinding.AdapterArtikelBinding
import com.nabiha.artikel.model.ArtikelModel

class ArtikelAdapter(
    var items: ArrayList<ArtikelModel>,
    var listener: AdapterListener,
): RecyclerView.Adapter<ArtikelAdapter.ViewHolder>() {
    class ViewHolder(val binding: AdapterArtikelBinding): RecyclerView.ViewHolder( binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder (
        AdapterArtikelBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.binding.title.text = item.title
        holder.binding.imageView.setImageResource(item.image)
        holder.binding.desc.text = item.desc
        holder.binding.selengkapnya.setOnClickListener {
            listener.onDetail(item)
        }
        holder.itemView.setOnClickListener {
            listener.onDetail(item)
        }
    }
    override fun getItemCount() = items.size

    interface AdapterListener{
        fun onDetail(taskModel: ArtikelModel)
    }
}