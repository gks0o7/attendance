package com.example.attend.feature.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import com.example.attend.MainActivity
import com.example.attend.R
import com.example.attend.common.base.BaseFragment
import com.example.attend.common.util.coroutine.focusAndPlaceCursorToEnd
import com.example.attend.common.util.coroutine.observeInLifecycle
import com.example.attend.common.util.coroutine.showShortToast
import com.example.attend.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding, LoginViewModel>() {

    override fun getViewBinding(): FragmentLoginBinding {
        return FragmentLoginBinding.inflate(layoutInflater)
    }

    override fun getViewModelClass(): Class<LoginViewModel> {
        return LoginViewModel::class.java
    }

    override fun setUpViews() {
        super.setUpViews()
        initListeners()
    }

    private fun initListeners() {
        with(binding) {
            btnLogin.setOnClickListener {
                login()
            }

            inputUsername.editText?.setOnEditorActionListener { _, actionId, _ ->
                if (actionId == EditorInfo.IME_ACTION_NEXT) {
                    etPassword.focusAndPlaceCursorToEnd()
                    return@setOnEditorActionListener true
                }
                false
            }

            inputPassword.editText?.setOnEditorActionListener { _, actionId, _ ->
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    login()
                    return@setOnEditorActionListener true
                }
                false
            }

        }
    }

    private fun login() {
        val username = binding.etUsername.text.toString().trim()
        val password = binding.etPassword.text.toString().trim()

        if (username.isEmpty()) {
            binding.inputUsername.error = getString(R.string.username_can_t_be_empty)
        } else if (password.isEmpty()) {
            binding.inputPassword.error = getString(R.string.please_enter_password)
        } else if (password.isNotEmpty() && username.isNotEmpty()) {
            viewModel.login(username, password)
        } else {
            showShortToast(requireContext(), "Please, Enter Phone Number and Password")
        }
    }

    override fun observeData() {
        super.observeData()
        viewModel.uiState.onEach {
            when (it) {
                is LoginViewModel.LoginUiState.Error -> {
                    showShortToast(requireContext(), it.message)
                }
                is LoginViewModel.LoginUiState.Loading -> {

                }
                is LoginViewModel.LoginUiState.LoginSuccessful -> {
                    MainActivity.start(requireActivity())
                    activity?.finish()
                }
            }
        }.observeInLifecycle(viewLifecycleOwner)

    }

}