package com.example.acalculator.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.example.acalculator.data.local.user.User
import com.example.acalculator.data.remote.RetrofitBuilder
import com.example.acalculator.domain.auth.LoginLogic

const val ENDPOINT = "https://cm-calculadora.herokuapp.com/api/"

class LoginViewModel : ViewModel() {

    private val authLogic = LoginLogic(RetrofitBuilder.getInstance(ENDPOINT))

    suspend fun login(email: String, password: String): Boolean{
        return authLogic.login(email,password)

    }

    fun getLoggedUser(): User {
        return authLogic.getLoggedUser()
    }
}