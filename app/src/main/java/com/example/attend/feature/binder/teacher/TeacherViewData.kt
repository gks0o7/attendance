package com.example.attend.feature.binder.teacher

import android.os.Parcelable
import androidx.annotation.Keep
import com.example.attend.common.ITEM_TEACHER
import com.example.attend.common.base.BaseViewType
import com.example.attend.domain.model.User
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
data class TeacherViewData(
    val id: Long,
    val name: String,
    val username: String,
    val role: String,
    override val viewType: Int = ITEM_TEACHER
) : Parcelable, BaseViewType {

    companion object {
        fun convert(user: User): TeacherViewData {
            return TeacherViewData(
                user.id,
                user.name,
                user.username,
                user.role
            )
        }

        fun convert(users: List<User>): List<TeacherViewData> {
            return users.map { convert(it) }
        }
    }
}
