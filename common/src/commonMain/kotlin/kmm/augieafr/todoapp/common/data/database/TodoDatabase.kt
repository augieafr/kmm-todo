package kmm.augieafr.todoapp.common.data.database

import kmm.augieafr.TodoDatabase

internal class TodoDatabase(databaseDriverFactory: DatabaseDriverFactory) {
    private val database = TodoDatabase(databaseDriverFactory.createDriver())
    val dbQuery = database.todoQueries
}