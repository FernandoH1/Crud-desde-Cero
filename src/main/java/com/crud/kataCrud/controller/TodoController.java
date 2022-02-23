package com.crud.kataCrud.controller;

import com.crud.kataCrud.model.Todo;
import com.crud.kataCrud.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class TodoController {

    @Autowired
    private TodoService service;

    @GetMapping(value ="api/todos")
    public Iterable<Todo> list(){
        return service.list();
    }

    @PostMapping(value ="api/todos")
    public Todo save(Todo todo){
        return service.save(todo);
    }

    @PutMapping(value ="api/todos")
    public Todo update(@RequestBody Todo todo){
        if(todo.getId() != null){
            return service.save(todo);
        }
        throw new RuntimeException("No existe el id para actualizar");
    }

    @DeleteMapping(value = "api/{id}/todos")
    public void delete(Long id){
        service.delete(id);
    }

    @GetMapping(value = "api/{id}/todos")
    public Todo get(@PathVariable("id") Long id){
        return service.get(id);
    }

}
