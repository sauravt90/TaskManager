package com.task.taskManager.controllers;


import com.task.taskManager.models.task.Task;
import com.task.taskManager.models.task.TaskDTO;
import com.task.taskManager.service.TaskManagerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
@CrossOrigin("*")
public class TaskController {


    private final TaskManagerService taskManagerService;

    public TaskController(TaskManagerService taskManagerService) {
        this.taskManagerService = taskManagerService;
    }


    @PostMapping("/createTask")
    public Task createTask(@RequestBody TaskDTO taskDTO){
            return taskManagerService.createTask(taskDTO);
    }


    @GetMapping("/getAll")
    public List<Task> getAllTasks(@RequestParam(required = false) String limit,@RequestParam(required = false) String offset){
        return taskManagerService.getAllTask(limit,offset);
    }


    @PostMapping("/updateTask")
    public Task updateTask(@RequestBody Task task){
        return taskManagerService.updateTask(task);
    }

    @DeleteMapping("/deleteTask")
    public void deleteTask(@RequestParam String taskId){
        int id = Integer.valueOf(taskId);
        taskManagerService.deleteTask(id);
    }



}
