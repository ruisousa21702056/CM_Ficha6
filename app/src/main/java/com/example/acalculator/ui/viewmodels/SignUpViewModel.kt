package com.example.acalculator.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.example.acalculator.data.local.user.User
import com.example.acalculator.domain.auth.SignUpLogic

class SignUpViewModel : ViewModel() {

    private val signUpLogic = SignUpLogic()

    fun getUsers(): List<User> {
        return signUpLogic.getUsers()
    }

    fun signUp(name: String, email: String, password: String, confirmPassword: String): Boolean{
        if(!name.equals("") && !email.equals("") && !email.equals("") && password.equals(confirmPassword) ){
            var user_aux = User(
                name,
                email,
                password
            )
            signUpLogic.addUser(user_aux)
            return true
        }
        return false
    }
}