package org.example.toddo.service;

import lombok.RequiredArgsConstructor;
import org.example.toddo.entity.Todo;
import org.example.toddo.events.TodoChangeEvent;
import org.example.toddo.repo.TodoRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final ApplicationEventPublisher eventPublisher;

    private final TodoRepository todoRepository;

    public List<Todo> findAll() {
        return todoRepository.findAll();
    }

    public Optional<Todo> findById(Long id) {
        return todoRepository.findById(id);
    }

    public void save(Todo todo) {
        todoRepository.save(todo);
        eventPublisher.publishEvent(new TodoChangeEvent(todo));
    }

    public void deleteById(Long id) {
        todoRepository.deleteById(id);
    }
}
