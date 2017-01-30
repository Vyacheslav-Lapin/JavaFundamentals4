import java.util.PriorityQueue;

public class QueueTask {
    private PriorityQueue<Task> queue = new PriorityQueue<>();
    public Task getTask() {
        return queue.poll();
    }

    public void setTask(Task task) {
        queue.add(task);
    }
    public PriorityQueue<Task> getQueue() {
        return queue;
    }
}
