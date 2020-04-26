package com.example.acalculator

import org.apache.commons.codec.digest.DigestUtils

class LoginLogic {

    private var storage = UserStorage.getInstance()

    fun getUsers(): List<User> {
        return storage.getAll()
    }
}