package com.example.todolist.service;

import com.example.todolist.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@org.springframework.stereotype.Service
public class Service {
    @Autowired
    private ToDoRepository toDoRepository;

    @Transactional
    public void delete(Long id) {
        toDoRepository.deleteById(id);
    }
}
