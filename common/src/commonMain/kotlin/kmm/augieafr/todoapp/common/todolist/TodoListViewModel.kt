package kmm.augieafr.todoapp.common.todolist

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import kmm.augieafr.todoapp.common.data.repository.TodoRepository
import kmm.augieafr.todoapp.common.ui.model.TodoUiModel
import kmm.augieafr.todoapp.common.ui.utils.dueDateToDeadline

class TodoListViewModel (private val repository: TodoRepository) {
    val listTodo = mutableStateListOf<TodoUiModel>()
    var isShowAddEditTodo: MutableState<TodoEvent?> = mutableStateOf(null)

    init {
        listTodo.addAll(repository.getAllTodos())
    }

    // later change implementation with repository
    fun todoEventHandler(index: Int, todoEvent: TodoEvent) {
        when (todoEvent) {
            TodoEvent.Add -> isShowAddEditTodo.value = TodoEvent.Add
            TodoEvent.Delete -> {
                repository.deleteTodo(listTodo[index].id)
                listTodo.removeAt(index)
            }

            is TodoEvent.Done -> {
                val updatedTodo = listTodo[index].copy(isDone = todoEvent.isDone)
                listTodo[index] = updatedTodo
                repository.addEditTodo(updatedTodo, true)
            }

            is TodoEvent.Edit -> {
                isShowAddEditTodo.value = TodoEvent.Edit(todoEvent.todoUiModel)
            }

            is TodoEvent.SaveTodo -> {
                with(todoEvent) {

                    id?.let { id ->
                        val todo = listTodo.single {
                            it.id == id
                        }

                        val editedTodoIndex = listTodo.indexOf(todo)
                        repository.addEditTodo(listTodo[editedTodoIndex], true)
                        listTodo[editedTodoIndex] = listTodo[editedTodoIndex].copy(
                            title = title,
                            description = description,
                            dueDate = dueDate,
                            deadLine = dueDateToDeadline(dueDate)
                        )
                    } ?: run {
                        val todo = TodoUiModel(
                            0, title = title,
                            description = description,
                            dueDate = dueDate,
                            deadLine = dueDateToDeadline(dueDate),
                            isDone = false
                        )
                        val newId = repository.addEditTodo(todo, false)
                        listTodo.add(0, todo.copy(id = newId.toInt()))
                    }

                }
            }
        }
    }
}
