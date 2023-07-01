package com.example.myapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapp.databinding.FragmentMainBinding
import com.example.myapp.databinding.FragmentOneBinding
import com.google.android.material.snackbar.Snackbar

class MainFragment : Fragment(R.layout.fragment_main) {
    private var binding: FragmentMainBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainBinding.bind(view)
        val name = arguments?.getString(STR)
        Snackbar.make(view, "ты видел " + name.toString(), Snackbar.LENGTH_LONG).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    companion object{
        private const val STR = "STRING"
        fun createBundle(str: String): Bundle{
            val bundle = Bundle()
            bundle.putString(STR, str)
            return bundle
        }
    }
}
