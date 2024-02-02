package com.task.taskManager.service;


import com.task.taskManager.models.task.Task;
import com.task.taskManager.models.task.TaskDTO;
import com.task.taskManager.repository.TaskRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskManagerService {


    private final TaskRepository taskRepository;

    public TaskManagerService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    public Task createTask(TaskDTO taskDTO){
        Task task = new Task();
        task.setTaskId(0);
        task.setTaskName(taskDTO.getTaskName());
        task.setTaskDescription(taskDTO.getTaskDescription());
        task.setTaskDate(taskDTO.getTaskDate());
        task.setTaskEndDate(taskDTO.getTaskEndDate());
        task.setTaskStatus(taskDTO.getTaskStatus());

        return  taskRepository.save(task);
    }

     public List<Task> getAllTask(String offset, String limit){


         int intLimit = 10;
         int intOffset = 1;
        if(limit != null && offset != null) {
             intLimit = Integer.valueOf(limit);
            intOffset = Integer.valueOf(offset);

            if (intLimit == 0) {
                intLimit = 10;
            }
        }

         Pageable pageable = PageRequest.of(intOffset,intLimit);
        List<Task> tasks  = taskRepository.findAll();
        return tasks;
     }


     public Task updateTask(Task task){
          return taskRepository.save(task);
     }

     public void deleteTask(int taskId){
          taskRepository.deleteById(taskId);
     }

}
