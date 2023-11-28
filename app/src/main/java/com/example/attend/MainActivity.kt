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

class ItemModel(
    val ID :Int,
    val username: String,
    val password: String,
    val lastName: String,
    val firstName: String,
    val dateOfBirth: LocalDate,
    val gender: String,
    val email: String,
    val phoneNumber: String,
)

 val connectionString = "jdbc:mysql://localhost:3306/attend"
 val username = "root"
 val password = ""
 var con: Connection = DriverManager.getConnection(connectionString, username, password)

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, Nothing>() {

    companion object {
        fun start(context: Context) {
            ContextCompat.startActivity(context, Intent(context, AuthActivity::class.java), null)
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
            supportFragmentManager.findFragmentById(R.id.nav_auth_fragment) as NavHostFragment
        navController = navHostFragment.findNavController()
    }

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        val findusernameinput: EditText = findViewById(R.id.username_edit_text)
//        val username_input = findusernameinput.text.toString()
//
//        val findpasswordinput: EditText = findViewById(R.id.password_edit_text)
//        val password_input = findpasswordinput.text.toString()
//
//        if (username_input.length> 0 && password_input.length > 0) {
//            Thread{
//                try{
//                    Class.forName("com.mysql.jdbc.Driver")
//                    val query = "SELECT * FROM student WHERE email = ? AND password = ?"
//                    val stmt: PreparedStatement = con.prepareStatement(query)
//                    stmt.setString(1, username_input)
//                    stmt.setString(2, password)
//                    val rs: ResultSet = stmt.executeQuery()
//                    val exists: Boolean = rs.next()
//
//
//
//                    runOnUiThread {
//                        if (exists) {
//                            Toast.makeText(applicationContext, "Login successful", Toast.LENGTH_SHORT).show()
//                        } else {
//                            Toast.makeText(applicationContext, "Invalid email or password", Toast.LENGTH_SHORT).show()
//                        }
//                    }
//
//                    con.close()
//
//                } catch (e: SQLException) {
//                    e.printStackTrace()
//                } catch (e: ClassNotFoundException) {
//                    e.printStackTrace()
//                }
//            }.start()
//        }
//    }
}

