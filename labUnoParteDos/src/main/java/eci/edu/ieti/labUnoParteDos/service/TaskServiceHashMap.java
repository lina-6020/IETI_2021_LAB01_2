package eci.edu.ieti.labUnoParteDos.service;

import eci.edu.ieti.labUnoParteDos.datos.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@Service
public class TaskServiceHashMap implements  TaskService{
    private HashMap<String,Task> usersHashMap=new HashMap<>();
    @Override
    public Task create(Task task) {
        usersHashMap.put(task.getId(),task);
        return task;
    }

    @Override
    public Task findById(String id) {
        Task found=usersHashMap.get(id);
        if(found!=null){
            return found;
        }
        return null;
    }

    @Override
    public List<Task> all() {
        List<Task> allUsers = new ArrayList<>();
        for(String id: usersHashMap.keySet()){
            allUsers.add(usersHashMap.get(id));
        }
        return allUsers;
    }

    @Override
    public void deleteById(String id) {
        usersHashMap.remove(id);
    }

    @Override
    public Task update(Task task, String taskId) {
        usersHashMap.put(taskId,task);
        return task;
    }
}
