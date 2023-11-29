package com.example.attend.feature.binder.diff_util

import androidx.recyclerview.widget.DiffUtil
import com.example.attend.common.base.BaseViewType
import com.example.attend.feature.binder.teacher.TeacherViewData

class TeacherDiffUtilCallback(
    private val oldList: List<BaseViewType>,
    private val newList: List<BaseViewType>
) : DiffUtil.Callback() {

    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldList[oldItemPosition]
        val newItem = newList[newItemPosition]
        when {
            oldItem is TeacherViewData && newItem is TeacherViewData -> {
                return oldItem.id == newItem.id
            }
        }
        return oldItem.viewType == newItem.viewType
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldList[oldItemPosition]
        val newItem = newList[newItemPosition]
        return when {
            oldItem is TeacherViewData && newItem is TeacherViewData -> {
                oldItem.id == newItem.id &&
                        oldItem.username == newItem.username &&
                        oldItem.name == newItem.name &&
                        oldItem.role == newItem.role
            }

            else -> oldItem.viewType == newItem.viewType
        }
    }
}