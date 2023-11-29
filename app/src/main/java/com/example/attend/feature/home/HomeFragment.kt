package com.example.attend.feature.home

import com.example.attend.common.base.BaseFragment
import com.example.attend.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment: BaseFragment<FragmentHomeBinding, Nothing>() {

    override fun getViewBinding(): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(layoutInflater)
    }

    override fun setUpViews() {
        super.setUpViews()
    }
}