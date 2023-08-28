package kmm.augieafr.todoapp.common.data.repository

import kmm.augieafr.todoapp.common.data.database.TodoDatabase
import kmm.augieafr.todoapp.common.data.model.TodoModel

internal class TodoRepository(database: TodoDatabase) {
    private val query = database.dbQuery

    fun getAllTodos() = query.getTodos().executeAsList()

    fun addEditTodo(todoModel: TodoModel, isEdit: Boolean) {
        with(todoModel) {
            query.insertTodo(
                id = if (isEdit) todoModel.id else null,
                title = title,
                description = description,
                dueDate = dueDate,
                isDone = isDone
            )
        }
    }

    fun deleteTodo(id: Long) {
        query.deleteTodo(id)
    }
}