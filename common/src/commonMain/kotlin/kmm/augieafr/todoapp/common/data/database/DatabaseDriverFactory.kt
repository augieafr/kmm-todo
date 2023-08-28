package kmm.augieafr.todoapp.common.data.database

import app.cash.sqldelight.db.SqlDriver
import kmm.augieafr.TodoDatabase

expect class DatabaseDriverFactory {
    fun createDriver(): SqlDriver
}

fun createDatabase(driverFactory: DatabaseDriverFactory): TodoDatabase {
    val driver = driverFactory.createDriver()
    return TodoDatabase(driver)
}