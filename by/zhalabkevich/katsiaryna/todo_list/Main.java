package by.zhalabkevich.katsiaryna.todo_list;

import by.zhalabkevich.katsiaryna.todo_list.entity.Task;
import by.zhalabkevich.katsiaryna.todo_list.logic.IScheduler;
import by.zhalabkevich.katsiaryna.todo_list.logic.SchedulerImpl;
import by.zhalabkevich.katsiaryna.todo_list.logic.util.Validator;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        /**
         * The following is the example of how the scheduler may be used
         */
        List<Task> tasks = Arrays.asList(
                new Task("E", Arrays.asList("B")),
                new Task("D", Arrays.asList("A", "B")),
                new Task("A", Arrays.asList()),
                new Task("B", Arrays.asList("A")),
                new Task("C", Arrays.asList("D", "B")),
                new Task("F", Arrays.asList("E"))

/**
 * Incorrect data to show validation 2
 */
//                new Task("E", Arrays.asList()),
//                new Task("D", Arrays.asList("A", "B", "C", "E", "F")),
//                new Task("A", Arrays.asList("B", "C", "D", "E", "F")),
//                new Task("B", Arrays.asList("A", "C", "E", "F")),
//                new Task("C", Arrays.asList("A", "B", "D", "E")),
//                new Task("F", Arrays.asList("A", "B", "D", "E"))

/**
 * Incorrect data to show validation 1
 */

//                new Task("E", Arrays.asList("A", "B", "C", "F")),
//                new Task("D", Arrays.asList("A", "B", "C", "E", "F")),
//                new Task("A", Arrays.asList("B", "C", "D", "E", "F")),
//                new Task("B", Arrays.asList("A", "C", "E", "F")),
//                new Task("C", Arrays.asList("A", "B", "D", "E")),
//                new Task("F", Arrays.asList("A", "B", "D", "E"))
        );

        if (!Validator.hasEmptyList(tasks)) {
            System.out.println("Task's list is not valid! One of tasks should have an empty list!");
        } else {
            IScheduler scheduler = new SchedulerImpl();
            List<Task> sortedTasks = scheduler.schedule(tasks);
            if (Validator.hasDependencies(sortedTasks)) {
                System.out.println("Task's list is not valid! Two or more tasks have loop references!");
            } else {

                for (Task t : sortedTasks) {
                    System.out.println(t);
                }
            }
        }
    }
}
