package com.example.attend
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.attend.common.base.BaseActivity
import com.example.attend.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import java.sql.*
import java.time.LocalDate


@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, Nothing>() {

    companion object {
        fun start(context: Context) {
            ContextCompat.startActivity(context, Intent(context, MainActivity::class.java), null)
        }
    }

    private lateinit var navHostFragment: NavHostFragment
    private lateinit var navController: NavController

    override fun getViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun setUpViews() {
        super.setUpViews()
        init()
    }

    private fun init() {
        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.findNavController()
    }

}

