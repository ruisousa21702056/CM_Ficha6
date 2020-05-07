package com.example.acalculator.data.local.room.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.acalculator.data.local.list.Operation
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized

@Database(entities = arrayOf(Operation::class), version = 1)
abstract class CalculatorDatabase : RoomDatabase() {

    abstract fun operationDao(): OperationDao

    companion object {

        private var instance: CalculatorDatabase? = null

        @InternalCoroutinesApi
        fun getInstance(applicationContext: Context): CalculatorDatabase {
            synchronized(this) {
                if(instance == null) {
                    instance = Room.databaseBuilder(
                        applicationContext,
                        CalculatorDatabase::class.java,
                        "calculator_db"
                    ).build()
                }
                return instance as CalculatorDatabase
            }
        }
    }
}