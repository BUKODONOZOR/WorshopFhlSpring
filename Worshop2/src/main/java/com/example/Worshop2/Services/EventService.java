package com.example.Worshop2.Services;


import com.example.Worshop2.Models.Event;
import com.example.Worshop2.Repositorys.EventRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {
    @Autowired
    private EventRepositoy eventRepositoy;

    public List<Event> getAllEvents(){
        return eventRepositoy.findAll();
    }

    public Event saveNewEvent(Event event){
        return  eventRepositoy.save(event);
    }

    public Event getEventById(Long id){
        return eventRepositoy.findById(id).orElse(null);
    }

    public void deleteEvent(Long id){
        eventRepositoy.deleteById(id);
    }
}

