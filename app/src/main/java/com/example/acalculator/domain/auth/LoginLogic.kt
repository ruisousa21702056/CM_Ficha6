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

    /*fun login(email: String, password: String): Boolean{
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
    }*/

    suspend fun login(email: String, password: String): Boolean{
        val service = retrofit.create(AuthService::class.java)
        val response = service.login(Login(email,password))
        CoroutineScope(Dispatchers.IO).launch {
            if(response.isSuccessful) {
                //temos acesso ao objeto de LoginResponse através do método
                //response.body
            }
            else{
                //erro de autenticação
            }
        }
        return true
    }

    fun getLoggedUser(): User {
        return storage.getLoggedUser()
    }
}