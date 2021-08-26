package eci.edu.ieti.labUnoParteDos.controller;

import eci.edu.ieti.labUnoParteDos.datos.Task;
import eci.edu.ieti.labUnoParteDos.dto.TaskDto;
import eci.edu.ieti.labUnoParteDos.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
@RestController
@RequestMapping( "/v2/task" )
public class TaskController {
    private final TaskService taskService;

    public TaskController(@Autowired TaskService taskService )
    {
        this.taskService = taskService;
    }
    @GetMapping
    public ResponseEntity<List<Task>> all()
    {
        try{
            List<Task> Tasks=taskService.all();
            return new ResponseEntity<>(Tasks, HttpStatus.CREATED);
        }catch (Exception ex){
            Logger.getLogger(TaskController.class.getName()).log(Level.SEVERE,null,ex);
            return new ResponseEntity("No se a podido encontrar las tareas",HttpStatus.NOT_FOUND);
        }

    }
    @GetMapping( "/{id}" )
    public ResponseEntity<Task> findById(@PathVariable String id )
    {
        try{
            Task task=taskService.findById(id);
            return new ResponseEntity<>(task,HttpStatus.CREATED);
        }catch (Exception ex){
            Logger.getLogger(TaskController.class.getName()).log(Level.SEVERE,null,ex);
            return new ResponseEntity("No se pudo encontrar la tarea",HttpStatus.NOT_FOUND);
        }

    }
    @PostMapping()
    public ResponseEntity create(@RequestBody TaskDto taskDto){
        try{
            taskService.create(new Task(Integer.toString(taskService.all().size()+1),taskDto.getName(),taskDto.getDescription(),taskDto.getStatus(),taskDto.getAssignedTo(),LocalDateTime.now(),taskDto.getCreated()));
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (Exception ex){
            Logger.getLogger(TaskController.class.getName()).log(Level.SEVERE,null,ex);
            return new ResponseEntity<>("No se pudo crear la tarea",HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping( "/{id}" )
    public ResponseEntity<Task> update( @RequestBody TaskDto taskDto, @PathVariable String id )
    {
        try{
            taskService.update(new Task(id,taskDto.getName(),taskDto.getDescription(),taskDto.getStatus(),taskDto.getAssignedTo(),LocalDateTime.now(),taskDto.getCreated()),id);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (Exception ex){
            Logger.getLogger(TaskController.class.getName()).log(Level.SEVERE,null,ex);
            return new ResponseEntity("No se pudo actulizar la tarea",HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping( "/{id}" )
    public ResponseEntity<Boolean> delete( @PathVariable String id )
    {
        try {
            taskService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (Exception ex){
            Logger.getLogger(TaskController.class.getName()).log(Level.SEVERE,null,ex);
            return new ResponseEntity("No se pudo borrar la tarea",HttpStatus.NOT_FOUND);
        }
    }
}
