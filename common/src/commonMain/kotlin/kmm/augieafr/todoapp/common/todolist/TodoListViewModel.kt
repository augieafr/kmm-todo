package kmm.augieafr.todoapp.common.todolist

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import kmm.augieafr.todoapp.common.ui.model.TodoUiModel

class TodoListViewModel {
    val listTodo = mutableStateListOf<TodoUiModel>()
    var isShowAddEditTodo: MutableState<TodoEvent?> = mutableStateOf(null)

    init {
        listTodo.addAll(TodoUiModel.generateDummyTodoList())
    }

    // later change implementation with repository
    fun todoEventHandler(index: Int, TodoEvent: TodoEvent) {

    }
}