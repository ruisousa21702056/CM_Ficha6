package com.example.acalculator

import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    private val loginLogic = LoginLogic()

    fun getUsers(): List<User> {
        return loginLogic.getUsers()
    }

    fun login(email: String, password: String): Boolean{
        return loginLogic.login(email,password)

    }

    fun getLoggedUser(): User{
        return loginLogic.getLoggedUser()
    }

    fun logout(){
        val user = User()
        loginLogic.updateLoggedUser(user)
    }
}