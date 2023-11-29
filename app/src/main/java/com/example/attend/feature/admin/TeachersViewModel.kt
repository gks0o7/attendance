package com.example.attend.feature.admin

import androidx.lifecycle.viewModelScope
import com.example.attend.common.Resource
import com.example.attend.common.base.BaseViewModel
import com.example.attend.common.util.coroutine.launchIO
import com.example.attend.data.local.request.AddTeacherRequest
import com.example.attend.domain.repository.AdminRepository
import com.example.attend.feature.binder.teacher.TeacherViewData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TeachersViewModel @Inject constructor(
    private val adminRepository: AdminRepository
) : BaseViewModel() {

    private val _teachers = MutableStateFlow<List<TeacherViewData>>(emptyList())
    val teachers = _teachers

    init {
        fetchInitTeachers()
    }

    private val manageUiStateEvent = Channel<ManageTeachersUiState>(Channel.BUFFERED)
    val manageUiState = manageUiStateEvent.receiveAsFlow()

    private fun fetchInitTeachers() {
        viewModelScope.launch {
            adminRepository.getTeachers()
                .map { users ->
                    TeacherViewData.convert(users)
                }
                .collect {
                    teachers.value = it
                }
        }
    }

    fun addTeacher(name: String, username: String, password: String) {
        viewModelScope.launchIO {
            val request = AddTeacherRequest(
                name = name,
                username = username,
                password = password
            )

            val response = adminRepository.addTeacher(request)
            when (response) {
                is Resource.Error -> {
                    manageUiStateEvent.send(ManageTeachersUiState.Error(response.errorMessage))
                }
                is Resource.Loading -> {
                    manageUiStateEvent.send(ManageTeachersUiState.Loading)
                }
                is Resource.Success -> {
                    manageUiStateEvent.send(ManageTeachersUiState.TeacherAdded)
                }
            }
        }
    }


    sealed class ManageTeachersUiState {
        data object Loading : ManageTeachersUiState()
        data object TeacherAdded : ManageTeachersUiState()
        data object TeacherUpdated : ManageTeachersUiState()
        data class Error(val message: String?) : ManageTeachersUiState()
    }
}