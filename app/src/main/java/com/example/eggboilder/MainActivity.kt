package com.example.eggboilder

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.eggboilder.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = TimeAdapter()
        binding.rvBoil.adapter = adapter
        adapter.submitList(Boil.list)

        viewModel.timeString.observe(this) {
            binding.textView.text = it
        }

        viewModel.secondsPassed.observe(this) {
            val title = "Alert"
            var message = ""
            when (it) {
                180 -> message = "Soft boiled yolk and set white."

                240 -> message = "Slightly set yolk and set white."

                300 -> message = "Slightly set yolk and set white."

                360 -> message = "Hard boiled with lightly soft yolk."

                480 -> message = "Firmly hard boiled."
            }

            createNotification(
                this@MainActivity,
                title,
                message
            )
        }

        binding.btnStart.setOnClickListener {
            viewModel.runTimer()
        }

        binding.btnReset.setOnClickListener {
            viewModel.resetTimer()
        }
    }
}