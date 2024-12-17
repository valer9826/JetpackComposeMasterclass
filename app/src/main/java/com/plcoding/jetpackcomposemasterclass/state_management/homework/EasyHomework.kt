package com.plcoding.jetpackcomposemasterclass.state_management.homework

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun TodoListScreenRoot(
    viewModel: TodoListViewModel = viewModel(),
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    TodoList(
        state = state,
        onAction = viewModel::onAction
    )
}

@Composable
fun TodoList(
    state: TodoListState,
    onAction: (TodoListAction) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        LazyColumn(
            contentPadding = PaddingValues(16.dp),
            modifier = Modifier
                .weight(1f)
        ) {
            items(state.todos) { todo ->
                TodoItem(
                    todo = todo,
                    onCheckedChange = { onAction(TodoListAction.OnToggleTodo(todo)) },
                    onDeleteClick = { onAction(TodoListAction.OnDeleteTodoClick(todo)) },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
            ) {
                TextField(
                    value = state.newTodoTitle,
                    onValueChange = { onAction(TodoListAction.OnTitleChange(it)) },
                    modifier = Modifier
                        .fillMaxWidth(),
                    placeholder = { Text("Title") }
                )
                Spacer(modifier = Modifier.height(16.dp))
                TextField(
                    value = state.newTodoDescription,
                    onValueChange = { onAction(TodoListAction.OnDescriptionChange(it)) },
                    modifier = Modifier
                        .fillMaxWidth(),
                    placeholder = { Text("Description") }
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(
                onClick = { onAction(TodoListAction.OnAddTodoClick) }
            ) {
                Text("Add")
            }
        }
    }
}

@Preview(
    showBackground = true,
)
@Composable
fun PreviewTodoItem() {
    TodoListScreenRoot()
}

