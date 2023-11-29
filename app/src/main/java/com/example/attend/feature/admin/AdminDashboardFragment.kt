package com.example.attend.feature.admin

import androidx.navigation.fragment.findNavController
import com.example.attend.common.base.BaseFragment
import com.example.attend.common.util.view.showShortToast
import com.example.attend.databinding.FragmentAdminDashboardBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AdminDashboardFragment: BaseFragment<FragmentAdminDashboardBinding, AdminDashboardViewModel>() {

    override fun getViewBinding(): FragmentAdminDashboardBinding {
        return FragmentAdminDashboardBinding.inflate(layoutInflater)
    }

    override fun getViewModelClass(): Class<AdminDashboardViewModel> {
        return AdminDashboardViewModel::class.java
    }


    override fun setUpViews() {
        super.setUpViews()
        initListeners()
    }

    private fun initListeners() {
        with(binding) {
            btnManageTeachers.setOnClickListener {
                findNavController().navigate(AdminDashboardFragmentDirections.actionAdminDashboardFragmentToTeachersFragment())
            }
            btnManageStudents.setOnClickListener {
                showShortToast(requireContext(), "Feature coming soon")
            }
        }
    }


}