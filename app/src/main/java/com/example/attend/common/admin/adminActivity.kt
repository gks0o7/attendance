package com.example.attend.common.admin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.attend.R

class AdminActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.admin_view)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, AdminFragment())
                .commit()
        }
    }
}
