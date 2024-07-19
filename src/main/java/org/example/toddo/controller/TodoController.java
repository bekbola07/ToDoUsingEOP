package org.example.toddo.controller;

import lombok.RequiredArgsConstructor;
import org.example.toddo.entity.Todo;
import org.example.toddo.service.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/todos")
@RequiredArgsConstructor
public class TodoController {


    private final TodoService todoService;

    @GetMapping
    public String listTodos(Model model) {
        List<Todo> todos = todoService.findAll();

        model.addAttribute("todos", todos);
        return "todos/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("todo", new Todo());
        return "todos/create";
    }

    @PostMapping
    public String createTodo(@ModelAttribute Todo todo) {
        todoService.save(todo);
        return "redirect:/todos";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Optional<Todo> todo = todoService.findById(id);
        if (todo.isPresent()) {
            model.addAttribute("todo", todo.get());
            return "todos/edit";
        } else {
            return "redirect:/todos";
        }
    }

    @PostMapping("/update/{id}")
    public String updateTodo(@PathVariable Long id, @ModelAttribute Todo todo) {
        todo.setId(id);
        todoService.save(todo);
        return "redirect:/todos";
    }

    @GetMapping("/delete/{id}")
    public String deleteTodo(@PathVariable Long id) {
        todoService.deleteById(id);
        return "redirect:/todos";
    }
}
