import java.util.*;

public class Ride implements RideInterface {
    private String rideName;
    private Employee operator; // 操作员
    private int maxRider;

    // Part3~Part4B 会使用的队列和历史
    private Queue<Visitor> visitorQueue = new LinkedList<>();
    private LinkedList<Visitor> rideHistory = new LinkedList<>();

    public Ride() {}

    public Ride(String rideName, Employee operator, int maxRider) {
        this.rideName = rideName;
        this.operator = operator;
        this.maxRider = maxRider;
    }

    // Getters & Setters
    public String getRideName() { return rideName; }
    public void setRideName(String rideName) { this.rideName = rideName; }

    public Employee getOperator() { return operator; }
    public void setOperator(Employee operator) { this.operator = operator; }

    public int getMaxRider() { return maxRider; }
    public void setMaxRider(int maxRider) { this.maxRider = maxRider; }

    // ========== RideInterface Methods ==========
    @Override
    public void addVisitorToQueue(Visitor v) {
        visitorQueue.add(v);
    }

    @Override
    public void removeVisitorFromQueue() {
        visitorQueue.poll();
    }

    @Override
    public void printQueue() {
        System.out.println("Visitor Queue:");
        for (Visitor v : visitorQueue) {
            System.out.println(v.getName() + " (" + v.getAge() + ")");
        }
    }

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
        for (Visitor v : rideHistory) {
            System.out.println(v.getName() + " (" + v.getAge() + ")");
        }
    }

    @Override
    public void runOneCycle() {
        System.out.println("Run one cycle: Not implemented yet for Part 2.");
    }
}