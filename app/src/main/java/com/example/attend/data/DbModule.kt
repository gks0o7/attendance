package com.example.attend.data

import com.example.attend.Const
import kotlinx.coroutines.withContext
import java.sql.Connection
import java.sql.DriverManager
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.coroutines.CoroutineContext

@Singleton
class DbModule @Inject constructor(
    private val coroutineContext: CoroutineContext
) {

    suspend fun connect(): Connection = withContext(coroutineContext) {
        DriverManager.getConnection(
            Const.connectionString,
            Const.username,
            Const.password
        )
    }

}