package com.example.myapp

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.myapp.databinding.ItemKikorikBinding

class KikorikItem (
    private val binding: ItemKikorikBinding,
    private val glide: RequestManager,
    private val onItemClick: (Kikorik) -> Unit) : RecyclerView.ViewHolder(binding.root) {

    private val options: RequestOptions = RequestOptions
        .diskCacheStrategyOf(DiskCacheStrategy.NONE)

    fun onBind(kikorik: Kikorik){
        binding.run{
            tvName.text = kikorik.name

            var main = "второстепенный герой"
            when{kikorik.main -> main = "главный герой"}
            tvMain.text = main

            root.setOnClickListener {
                onItemClick(kikorik)
            }
        }
    }
}
