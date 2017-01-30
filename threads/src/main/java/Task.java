import java.util.Random;

public class Task implements Comparable<Task> {
    private int taskNumer;

    public Task(int num) {
        taskNumer = num;
    }

    public int getTaskNumer() {
        return taskNumer;
    }

    public void setTaskNumer(int taskNumer) {
        this.taskNumer = taskNumer;
    }

    @Override
    public int compareTo(Task o) {
        Random rand = new Random();
        int comp = rand.nextInt(2000);
        if (comp % 2 == 0) return 1;
        if (comp % 3 == 0) return -1;
        else return 0;
    }
}
