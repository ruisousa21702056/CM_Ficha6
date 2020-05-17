package com.example.acalculator.domain.auth

import com.example.acalculator.data.local.user.User
import com.example.acalculator.data.local.user.UserStorage
import com.example.acalculator.data.remote.requests.Login
import com.example.acalculator.data.remote.services.AuthService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit

class LoginLogic(private val retrofit: Retrofit) {

    private var storage = UserStorage.getInstance()

    private fun getUsers(): List<User> {
        return storage.getAll()
    }

    fun login(email: String, password: String): Boolean{
        val service = retrofit.create(AuthService::class.java)
        var bool = true
        CoroutineScope(Dispatchers.IO).launch {
            val response = service.login(Login(email, password))
            if (response.isSuccessful) {
                bool = loginUser(email, password)
            }
            else {
                bool = true
            }
        }
        return bool
    }

    fun getLoggedUser(): User {
        return storage.getLoggedUser()
    }

    private fun loginUser(email: String, password: String): Boolean{
        val users = getUsers()
        if(!users.isNullOrEmpty() && email != "" && password != ""){
            for(user in users) {
                if(user.email == email && user.password == password){
                    storage.updateLoggedUser(user)

                    return true
                }
                return false
            }
        }
        return false
    }
}