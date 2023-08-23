package com.example.todolist.Contorller;

import com.example.todolist.domain.ToDo;
import com.example.todolist.repository.ToDoRepository;
import com.example.todolist.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TodoController {

    @Autowired
    private ToDoRepository toDoRepository;

    @Autowired
    private Service service;

    @GetMapping("/")
    public String index(Model model) {
        List<ToDo> todos = toDoRepository.findAll();
        model.addAttribute("todos", todos);
        return "todos";
    }

    @PostMapping("/addTodo")
    public String addTodo(@RequestParam("todo") String todo) {
        // database 에 저장
        ToDo toDo = new ToDo();
        toDo.setTodo(todo);
        toDoRepository.save(toDo);
        return "redirect:/";
    }

    @PostMapping("/deleteList/{id}")
    public String delete(@PathVariable("id") Long id) {
        service.delete(id);
        return "redirect:/";
    }
}
