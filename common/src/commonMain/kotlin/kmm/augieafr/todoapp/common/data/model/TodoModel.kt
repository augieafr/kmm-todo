package kmm.augieafr.todoapp.common.data.model

data class TodoModel(
    val id: Long,
    val title: String,
    val description: String,
    val dueDate: String,
    val isDone: Boolean,
)