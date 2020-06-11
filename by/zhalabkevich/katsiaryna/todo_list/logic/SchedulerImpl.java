package by.zhalabkevich.katsiaryna.todo_list.logic;

import by.zhalabkevich.katsiaryna.todo_list.entity.Task;

import java.util.*;

public class SchedulerImpl implements IScheduler {

    private Map<String, Integer> frequency;

    @Override
    public List<Task> schedule(List<Task> tasks) {

        tasks.sort(new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {

                if (o1.getPredecessors().size() > o2.getPredecessors().size()) {
                    return 1;
                } else if (o1.getPredecessors().size() < o2.getPredecessors().size()) {
                    return -1;
                } else {
                    frequency = solveFrequency(tasks);
                    if (frequency.get(o1.getName()) > frequency.get(o2.getName())) {
                        return 1;
                    } else if (frequency.get(o1.getName()) < frequency.get(o2.getName())) {
                        return -1;
                    } else {
                        if (o1.getPredecessors().contains(o2.getName())) {
                            return 1;
                        } else if (o2.getPredecessors().contains(o1.getName())) {
                            return -1;
                        } else {
                            return 0;
                        }
                    }


                }

            }
        });

        return tasks;
    }

    private Map<String, Integer> solveFrequency(List<Task> tasks) {
        Map<String, Integer> frequency = new HashMap<>();
        for (Task t : tasks) {
            int count = 0;
            for (String str : t.getPredecessors()) {
                if (t.getName().equals(str)) {
                    count++;
                }
            }
            frequency.put(t.getName(), count);
        }

        return frequency;
    }


}
