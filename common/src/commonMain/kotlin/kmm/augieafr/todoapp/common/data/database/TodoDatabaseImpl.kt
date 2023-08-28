package kmm.augieafr.todoapp.common.data.database

internal class TodoDatabaseImpl(databaseDriverFactory: DatabaseDriverFactory) {
    private val database = createDatabase(databaseDriverFactory)
    val dbQuery = database.todoQueries
}