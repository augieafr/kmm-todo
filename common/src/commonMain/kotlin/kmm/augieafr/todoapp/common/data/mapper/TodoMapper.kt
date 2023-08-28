package kmm.augieafr.todoapp.common.data.mapper

import kmm.augieafr.sqldelight.todo.Todo
import kmm.augieafr.todoapp.common.ui.model.TodoUiModel
import kmm.augieafr.todoapp.common.ui.utils.dueDateToDeadline

fun TodoUiModel.toTodoEntity() = Todo(
    id.toLong(), title, description, dueDate, isDone
)

fun Todo.toTodoUiModel() = TodoUiModel(
    id = id.toInt(),
    title = title,
    description = description,
    dueDate = dueDate,
    deadLine = dueDateToDeadline(dueDate),
    isDone = isDone
)