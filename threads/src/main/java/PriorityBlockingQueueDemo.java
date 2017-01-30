public class PriorityBlockingQueueDemo {
    public static void main(String[] args) {
        QueueTask pbQueue = new QueueTask();
        for (int i = 0; i < 10; i++) {
            pbQueue.setTask(new Task(i));
        }

        Manager manager1 = new Manager(pbQueue, "Jonh");
        Manager manager2 = new Manager(pbQueue, "Pol");

        Thread th1 = new Thread(manager1);
        Thread th2 = new Thread(manager2);

        th1.start();
        th2.start();

        try {
            th1.join();
            th2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
