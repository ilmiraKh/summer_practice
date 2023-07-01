package com.example.myapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.myapp.databinding.FragmentOneBinding

class OneFragment : Fragment(R.layout.fragment_one) {
    private var binding: FragmentOneBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentOneBinding.bind(view)

        binding?.run{
            btnToEnd.setOnClickListener{
                findNavController().navigate(R.id.action_oneFragment_to_mainFragment,
                MainFragment.createBundle("начальную страницу"))
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
