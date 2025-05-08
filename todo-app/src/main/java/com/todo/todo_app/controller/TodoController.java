package com.todo.todo_app.controller;

import java.io.PrintWriter;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.todo.todo_app.model.Todo;
import com.todo.todo_app.service.TodoService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class TodoController {
    private final TodoService service;

    @GetMapping("/")
    public String home(Model model) {
        List<Todo> todos = service.getTodos();
        model.addAttribute("todos", todos);
        return "index";
    }

    @PostMapping("/add")
    public String addTodo(@RequestParam String task) {
        service.addTodo(task);
        return "redirect:/";
    }

    @GetMapping("/toggle/{id}")
    public String toggleTodo(@PathVariable int id) {
        service.toggleTodo(id);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteTodo(@PathVariable int id) {
        service.deleteTodo(id);
        return "redirect:/";
    }
}
