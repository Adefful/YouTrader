package com.technopark.youtrader.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.technopark.youtrader.model.CryptoCurrency
import com.technopark.youtrader.model.CryptoCurrencyTransaction

@Database(
    entities = [
        CryptoCurrency::class,
        CryptoCurrencyTransaction::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun cryptoCurrencyDao(): CryptoCurrencyDao
}
