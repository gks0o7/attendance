package com.example.attend.common.base

import com.example.attend.common.ViewType

interface BaseViewType {

    @get:ViewType
    val viewType: Int

}