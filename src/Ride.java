import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Ride implements RideInterface {

    private String rideName;
    private Employee operator;

    private Queue<Visitor> waitQueue = new LinkedList<>();
    private LinkedList<Visitor> rideHistory = new LinkedList<>();

    public Ride(String rideName, Employee operator) {
        this.rideName = rideName;
        this.operator = operator;
    }

    // ===================== Queue Methods ======================
    @Override
    public void addVisitorToQueue(Visitor v) {
        waitQueue.add(v);
    }

    @Override
    public void removeVisitorFromQueue() {
        Visitor removed = waitQueue.poll();
        if (removed != null) {
            System.out.println("Removed from queue: " + removed.getName());
        } else {
            System.out.println("Queue is empty.");
        }
    }

    @Override
    public void printQueue() {
        System.out.println("Visitor Queue:");
        for (Visitor v : waitQueue) {
            System.out.println(v.getName() + " (" + v.getAge() + ")");
        }
    }

    // ===================== Ride History Methods ======================
    @Override
    public void addVisitorToHistory(Visitor v) {
        rideHistory.add(v);
    }

    @Override
    public boolean checkVisitorFromHistory(Visitor v) {
        return rideHistory.contains(v);
    }

    @Override
    public int numberOfVisitors() {
        return rideHistory.size();
    }

    @Override
    public void printRideHistory() {
        System.out.println("Ride History:");
        Iterator<Visitor> iterator = rideHistory.iterator();
        while (iterator.hasNext()) {
            Visitor v = iterator.next();
            System.out.println(v.getName() + " (" + v.getAge() + ")");
        }
    }

    // ===================== Placeholder for Part 5 ======================
    @Override
    public void runOneCycle() {
        System.out.println("Run one cycle: Not implemented yet (Part 5).");
    }
}