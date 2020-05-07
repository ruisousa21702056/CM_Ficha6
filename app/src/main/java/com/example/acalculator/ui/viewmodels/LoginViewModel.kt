package com.example.acalculator.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.example.acalculator.data.local.user.User
import com.example.acalculator.domain.auth.LoginLogic

class LoginViewModel : ViewModel() {

    private val loginLogic = LoginLogic()

    fun login(email: String, password: String): Boolean{
        return loginLogic.login(email,password)

    }

    fun getLoggedUser(): User {
        return loginLogic.getLoggedUser()
    }
}