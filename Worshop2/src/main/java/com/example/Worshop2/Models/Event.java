package com.example.Worshop2.Models;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @Column(name = "name" ,nullable = false)
    private String name;

    @Column(name = "date" , nullable = false)
    private LocalDate date;

    @Column(name = "place" , nullable = false)
    private String place;

    @Column(name = "capacity", nullable = true)
    private int capacity;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getPlace() {
        return place;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Event(){

    }

    public Event(Long id , String name , LocalDate date , String place , int capacity){
        this.id = id;
        this.name = name;
        this.date = date;
        this.place = place;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
