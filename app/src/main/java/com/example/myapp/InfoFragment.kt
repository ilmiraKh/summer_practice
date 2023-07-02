package com.example.myapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.myapp.databinding.FragmentInfoBinding
import com.example.myapp.databinding.FragmentMainBinding

class InfoFragment : Fragment(R.layout.fragment_info) {
    private var binding: FragmentInfoBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentInfoBinding.bind(view)

        makeInfo(view)
    }

    fun makeInfo(view: View){
        binding?.run{
            var kik = findById()
            tvId.text = "ID: " + kik?.id
            tvName.text = kik?.name

            var main = "второстепенный герой"
            when{kik?.main == true -> main = "главный герой"}
            tvMain.text = main

            tvDesc.text = kik?.description

            Glide.with(view).load(kik?.url)
                .placeholder(R.drawable.loading)
                .error(R.drawable.error)
                .apply(options)
                .into(ivImage)
        }
    }

    private val options: RequestOptions = RequestOptions
        .diskCacheStrategyOf(DiskCacheStrategy.NONE)

    fun findById(): Kikorik? {
        val id = arguments?.getInt(ID)
        for (el in KikorikRepository.list){
            if (el.id == id) return el
        }
        return null
    }

    companion object {
        private val ID = "ID"
        fun createBundle(id: Int): Bundle {
            val bundle = Bundle()
            bundle.putInt(ID, id)
            return bundle
        }
    }
}
