package tp10;

public class UsePrioritySchedulingQueue
{
    public static void main(String[] args)
    {
        PrioritySchedulingQueue<Task> tasks = new PrioritySchedulingQueue<>();
        
        Task t1 = new Task("t1", 3);
        Task t2 = new Task("t2", 1);
        Task t3 = new Task("t3", 2);
        Task t4 = new Task("t4", 5);
        Task t5 = new Task("t5", 10);

        System.out.println(tasks.isEmpty());
        tasks.addElement(t1);
        tasks.addElement(t2);
        tasks.addElement(t3);
        tasks.addElement(t4);
        tasks.addElement(t5);
        System.out.println(tasks.isEmpty());
        System.out.println(tasks.size());
        System.out.println(tasks.highestPriority());
        System.out.println("\nFinish !");
    }    
}