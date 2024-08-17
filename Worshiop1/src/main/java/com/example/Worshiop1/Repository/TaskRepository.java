package com.example.Worshiop1.Repository;

import com.example.Worshiop1.Models.Task;
import org.springframework.data.jpa.repository.JpaRepository;



public interface TaskRepository extends JpaRepository<Task, Long> {
}
