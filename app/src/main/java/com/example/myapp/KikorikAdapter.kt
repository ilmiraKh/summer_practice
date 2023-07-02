package com.example.myapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.myapp.databinding.ItemKikorikBinding

class KikorikAdapter (
    private var list: List<Kikorik>,
    private val glide: RequestManager,
    private val onItemClick: (Kikorik) -> Unit) : RecyclerView.Adapter<KikorikItem>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
        KikorikItem = KikorikItem(binding = ItemKikorikBinding.inflate(LayoutInflater.from(parent.context)),
        glide = glide, onItemClick = onItemClick)

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: KikorikItem, position: Int) {
        holder.onBind(list[position])
    }

    fun updateDataset(newList: List<Kikorik>) {
        list = newList
        notifyDataSetChanged()
    }
}
