package main;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import response.Task;

import java.util.List;

@RestController
public class TaskController {

    //получить список задач
    @GetMapping("/tasks/")
    public List<Task> list() {
        return Storage.getAllTasks();
    }

    //добавить задачу
    @PostMapping("/tasks/")
    public int add(Task task) {
        return Storage.addTask(task);
    }

    //получить задачу по id
    @GetMapping("/tasks/{id}")
    public Task get(@PathVariable int id) {
        return Storage.getTask(id);
    }

    //удалить задачу
    @DeleteMapping("/tasks/{id}")
    public HttpStatus delete(@PathVariable int id) {
        if (Storage.getTask(id) == null) {
            return HttpStatus.NOT_FOUND;
        }
        Storage.deleteTask(id);
        return HttpStatus.OK;
    }

    //удалить все задачи
    @DeleteMapping("/tasks/")
    public List<Task> deleteAll() {
        return Storage.deleteAllTasks();
    }

    //редактировать статус задачи
    @PutMapping("/tasks/{id}")
    public Task editStatus(@PathVariable int id) {
        return Storage.editTaskStatus(id);
    }

    //редактировать задачу
    @PutMapping("/tasks/")
    public Task editTask(Task newTask) {
        return Storage.editTask(newTask);
    }
}
