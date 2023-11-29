package com.example.attend.feature.admin

import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SimpleItemAnimator
import com.example.attend.common.base.BaseFragment
import com.example.attend.common.util.MarginVerticalItemDecoration
import com.example.attend.common.util.coroutine.observeInLifecycle
import com.example.attend.common.util.view.dpToPx
import com.example.attend.databinding.FragmentTeachersBinding
import com.example.attend.feature.adapter.TeacherAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@AndroidEntryPoint
class TeachersFragment: BaseFragment<FragmentTeachersBinding, TeachersViewModel>() {

    @Inject
    lateinit var adapter: TeacherAdapter

    override fun getViewBinding(): FragmentTeachersBinding {
        return FragmentTeachersBinding.inflate(layoutInflater)
    }

    override fun getViewModelClass(): Class<TeachersViewModel> {
        return TeachersViewModel::class.java
    }

    override fun setUpViews() {
        super.setUpViews()
        initListeners()
        initRecyclerview()
    }

    private fun initListeners() {
        with (binding) {
            btnAdd.setOnClickListener {
                findNavController().navigate(TeachersFragmentDirections.actionTeachersFragmentToAddTeacherFragment())
            }
        }
    }

    private fun initRecyclerview() {
        val lm = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        binding.rvTeachers.layoutManager = lm
        binding.rvTeachers.setHasFixedSize(true)
        binding.rvTeachers.addItemDecoration(
            MarginVerticalItemDecoration(
                topMargin = dpToPx(16),
                bottomMargin = dpToPx(12)
            )
        )
        binding.rvTeachers.adapter = adapter
        (binding.rvTeachers.itemAnimator as SimpleItemAnimator).supportsChangeAnimations = false
    }

    override fun observeData() {
        super.observeData()
        viewModel.teachers.onEach {
//            scrollListener?.bottomLoadingDone()
            if (adapter.dataList.isEmpty() && it.isEmpty()) {
                //showEmptyView()
            } else {
                adapter.setItemsViaDiffUtil(binding.rvTeachers, it)
            }
        }.observeInLifecycle(viewLifecycleOwner)
    }
}