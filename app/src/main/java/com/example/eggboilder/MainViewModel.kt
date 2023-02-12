package com.example.eggboilder

import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.sql.Time
import java.util.*

class MainViewModel : ViewModel() {
    private val _secondsPassed: MutableLiveData<Int> = MutableLiveData(0)
    val secondsPassed: LiveData<Int> get() = _secondsPassed

    private val _minutes: MutableLiveData<Int> = MutableLiveData(0)
    val minutes: LiveData<Int> get() = _minutes

    private val _seconds: MutableLiveData<Int> = MutableLiveData(0)
    val seconds: LiveData<Int> get() = _seconds

    private val _timeString: MutableLiveData<String> = MutableLiveData("0:00")
    val timeString: LiveData<String> get() = _timeString

    private var timer: Timer? = null

    fun runTimer() {
        if (timer == null) {
            timer = Timer()
            timer?.scheduleAtFixedRate(object : TimerTask() {
                override fun run() {
                    viewModelScope.launch(Dispatchers.Main) {

                        _secondsPassed.value = secondsPassed.value?.plus(1)
                        _minutes.value = secondsPassed.value?.div(60)
                        _seconds.value = secondsPassed.value?.mod(60)
                        _timeString.value = String.format("%d:%02d", minutes.value, seconds.value)
                    }
                }
            }, 0, 1000)
        }


        //if (secondsPassed == 10) {

//                }
//
//                withContext(Dispatchers.Main) {
//                    if (secondsPassed < 60) {
//                        binding.textView.text = seconds.toString()
//                    } else {
//                        binding.textView.text = timeString
//                    }
//                }


    }

    fun resetTimer() {
        _secondsPassed.value = 0
        _timeString.value = "0:00"


        timer?.cancel()
        timer = null
    }
}