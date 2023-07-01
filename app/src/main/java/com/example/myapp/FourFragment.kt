package com.example.myapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myapp.databinding.FragmentFourBinding
import com.example.myapp.databinding.FragmentOneBinding

class FourFragment : Fragment(R.layout.fragment_four) {
    private var binding: FragmentFourBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFourBinding.bind(view)

        val name = arguments?.getString(NAME)

        binding?.run{
            btnToEnd.setOnClickListener {
                findNavController().navigate(R.id.action_fourFragment_to_mainFragment,
                    MainFragment.createBundle("пчёлку"))
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    companion object{
        private const val NAME = "NAME"
        fun createBundle(name: String): Bundle{
            val bundle = Bundle()
            bundle.putString(NAME, name)
            return bundle
        }
    }
}
