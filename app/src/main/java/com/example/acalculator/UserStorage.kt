package com.example.acalculator

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UserStorage private constructor() {

    private val storage = mutableListOf<User>()

    companion object {

        private var instance: UserStorage? = null

        fun getInstance(): UserStorage {
            synchronized(this) {
                if (instance == null) {
                    instance = UserStorage()
                }
                return instance as UserStorage
            }
        }
    }

    suspend fun insert(user: User) {
        withContext(Dispatchers.IO) {
            storage.add(user)
        }

    }

    fun getAll(): List<User> {
        return storage.toList()
    }

    suspend fun delete(user: User) {
        withContext(Dispatchers.IO) {
            //Thread.sleep(30000)
            storage.remove(user)
        }
    }
}
