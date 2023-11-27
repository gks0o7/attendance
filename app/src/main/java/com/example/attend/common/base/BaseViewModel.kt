package com.example.attend.common.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.attend.common.util.coroutine.launchDefault
import com.example.attend.common.util.coroutine.launchIO
import com.example.attend.common.util.coroutine.launchMain
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel

abstract class BaseViewModel : ViewModel() {

    fun launchIO(
        exceptionHandler: (suspend (Throwable) -> Unit)? = null, block: suspend (CoroutineScope) -> Unit
    ): Job {
        return viewModelScope.launchIO(exceptionHandler) {
            block(it)
        }
    }

    fun launchDefault(
        exceptionHandler: (suspend (Throwable) -> Unit)? = null, block: suspend (CoroutineScope) -> Unit
    ) = viewModelScope.launchDefault(exceptionHandler) {
        block(it)
    }

    fun launchMain(
        exceptionHandler: (suspend (Throwable) -> Unit)? = null, block: suspend (CoroutineScope) -> Unit
    ) = viewModelScope.launchMain(exceptionHandler) {
        block(it)
    }

    override fun onCleared() {
        viewModelScope.cancel()
        super.onCleared()
    }

}