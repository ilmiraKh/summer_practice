package com.example.myapp

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.myapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var ans = 0
    private var text = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val newBinding = ActivityMainBinding.inflate(layoutInflater)
        binding = newBinding
        setContentView(newBinding.root)

        if (savedInstanceState != null) {
            text = savedInstanceState.getString("TEXT").toString()
            binding.textView.text = text
            binding.textView.visibility = View.VISIBLE
        }

        binding.button.setOnClickListener {
            try {
                val name = binding.etName.text.toString().trim()
                val age = Integer.parseInt(binding.etAge.text.toString().trim())
                val height = Integer.parseInt(binding.etHeight.text.toString().trim())
                val weight = binding.etWeight.text.toString().trim().toDouble()
                ans = count(name, age, height, weight)
                if (checkData(name, age, height, weight)) text = "Ответ: $ans%"
                else text = "Данные введены некорректно"
            } catch (e: NumberFormatException) {
                text = "Данные введены некорректно"
            } finally {
                binding.textView.text = text
                binding.textView.visibility = View.VISIBLE
            }
        }
    }

    fun checkData(name: String, age: Int, height: Int, weight: Double): Boolean {
        return name.isNotEmpty() && name.length <= 150 &&
                age in 1..150 &&
                height in 1..250 &&
                weight > 0 && weight <= 250
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("TEXT", text)
    }

    fun count(name: String, age: Int, height: Int, weight: Double): Int {
        return ((name.length * 13 + age * 187 + height * 22 + weight * 101) % 100).toInt()
    }
}