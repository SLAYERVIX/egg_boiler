package com.example.eggboilder

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.eggboilder.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingPermission")

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val timer = Timer()
        var secondsPassed = 0
        var minutes: Int
        var seconds: Int
        var timeString: String

        timer.scheduleAtFixedRate(object : TimerTask() {
            override fun run() {
                lifecycleScope.launch {
                    secondsPassed++
                    minutes = secondsPassed / 60
                    seconds = secondsPassed % 60
                    timeString = String.format("%d:%02d", minutes, seconds)

                    if (secondsPassed == 10) {
                        createNotification(
                            this@MainActivity,
                            Constants.BOILED_TITLE,
                            Constants.BOILED_TEXT
                        )
                    }

                    withContext(Dispatchers.Main) {
                        if (secondsPassed < 60) {
                            binding.textView.text = seconds.toString()
                        } else {
                            binding.textView.text = timeString
                        }
                    }
                }
            }
        }, 0, 1000)
    }
}