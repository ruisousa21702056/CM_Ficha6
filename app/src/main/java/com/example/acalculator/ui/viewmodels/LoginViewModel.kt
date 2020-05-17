package com.example.acalculator.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.example.acalculator.data.local.user.User
import com.example.acalculator.data.remote.RetrofitBuilder
import com.example.acalculator.domain.auth.LoginLogic
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

const val ENDPOINT = "https://cm-calculadora.herokuapp.com/api/"

class LoginViewModel : ViewModel() {

    private val authLogic = LoginLogic(RetrofitBuilder.getInstance(ENDPOINT))

    fun login(email: String, password: String): Boolean{
        var bool = true
        CoroutineScope(Dispatchers.IO).launch {
            bool = authLogic.login(email,password)
        }
        return bool
    }

    fun getLoggedUser(): User {
        return authLogic.getLoggedUser()
    }
}