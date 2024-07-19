package org.example.toddo.listener;

import lombok.RequiredArgsConstructor;
import org.example.toddo.entity.Todo;
import org.example.toddo.entity.TodoLog;
import org.example.toddo.events.TodoChangeEvent;
import org.example.toddo.repo.TodoLogRepository;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.swing.event.ChangeEvent;

@Component
@RequiredArgsConstructor
public class TodoListener {


    private final TodoLogRepository todoLogRepository;

    @EventListener
    public void handleChangeEvent(TodoChangeEvent event) {
        Todo todo = event.getTodo();
        todoLogRepository.save(
                TodoLog.builder()
                        .toDoId(todo.getId())
                        .completed(todo.isCompleted())
                        .title(todo.getTitle())
                        .description(todo.getDescription())
                        .build()
        );

    }
}
