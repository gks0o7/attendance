package com.example.attend.feature.binder.teacher

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.attend.common.ITEM_TEACHER
import com.example.attend.common.base.ViewDataBinder
import com.example.attend.databinding.ItemTeacherBinding
import javax.inject.Inject

class TeacherViewBinder @Inject constructor(

) : ViewDataBinder<ItemTeacherBinding, TeacherViewData>() {

    override val viewType: Int
        get() = ITEM_TEACHER

    override fun createBinder(parent: ViewGroup): ItemTeacherBinding {
        return ItemTeacherBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    }

    override fun bindData(binding: ItemTeacherBinding, data: TeacherViewData, position: Int) {
        with (binding) {
            tvName.text = data.name
            tvRole.text = data.role
        }
    }
}