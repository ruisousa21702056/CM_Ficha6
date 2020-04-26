package com.example.acalculator

import org.apache.commons.codec.digest.DigestUtils

class SignUpViewModel {

    private val signUpLogic = SignUpLogic()

    fun getUsers(): List<User> {
        return signUpLogic.getUsers()
    }

    fun signUp(name: String, email: String, password: String, confirmPassword: String): Boolean{
        if(!name.equals("") && !email.equals("") && password.equals(confirmPassword)){
            signUpLogic.addUser()
        }
            val text_pass_aux = DigestUtils.sha256Hex(text_pass)
            val user = User(text_name,text_email, text_pass_aux)
            var usersAux = ArrayList<User>()
            if(users != null){
                usersAux = users
            }
            usersAux.add(user)
    }
}