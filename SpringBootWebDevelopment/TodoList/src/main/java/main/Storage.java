package main;

import response.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class Storage {
    private static int currentId = 1;
    //создаем потокобезопасную хэш-карту
    private static final ConcurrentHashMap<Integer, Task> tasks = new ConcurrentHashMap<>();

    //получить список всех задач
    public static List<Task> getAllTasks() {
        return new ArrayList<>(tasks.values());
    }

    //добавление задачи
    public static int addTask(Task task) {
        int id = currentId++;
        task.setId(id);
        tasks.put(id, task);
        return id;
    }

    //получить задачу по id
    public static Task getTask(int id) {
        System.out.println(tasks.get(id));
       return tasks.get(id);
    }

    //удалить все задачи
    public static List<Task> deleteAllTasks() {
        tasks.clear();
        return new ArrayList<>(tasks.values());
    }

    //удалить задачу
    public static void deleteTask(int id) {
        tasks.remove(id);
    }

    //редактировать статус задачи
    public static Task editTaskStatus(int id) {
        Task task = Storage.getTask(id);
        if (task != null) {
            task.setDone(true);
            tasks.replace(id, task);
            return task;
        }
        return null;
    }

    //редактировать задачу
    public static Task editTask(Task newTask) {
        Task task = Storage.getTask(newTask.getId());
        if (task != null) {
            tasks.replace(task.getId(), newTask);
            return newTask;
        }
        return null;
    }
}
