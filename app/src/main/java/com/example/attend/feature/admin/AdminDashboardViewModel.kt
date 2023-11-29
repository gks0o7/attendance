package com.example.attend.feature.admin

import com.example.attend.common.base.BaseViewModel
import com.example.attend.domain.repository.AdminRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AdminDashboardViewModel @Inject constructor(
    private val adminRepository: AdminRepository
) : BaseViewModel() {

}