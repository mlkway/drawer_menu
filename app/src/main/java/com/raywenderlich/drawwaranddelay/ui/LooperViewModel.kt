package com.raywenderlich.drawwaranddelay.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*
import kotlinx.coroutines.NonCancellable.isActive

class LooperViewModel:ViewModel() {



    fun repatedTask(): Job {
        return viewModelScope.launch {
            withContext(Dispatchers.IO){
                while(isActive) {

                        delay(5000)
                }

            }
        }
    }




}