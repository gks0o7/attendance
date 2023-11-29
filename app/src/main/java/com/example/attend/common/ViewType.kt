package com.example.attend.common

import androidx.annotation.IntDef

const val ITEM_NONE = 0
const val ITEM_TEACHER = 1
const val ITEM_STUDENT = 2

@IntDef(
    ITEM_NONE,
    ITEM_TEACHER,
    ITEM_STUDENT
)
@Retention(AnnotationRetention.SOURCE)
annotation class ViewType