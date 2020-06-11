package by.zhalabkevich.katsiaryna.todo_list.logic.util;

import by.zhalabkevich.katsiaryna.todo_list.entity.Task;

import java.util.List;

public class Validator {
    public static boolean hasDependencies(List<Task> tasks) {

        for(int i=0;i<tasks.size()-1;i++){
          if(tasks.get(i).getPredecessors().contains(tasks.get(i+1).getName())&&tasks.get(i+1).getPredecessors().contains(tasks.get(i).getName())){
              return true;
            }
        }
        return false;
    }

    public static boolean hasEmptyList(List<Task> tasks){
        for(Task t:tasks){
            if(t.getPredecessors().size()==0){
                return true;
            }
        }
        return false;
    }
}
