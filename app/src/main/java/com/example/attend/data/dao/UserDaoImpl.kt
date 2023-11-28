package com.example.attend.data.dao

import com.example.attend.common.Resource
import com.example.attend.data.DbModule
import com.example.attend.domain.model.User
import com.example.attend.domain.source.UserDao
import kotlinx.coroutines.withContext
import java.sql.PreparedStatement
import java.sql.ResultSet
import kotlin.coroutines.CoroutineContext

class UserDaoImpl(
    private val db: DbModule
) : UserDao {

    override suspend fun login(username: String, password: String): Resource<User> {
        return try {
            Class.forName("com.mysql.cj.jdbc.Driver")
            val query = "SELECT * FROM user WHERE username = ? AND password = ?"
            val stmt: PreparedStatement = db.connect().prepareStatement(query)
            stmt.setString(1, username)
            stmt.setString(2, password)
            val rs: ResultSet = stmt.executeQuery()
            val exists: Boolean = rs.next()

            if (exists) {
                val loggedUser = User(
                    name = rs.getString("name"),
                    username = rs.getString("username"),
                    role = rs.getString("role")
                )
                db.connect().close()
                Resource.Success(loggedUser)
             //fetch logged user
            } else {
                db.connect().close()
                Resource.Error("Invalid credentials")
                //not found message send
            }
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.localizedMessage)
        }
    }
}