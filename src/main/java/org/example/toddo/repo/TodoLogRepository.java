package org.example.toddo.repo;

import org.example.toddo.entity.TodoLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoLogRepository extends JpaRepository<TodoLog, Long> {
}