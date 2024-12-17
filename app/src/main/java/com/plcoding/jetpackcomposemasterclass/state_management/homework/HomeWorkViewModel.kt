package com.plcoding.jetpackcomposemasterclass.state_management.homework

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class TodoListViewModel: ViewModel() {

    private val _state = MutableStateFlow(TodoListState())
    val state = _state.asStateFlow()

    fun onAction(action: TodoListAction) {
        when(action) {
            TodoListAction.OnAddTodoClick -> {
                val title = state.value.newTodoTitle
                val description = state.value.newTodoDescription
                if(title.isNotBlank()) {
                    val newTodo = Todo(
                        title = title.trim(),
                        description = description.trim(),
                        isChecked = false
                    )
                    _state.update { it.copy(
                        todos = it.todos + newTodo,
                        newTodoTitle = "",
                        newTodoDescription = ""
                    ) }
                }
            }
            is TodoListAction.OnDeleteTodoClick -> {
                _state.update { it.copy(
                    todos = it.todos.filter { it != action.todo }
                ) }
            }
            is TodoListAction.OnDescriptionChange -> {
                _state.update { it.copy(
                    newTodoDescription = action.description
                ) }
            }
            is TodoListAction.OnTitleChange -> {
                _state.update { it.copy(
                    newTodoTitle = action.title
                ) }
            }
            is TodoListAction.OnToggleTodo -> {
                _state.update { it.copy(
                    todos = it.todos.map {
                        if(it == action.todo) {
                            it.copy(isChecked = !it.isChecked)
                        } else it
                    }
                ) }
            }
        }
    }
}

data class TodoListState(
    val todos: List<Todo> = (1..15).map {
        Todo(
            title = "Todo item $it",
            description = "Todo description $it",
            isChecked = false
        )
    },
    val newTodoTitle: String = "",
    val newTodoDescription: String = "",
)

sealed interface TodoListAction {
    data object OnAddTodoClick: TodoListAction
    data class OnDeleteTodoClick(val todo: Todo): TodoListAction
    data class OnToggleTodo(val todo: Todo): TodoListAction
    data class OnTitleChange(val title: String): TodoListAction
    data class OnDescriptionChange(val description: String): TodoListAction
}