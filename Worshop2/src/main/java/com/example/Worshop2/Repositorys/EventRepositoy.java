package com.example.Worshop2.Repositorys;

import com.example.Worshop2.Models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepositoy extends JpaRepository <Event, Long> {
}
