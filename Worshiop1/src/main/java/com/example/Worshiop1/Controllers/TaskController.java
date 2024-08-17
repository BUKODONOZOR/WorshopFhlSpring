package com.example.Worshiop1.Controllers;

import com.example.Worshiop1.Models.Task;
import com.example.Worshiop1.Services.TaskServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskServices taskServices;

    @GetMapping
    public String listTasks(Model model) {
        model.addAttribute("tasks", taskServices.getAllTasks());
        return "task";
    }

    @GetMapping("/new")
    public String showNewTaskForm(Model model) {
        model.addAttribute("task", new Task());
        return "new-task";
    }

    @PostMapping
    public String saveTask(@ModelAttribute("task") Task task) {
        taskServices.saveNewTask(task);
        return "redirect:/tasks";
    }

    @GetMapping("/edit/{id}")
    public String showEditTaskForm(@PathVariable("id") Long id, Model model) {
        Task task = taskServices.getTaskById(id);
        if (task != null) {
            model.addAttribute("task", task);
            return "edit-task";
        } else {
            return "redirect:/tasks";
        }
    }

    @PostMapping("/update/{id}")
    public String updateTask(@PathVariable("id") Long id, @ModelAttribute("task") Task updatedTask) {
        Task existingTask = taskServices.getTaskById(id);
        if (existingTask != null) {
            existingTask.setTitle(updatedTask.getTitle());
            existingTask.setDescription(updatedTask.getDescription());
            existingTask.setStatus(updatedTask.getStatus());
            taskServices.saveNewTask(existingTask);
        }
        return "redirect:/tasks";
    }

    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable("id") Long id) {
        taskServices.deleteTask(id);
        return "redirect:/tasks";
    }
}
