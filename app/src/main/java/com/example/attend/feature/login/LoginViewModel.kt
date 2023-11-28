package com.example.attend.feature.login

import com.example.attend.AppController
import com.example.attend.common.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val appController: AppController
) : BaseViewModel() {

    private val uiStateEvent = Channel<LoginUiState>(Channel.BUFFERED)
    val uiState = uiStateEvent.receiveAsFlow()

    fun login(username: String, password: String) = launchIO {
//        val loginResponse = authRepository.login(username, password)
//        when (loginResponse) {
//            is Resource.Error -> {
//
//            }
//            is Resource.Loading -> {
//
//            }
//            is Resource.Success -> {
//
//            }
//        }
    }

    sealed class LoginUiState {
        data object Loading: LoginUiState()

        data object LoginSuccessful: LoginUiState()

        data class Error(val message: String? ): LoginUiState()
    }

}