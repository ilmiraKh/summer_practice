package com.example.myapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.myapp.databinding.FragmentMainBinding
import kotlin.random.Random

class MainFragment : Fragment(R.layout.fragment_main) {
    private var binding: FragmentMainBinding? = null
    private var adapter: KikorikAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainBinding.bind(view)

        initAdapter()

        val itemDecorator = DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
        itemDecorator.setDrawable(context?.getDrawable(R.drawable.divide)!!)
        binding?.rvKikorik?.addItemDecoration(itemDecorator)

        binding?.tvName?.setOnClickListener {
            adapter?.updateDataset(
                KikorikRepository.list.subList(0, Random.nextInt(8))
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    private fun initAdapter() {
        adapter = KikorikAdapter(
            list = KikorikRepository.list,
            glide = Glide.with(this),
            onItemClick = {kikorik ->
                findNavController().navigate(R.id.action_mainFragment_to_infoFragment,
                    InfoFragment.createBundle(kikorik.id))
            }
        )
        binding?.rvKikorik?.adapter = adapter
        binding?.rvKikorik?.layoutManager = LinearLayoutManager(requireContext())
    }
}
