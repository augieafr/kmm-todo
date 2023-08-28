package kmm.augieafr.todoapp.common

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import kmm.augieafr.todoapp.common.data.database.DatabaseDriverFactory
import kmm.augieafr.todoapp.common.data.repository.TodoRepository
import kmm.augieafr.todoapp.common.theme.TODOAppTheme
import kmm.augieafr.todoapp.common.todolist.ToDoListScreen
import kmm.augieafr.todoapp.common.todolist.TodoListViewModel

@Composable
fun App(databaseDriverFactory: DatabaseDriverFactory) {
    val repository = TodoRepository(databaseDriverFactory)
    TODOAppTheme {
        ToDoListScreen(
            modifier = Modifier.fillMaxSize(),
            viewModel = TodoListViewModel(repository)
        )
    }
}
