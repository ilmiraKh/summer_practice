package com.example.myapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myapp.databinding.FragmentOneBinding
import com.example.myapp.databinding.FragmentTwoBinding

class TwoFragment : Fragment(R.layout.fragment_two) {
    private var binding: FragmentTwoBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentTwoBinding.bind(view)

        binding?.run{
            btnToEnd.setOnClickListener {
                findNavController().navigate(R.id.action_twoFragment_to_mainFragment, MainFragment.createBundle("дельфина"))
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
