package org.example.toddo.events;

import lombok.Getter;
import lombok.Value;
import org.example.toddo.entity.Todo;

@Value
@Getter
public class TodoChangeEvent {
    Todo todo;
}
