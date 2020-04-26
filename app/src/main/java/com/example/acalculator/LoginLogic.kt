package com.example.acalculator

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.apache.commons.codec.digest.DigestUtils

class LoginLogic {

    private var storage = UserStorage.getInstance()

    fun getUsers(): List<User> {
        return storage.getAll()
    }

    fun login(email: String, password: String): Boolean{
        val user_aux = User("Rui Sousa", email, DigestUtils.sha256Hex("pass"))
        addUser(user_aux)
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

    fun addUser(user: User): Boolean {
        CoroutineScope(Dispatchers.IO).launch {
            storage.insert(user)
        }
        return true
    }

    fun updateLoggedUser(user: User) {
        storage.updateLoggedUser(user)
    }
}