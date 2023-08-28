package kmm.augieafr.todoapp.common.data.repository

import kmm.augieafr.todoapp.common.data.database.DatabaseDriverFactory
import kmm.augieafr.todoapp.common.data.database.TodoDatabaseImpl
import kmm.augieafr.todoapp.common.data.mapper.toTodoEntity
import kmm.augieafr.todoapp.common.data.mapper.toTodoUiModel
import kmm.augieafr.todoapp.common.ui.model.TodoUiModel

class TodoRepository(databaseDriverFactory: DatabaseDriverFactory) {
    private val database = TodoDatabaseImpl(databaseDriverFactory)
    private val query = database.dbQuery

    fun getAllTodos() = query.getTodos().executeAsList().map {
        it.toTodoUiModel()
    }

    fun addEditTodo(todoUiModel: TodoUiModel, isEdit: Boolean): Long {
        return with(todoUiModel.toTodoEntity()) {
            query.transactionWithResult {
                query.insertTodo(
                    id = if (isEdit) id else null,
                    title = title,
                    description = description,
                    dueDate = dueDate,
                    isDone = isDone
                )

                query.lastInsertRowId().executeAsOne()
            }
        }
    }

    fun deleteTodo(id: Int) {
        query.deleteTodo(id.toLong())
    }
}