package heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TaskManager {
    Map<Integer,Integer> taskToUserMap;
    Map<Integer,Integer> taskToPriorityMap;
    PriorityQueue<Task> pq;
    public TaskManager(List<List<Integer>> tasks) {
        taskToUserMap = new HashMap<>();
        taskToPriorityMap = new HashMap<>();
        pq = new PriorityQueue<>(new Comparator<Task>(){
            public int compare(Task t1,Task t2){
                if(t1.priority==t2.priority){
                    return t2.taskId - t1.taskId;
                }
                return t2.priority - t1.priority;
            }
        });
        for(int i=0;i<tasks.size();i++){
            taskToUserMap.put(tasks.get(i).get(1),tasks.get(i).get(0));
            taskToPriorityMap.put(tasks.get(i).get(1),tasks.get(i).get(2));
            pq.add(new Task(tasks.get(i).get(1),tasks.get(i).get(2)));
        }

    }
    
    public void add(int userId, int taskId, int priority) {
        taskToUserMap.put(taskId,userId);
        taskToPriorityMap.put(taskId,priority);
        pq.add(new Task(taskId,priority));
    }
    
    public void edit(int taskId, int newPriority) {
        taskToPriorityMap.put(taskId,newPriority);

    }
    
    public void rmv(int taskId) {
        taskToUserMap.remove(taskId);
        taskToPriorityMap.remove(taskId);
    }
    
    public int execTop() {
        
        while(!pq.isEmpty()){
            Task temp = pq.peek();
            if(!taskToUserMap.containsKey(temp.taskId)){
                pq.poll();
            }
            else if(temp.priority != taskToPriorityMap.get(temp.taskId)){
                pq.poll();
                temp.priority = taskToPriorityMap.get(temp.taskId);
                pq.add(new Task(temp.taskId,temp.priority));
            }
            else{
                Task temp1 = pq.poll();
                return taskToUserMap.get(temp1.taskId);
                
            }

        }
        return -1;
    }
    public static void main(String[] args) {
        List<List<Integer>> al = new ArrayList<>();
        List<Integer> al1 = new ArrayList<>();
        al1.add(2);
        al1.add(12);
        al1.add(32);
        al.add(al1);

        al1 = new ArrayList<>();
        al1.add(3);
        al1.add(27);
        al1.add(33);
        al.add(al1);

        al1 = new ArrayList<>();
        al1.add(10);
        al1.add(5);
        al1.add(23);
        al.add(al1);

        al1 = new ArrayList<>();
        al1.add(8);
        al1.add(4);
        al1.add(3);
        al.add(al1);

        TaskManager t = new TaskManager(al);
        t.edit(4, 48);
        System.out.println(t.execTop());
    }
}
class Task{
    int taskId;
    int priority;
    Task(int taskId,int priority){
        this.taskId = taskId;
        this.priority = priority;
    }
}
