package com.example.attend.feature.login

import com.example.attend.AppController
import com.example.attend.common.Resource
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
//        uiStateEvent.send(LoginUiState.Loading)
        val loginResponse = appController.dbFactory.userDao.login(username, password)
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