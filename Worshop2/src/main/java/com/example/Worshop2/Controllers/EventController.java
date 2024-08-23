package com.example.Worshop2.Controllers;


import com.example.Worshop2.Models.Event;
import com.example.Worshop2.Services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tasks")
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping
    public String listTasks(Model model){
        model.addAttribute("events" , eventService.getAllEvents());
        return "event";
    }

    @GetMapping("/save")
    public String showNewTaskForm(Model model){
        model.addAttribute("event",new Event());
        return "new-event";
    }

    @PostMapping
    public String saveTask(@ModelAttribute("event") Event event){
        eventService.saveNewEvent(event);
        return "redirect:/events";
    }

    @GetMapping("/edit/{id}")
    public String showEditTaskForm(@PathVariable("id") Long id , Model model){
        Event event = eventService.getEventById(id);
        if(event != null){
            model.addAttribute("event",event);
            return "edit-event";
        }else {
            return "redirect/events";
        }
    }

    @PostMapping("/update/{id}")
    public String updateTask(@PathVariable("id") Long id , @ModelAttribute("event") Event updatedEvent){
        Event existingEvent = eventService.getEventById(id);
        if(existingEvent != null){
            existingEvent.setName(updatedEvent.getName());
            existingEvent.setDate(updatedEvent.getDate());
            existingEvent.setPlace(updatedEvent.getPlace());
            existingEvent.setCapacity(updatedEvent.getCapacity());
        }
        return  "redirect:/events";
    }

    @GetMapping("/delete/{id}")
    public String deleteEvent(@PathVariable("id") Long id){
        eventService.deleteEvent(id);
        return  "redirect:/events";
    }
}
