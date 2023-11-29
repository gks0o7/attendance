package com.example.attend.feature.login

import com.example.attend.common.Resource
import com.example.attend.common.base.BaseViewModel
import com.example.attend.domain.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : BaseViewModel() {

    private val uiStateEvent = Channel<LoginUiState>(Channel.BUFFERED)
    val uiState = uiStateEvent.receiveAsFlow()

    fun login(username: String, password: String) = launchIO {
        val loginResponse = authRepository.login(username, password)
        when (loginResponse) {
            is Resource.Error -> {
                uiStateEvent.send(LoginUiState.Error(loginResponse.errorMessage))
            }
            is Resource.Loading -> {

            }
            is Resource.Success -> {
                uiStateEvent.send(LoginUiState.LoginSuccessful)
            }
        }
    }

    sealed class LoginUiState {
        data object Loading: LoginUiState()

        data object LoginSuccessful: LoginUiState()

        data class Error(val message: String? ): LoginUiState()
    }

}