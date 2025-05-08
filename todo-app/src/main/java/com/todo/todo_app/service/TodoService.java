package com.todo.todo_app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.todo.todo_app.model.Todo;

@Service
public class TodoService {
    private final List<Todo> todos;
    private static int idCounter;

    public TodoService(List<Todo> todos) {
        // todos = new ArrayList<>(); // core concept
        this.todos = todos;
    }

    public void addTodo(String task) {
        if (!task.isEmpty() && !task.isBlank()) {
            Todo todo = new Todo();
            todo.setId(++idCounter);
            todo.setTask(task);

            for (Todo existingTodo : todos) {
                if (existingTodo.getTask().equals(task)) {
                    return;
                }
            }

            todos.add(todo);
        }
    }

    public List<Todo> getTodos() {
        return todos;
    }

    public void toggleTodo(int id) {
        Todo todo = getTodoById(id);
        if (todo != null) {
            todo.setCompleted(!todo.isCompleted());
        }
    }

    public void deleteTodo(int id) {
        Todo todo = getTodoById(id);
        if (todo != null) {
            todos.remove(todo);
        }
    }

    private Todo getTodoById(int id) {
        for (Todo todo : todos) {
            if (todo.getId() == id) {
                return todo;
            }
        }
        return null;
    }
}
