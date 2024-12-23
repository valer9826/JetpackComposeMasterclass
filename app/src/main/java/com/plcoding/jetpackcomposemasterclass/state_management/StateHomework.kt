package com.plcoding.jetpackcomposemasterclass.state_management

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.plcoding.jetpackcomposemasterclass.ui.theme.JetpackComposeMasterclassTheme
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


data class TodoItem(
    val title: String,
    val description: String,
    val isChecked: Boolean
)

data class TodoListState(
    val todoList: List<TodoItem> = (1..10).map {
        TodoItem(
            title = "Todo item $it",
            description = "Todo description $it",
            isChecked = false
        )
    },
    val newTitle: String = "",
    val newDescription: String = ""
)

sealed interface TodoAction {
    data class DeleteTodoItem(val todoItem: TodoItem) : TodoAction
    data class OnToggleTodoItem(val todoItem: TodoItem) : TodoAction
    data object AddTodoItem : TodoAction
    data class OnTitleChange(val title: String) : TodoAction
    data class OnDescriptionChange(val description: String) : TodoAction
}

@Composable
fun StateHomeworkRootScreen(
    viewModel: HomeWorkViewModel = viewModel(),
    modifier: Modifier = Modifier
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    StateHomework(
        state = state,
        onAction = viewModel::onAction,
        modifier = modifier
    )
}

class HomeWorkViewModel : ViewModel() {

    private var _state = MutableStateFlow(TodoListState())
    val state = _state.asStateFlow()

    fun onAction(action: TodoAction) {
        when (action) {
            is TodoAction.OnToggleTodoItem -> {
                _state.update { it.copy(
                    todoList = it.todoList.map {
                        if(it == action.todoItem) {
                            it.copy(isChecked = !it.isChecked)
                        } else it
                    }
                ) }
            }

            is TodoAction.DeleteTodoItem -> {
                _state.update { it.copy(
                    todoList = it.todoList.filter { it != action.todoItem }
                ) }
            }

            TodoAction.AddTodoItem -> {
                val title = state.value.newTitle
                val description = state.value.newDescription
                if(title.isNotBlank()) {
                    val newTodo = TodoItem(
                        title = title.trim(),
                        description = description.trim(),
                        isChecked = false
                    )
                    _state.update { it.copy(
                        todoList = it.todoList + newTodo,
                        newTitle = "",
                        newDescription = ""
                    ) }
                }
            }

            is TodoAction.OnDescriptionChange -> {
                _state.update {
                    it.copy(
                        newDescription = action.description
                    )
                }
            }

            is TodoAction.OnTitleChange -> {
                _state.update {
                    it.copy(
                        newTitle = action.title
                    )
                }
            }
        }
    }
}

@Composable
fun StateHomework(
    state: TodoListState,
    onAction: (TodoAction) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(vertical = 2.dp, horizontal = 8.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyColumn(
            modifier = Modifier.weight(5f)
        ) {
            items(items = state.todoList) { todoItem ->
                TodoItem(
                    todoItem = todoItem,
                    onCheckItem = { onAction(TodoAction.OnToggleTodoItem(todoItem)) },
                    onDeleteItem = { onAction(TodoAction.DeleteTodoItem(todoItem)) }
                )
            }
        }
        Row(
            modifier = Modifier.weight(1f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Column(
                modifier = Modifier,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                TextField(
                    value = state.newTitle,
                    onValueChange = {
                        onAction(TodoAction.OnTitleChange(it))
                    },
                    placeholder = { Text(text = "Title") }
                )
                TextField(
                    value = state.newDescription,
                    onValueChange = {
                        onAction(TodoAction.OnDescriptionChange(it))
                    },
                    placeholder = { Text(text = "Description") }
                )
            }
            Button(
                onClick = {
                    onAction(TodoAction.AddTodoItem)
                }
            ) { Text(text = "Add") }
        }
    }
}

@Composable
fun TodoItem(
    todoItem: TodoItem,
    modifier: Modifier = Modifier,
    onCheckItem: (Boolean) -> Unit,
    onDeleteItem: () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = todoItem.title,
                fontWeight = FontWeight.Bold,
                textDecoration = if (todoItem.isChecked) {
                    TextDecoration.LineThrough
                } else TextDecoration.None
            )
            Text(
                text = todoItem.description,
                textDecoration = if (todoItem.isChecked) {
                    TextDecoration.LineThrough
                } else TextDecoration.None
            )
        }
        Checkbox(
            checked = todoItem.isChecked,
            onCheckedChange = onCheckItem
        )
        IconButton(onClick = onDeleteItem) {
            Icon(
                imageVector = Icons.Default.Delete,
                contentDescription = null
            )
        }
    }
}

@Preview(
    showBackground = true
)
@Composable
private fun StateHomeworkRootPreview() {
    JetpackComposeMasterclassTheme {
        StateHomeworkRootScreen()
    }
}