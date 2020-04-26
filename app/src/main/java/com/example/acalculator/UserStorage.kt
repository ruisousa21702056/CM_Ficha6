package com.example.acalculator

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UserStorage private constructor() {

    private val users_list = mutableListOf<User>()
    private var logged_user = User()


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
            users_list.add(user)
        }

    }

    fun getAll(): List<User> {
        return users_list.toList()
    }

    fun getLoggedUser(): User {
        return this.logged_user
    }

    fun updateLoggedUser(user: User) {
        this.logged_user = user
    }

    suspend fun delete(user: User) {
        withContext(Dispatchers.IO) {
            //Thread.sleep(30000)
            users_list.remove(user)
        }
    }
}
