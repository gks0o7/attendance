package com.example.attend

import android.content.Context
import android.content.Intent
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.attend.common.base.BaseActivity
import com.example.attend.databinding.ActivityAuthBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AuthActivity: BaseActivity<ActivityAuthBinding, Nothing>() {

    companion object {
        fun start(context: Context) {
            ContextCompat.startActivity(context, Intent(context, AuthActivity::class.java), null)
        }
    }

    private lateinit var navHostFragment: NavHostFragment
    private lateinit var navController: NavController

    override fun getViewBinding(): ActivityAuthBinding {
        return ActivityAuthBinding.inflate(layoutInflater)
    }

    override fun setUpViews() {
        super.setUpViews()
        init()
    }

    private fun init() {
        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_auth_fragment) as NavHostFragment
        navController = navHostFragment.findNavController()
    }
}