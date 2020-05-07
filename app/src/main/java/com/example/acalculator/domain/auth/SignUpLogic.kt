package com.example.acalculator.domain.auth

import com.example.acalculator.data.local.user.User
import com.example.acalculator.data.local.user.UserStorage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SignUpLogic {
    private var storage =
        UserStorage.getInstance()

    fun addUser(user: User): Boolean {
        CoroutineScope(Dispatchers.IO).launch {
            storage.insert(user)
        }
        return true
    }

    fun getUsers(): List<User> {
        return storage.getAll()
    }
}