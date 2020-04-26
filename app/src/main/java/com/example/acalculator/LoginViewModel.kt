package com.example.acalculator

import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    private val loginLogic = LoginLogic()

    fun login(email: String, password: String): Boolean{
        return loginLogic.login(email,password)

    }

    fun getLoggedUser(): User{
        return loginLogic.getLoggedUser()
    }
}