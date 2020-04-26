package com.example.acalculator

import org.apache.commons.codec.digest.DigestUtils

class LoginViewModel {

    private val loginLogic = LoginLogic()

    fun getUsers(): List<User> {
        return loginLogic.getUsers()
    }

    fun validateCredentials(email: String, password: String): Boolean{
        val users = getUsers()
        for(user in users) {
            if ((user.email == email) and (user.password == DigestUtils.sha256Hex(password))) {
                return true
            }
        }
        return false
    }
}