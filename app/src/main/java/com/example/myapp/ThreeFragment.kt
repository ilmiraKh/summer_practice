package com.example.myapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myapp.databinding.FragmentOneBinding
import com.example.myapp.databinding.FragmentThreeBinding

class ThreeFragment : Fragment(R.layout.fragment_three) {
    private var binding: FragmentThreeBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentThreeBinding.bind(view)

        binding?.run{
            btnToEnd.setOnClickListener {
                findNavController().navigate(R.id.action_threeFragment_to_mainFragment,
                MainFragment.createBundle("лошадку"))
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
