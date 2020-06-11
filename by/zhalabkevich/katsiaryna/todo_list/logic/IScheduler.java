package by.zhalabkevich.katsiaryna.todo_list.logic;

import by.zhalabkevich.katsiaryna.todo_list.entity.Task;

import java.util.List;

public interface IScheduler {

    List<Task> schedule(List<Task> tasks);
}
