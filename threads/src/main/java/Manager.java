public class Manager implements Runnable {
    private QueueTask pbQ;
    private String name;
    public Manager(QueueTask q, String n) {
        pbQ = q;
        name = n;
    }
    public void run() {
        Task task;
        while ((task = pbQ.getTask()) != null) {
            System.out.println(name +
                    " get task number " +
                    task.getTaskNumer());
        }
    }
}
