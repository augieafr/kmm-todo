package kmm.augieafr.todoapp.common

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.augieafr.todo_app.todolist.ToDoListScreen
import kmm.augieafr.todoapp.common.theme.TODOAppTheme
import kmm.augieafr.todoapp.common.todolist.TodoListViewModel

@Composable
fun App() {
    TODOAppTheme {
        ToDoListScreen(
            modifier = Modifier.fillMaxSize(),
            viewModel = TodoListViewModel()
        )
    }
}
