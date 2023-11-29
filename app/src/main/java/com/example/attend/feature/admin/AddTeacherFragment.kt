package com.example.attend.feature.admin

import androidx.navigation.fragment.findNavController
import com.example.attend.R
import com.example.attend.common.base.BaseFragment
import com.example.attend.common.util.coroutine.observeInLifecycle
import com.example.attend.common.util.view.showShortToast
import com.example.attend.databinding.FragmentAddTeacherBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class AddTeacherFragment: BaseFragment<FragmentAddTeacherBinding, TeachersViewModel>() {

    override fun getViewBinding(): FragmentAddTeacherBinding {
        return FragmentAddTeacherBinding.inflate(layoutInflater)
    }

    override fun getViewModelClass(): Class<TeachersViewModel> {
        return TeachersViewModel::class.java
    }


    override fun setUpViews() {
        super.setUpViews()
        initListeners()
    }

    private fun initListeners() {
        with (binding) {
            toolbar.setNavigationOnClickListener {
                findNavController().navigateUp()
            }
            btnAddOrUpdate.setOnClickListener {
                addOrUpdateCustomer()
            }
        }
    }

    override fun observeData() {
        super.observeData()
        viewModel.manageUiState.onEach {
            when (it) {
                is TeachersViewModel.ManageTeachersUiState.Error -> {
                    showShortToast(requireContext(), it.message)
                }
                is TeachersViewModel.ManageTeachersUiState.Loading -> {

                }
                is TeachersViewModel.ManageTeachersUiState.TeacherAdded -> {
                    showShortToast(requireContext(), getString(R.string.teacher_added))
                    findNavController().navigateUp()
                }
                is TeachersViewModel.ManageTeachersUiState.TeacherUpdated -> {
                    showShortToast(requireContext(), getString(R.string.teacher_updated))
                }
            }
        }.observeInLifecycle(viewLifecycleOwner)
    }

    private fun addOrUpdateCustomer() {
        val name = binding.etName.text?.toString()?.trim()
        val username = binding.etUsername.text?.toString()?.trim()
        val password = binding.etPassword.text?.toString()?.trim()

        if (!password.isNullOrEmpty() && password.length < 6) {
            showShortToast(requireContext(), getString(R.string.password_legth_short))
            return
        }

        if (password.isNullOrEmpty()) {
            showShortToast(requireContext(), getString(R.string.password_required))
            return
        }

        if (name.isNullOrEmpty()) {
            showShortToast(requireContext(), getString(R.string.name_required))
            return
        }

        if (username.isNullOrEmpty()) {
            showShortToast(requireContext(), getString(R.string.username_can_t_be_empty))
            return
        }

        viewModel.addTeacher(name, username, password)
    }

}