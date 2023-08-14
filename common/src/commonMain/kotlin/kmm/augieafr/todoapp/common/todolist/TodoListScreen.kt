package com.augieafr.todo_app.todolist

import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kmm.augieafr.todoapp.common.component.AddEditTodoDialog
import kmm.augieafr.todoapp.common.component.ToDo
import kmm.augieafr.todoapp.common.todolist.TodoEvent
import kmm.augieafr.todoapp.common.todolist.TodoListViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToDoListScreen(
    modifier: Modifier,
    viewModel: TodoListViewModel
) {

    // A surface container using the 'background' color from the theme
    Scaffold(modifier = modifier, topBar = {
        TopAppBar(title = { Text(text = "KMM ToDo") })
    }, floatingActionButton = {
        FloatingActionButton(onClick = {
            viewModel.todoEventHandler(0, TodoEvent.Add)
        }) {
            Icon(imageVector = Icons.Default.Add, contentDescription = "Add")
        }
    }) { paddingValues ->

        LazyColumn(
            modifier = Modifier.padding(paddingValues),
        ) {
            itemsIndexed(viewModel.listTodo) { index, todo ->
                ToDo(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .height(IntrinsicSize.Max),
                    todoModel = todo,
                    onTodoEvent = { event ->
                        viewModel.todoEventHandler(index, event)
                    }
                )
            }
        }

        viewModel.isShowAddEditTodo.value?.let {
            AddEditTodoDialog(
                modifier = Modifier
                    .fillMaxWidth(),
                event = it,
                onDismissRequest = {
                    viewModel.isShowAddEditTodo.value = null
                },
                onSaveClicked = { id, title, description, dueDate ->
                    viewModel.todoEventHandler(
                        0,
                        TodoEvent.SaveTodo(id, title, description, dueDate)
                    )
                }
            )
        }
    }
}