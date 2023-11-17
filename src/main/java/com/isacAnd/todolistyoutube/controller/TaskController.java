package com.isacAnd.todolistyoutube.controller;

import com.isacAnd.todolistyoutube.model.Task;
import com.isacAnd.todolistyoutube.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class TaskController {

    @Autowired
    TaskService taskService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Task createTask (@RequestBody Task task){
        return taskService.createTask(task);
    }

    @GetMapping("/list")
    @ResponseStatus(HttpStatus.OK)
    public List<Task> listAllTasks (){
        return taskService.listAllTasks();
    }

    @GetMapping("/get/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Task> getTaskById (@PathVariable (value = "id") Long id){
        return taskService.findTaskById(id);
    }

    @GetMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Task> updateTaskById (@RequestBody Task task, @PathVariable (value = "id") Long id){
        return taskService.updateTaskById(task, id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> deleteTaskById (@PathVariable (value = "id") Long id){
        return taskService.deleteTaskById(id);
    }
}
