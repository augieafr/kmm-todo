package kmm.augieafr.database

import app.cash.sqldelight.db.SqlDriver
import kmm.augieafr.TodoDatabase

expect class DatabaseDriverFactory {
    fun createDriver(): SqlDriver
}

fun createDatabase(driverFactory: DatabaseDriverFactory): TodoDatabase {
    val driver = driverFactory.createDriver()
    // Do more work with the database (see below).
    return TodoDatabase(driver)
}