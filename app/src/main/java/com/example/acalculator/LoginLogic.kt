package com.example.acalculator

import org.apache.commons.codec.digest.DigestUtils

class LoginLogic {

    private var storage = UserStorage.getInstance()

    private fun getUsers(): List<User> {
        return storage.getAll()
    }

    fun login(email: String, password: String): Boolean{
        val users = getUsers()
        if(!users.isNullOrEmpty() && email != "" && password != ""){
            for(user in users) {
                if(user.email == email && user.password == DigestUtils.sha256Hex(password)){
                    storage.updateLoggedUser(user)
                    return true
                }
                return false
            }
        }
        return false
    }

    fun getLoggedUser(): User{
        return storage.getLoggedUser()
    }
}