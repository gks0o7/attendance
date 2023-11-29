package com.example.attend.feature.adapter

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.attend.common.base.BaseRecyclerAdapter
import com.example.attend.common.base.BaseViewType
import com.example.attend.common.base.ViewDataBinder
import com.example.attend.feature.binder.diff_util.TeacherDiffUtilCallback
import com.example.attend.feature.binder.teacher.TeacherViewBinder
import javax.inject.Inject

class TeacherAdapter @Inject constructor(
    private val teacherViewBinder: TeacherViewBinder
) : BaseRecyclerAdapter<BaseViewType>() {

    init {
        initViewDataBinders()
    }

    override fun getSupportedViewDataBinder(): List<ViewDataBinder<ViewDataBinding, BaseViewType>> {
        val viewDataBinders = ArrayList<ViewDataBinder<*, *>>(1)
        viewDataBinders.add(teacherViewBinder)
        return viewDataBinders as List<ViewDataBinder<ViewDataBinding, BaseViewType>>
    }

    fun setItemsViaDiffUtil(recyclerView: RecyclerView, items: List<BaseViewType>) {
        val recyclerViewState = recyclerView.layoutManager?.onSaveInstanceState()

        val diffUtilCallback = TeacherDiffUtilCallback(dataList, items)
        val diffResult = DiffUtil.calculateDiff(diffUtilCallback)
        dataList.clear()
        dataList.addAll(items)
        diffResult.dispatchUpdatesTo(this)

        recyclerView.layoutManager?.onRestoreInstanceState(recyclerViewState)
    }
}