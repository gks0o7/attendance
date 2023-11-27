package com.example.attend.common.util.coroutine

import android.content.Context
import android.widget.EditText
import android.widget.Toast


fun EditText.focusAndPlaceCursorToEnd() {
    this.requestFocus()
    this.setSelection(this.text.length)
}

fun showShortToast(context: Context?, text: String?) {
    if (context == null || text.isNullOrEmpty()) return
    Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
}