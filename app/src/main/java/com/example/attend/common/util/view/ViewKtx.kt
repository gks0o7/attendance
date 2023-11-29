package com.example.attend.common.util.view

import android.app.Activity
import android.content.Context
import android.content.res.Resources
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

fun dpToPx(dp: Int): Int {
    return (dp * Resources.getSystem().displayMetrics.density).toInt()
}

fun Activity?.showShortToast(text: String?) {
    if (this == null || text.isNullOrEmpty()) return
    Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
}