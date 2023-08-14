package kmm.augieafr.todoapp.common.todolist

import kmm.augieafr.todoapp.common.ui.model.TodoUiModel

sealed class TodoEvent {
    object Delete : TodoEvent()
    class Edit(val todoUiModel: TodoUiModel) : TodoEvent()
    class Done(val isDone: Boolean) : TodoEvent()
    object Add : TodoEvent()
    class SaveTodo(val id: Int?, val title: String, val description: String, val dueDate: String) :
        TodoEvent()
}