import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Comparator;
import java.util.Collections;

public class Ride implements RideInterface {

    private String rideName;
    private Employee operator;
    private int maxRider; // keep for later parts

    private Queue<Visitor> waitQueue = new LinkedList<>();
    private LinkedList<Visitor> rideHistory = new LinkedList<>();

    public Ride(String rideName, Employee operator) {
        this.rideName = rideName;
        this.operator = operator;
        this.maxRider = 0;
    }

    public Ride(String rideName, Employee operator, int maxRider) {
        this.rideName = rideName;
        this.operator = operator;
        this.maxRider = maxRider;
    }

    // ===== Getters/Setters =====
    public String getRideName() { return rideName; }
    public void setRideName(String rideName) { this.rideName = rideName; }

    public Employee getOperator() { return operator; }
    public void setOperator(Employee operator) { this.operator = operator; }

    public int getMaxRider() { return maxRider; }
    public void setMaxRider(int maxRider) { this.maxRider = maxRider; }

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
        if (waitQueue.isEmpty()) {
            System.out.println("(empty)");
            return;
        }
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

    // ===================== Part 4B: Sort History (kept) ======================
    public void sortRideHistory(Comparator<Visitor> comparator) {
        Collections.sort(rideHistory, comparator);
    }

    // ===================== Part 6: exportRideHistory ======================
    /**
     * Export the rideHistory LinkedList to a CSV file.
     * Each line format: name,age,phone,ticketType,height
     *
     * @param filename name of the file to write (relative to working directory or absolute)
     */
    public void exportRideHistory(String filename) {
        // Defensive check
        if (rideHistory.isEmpty()) {
            System.out.println("No ride history to export.");
            return;
        }

        // Use try-with-resources for safe writer closing
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            // Optional: write header (uncomment if you want header line)
            // writer.println("name,age,phone,ticketType,height");

            for (Visitor v : rideHistory) {
                // Build CSV line. Trim to avoid accidental spaces.
                StringBuilder line = new StringBuilder();
                line.append(safeCsv(v.getName())).append(",");
                line.append(v.getAge()).append(",");
                line.append(safeCsv(v.getPhone())).append(",");
                line.append(safeCsv(v.getTicketType())).append(",");
                line.append(v.getHeight());
                writer.println(line.toString());
            }

            System.out.println("Ride history exported successfully to: " + filename);
        } catch (IOException e) {
            System.out.println("Error exporting ride history: " + e.getMessage());
            // Optionally print stack trace during debugging:
            // e.printStackTrace();
        }
    }

    // Helper to escape simple CSV issues (if value contains comma or quotes)
    private String safeCsv(String value) {
        if (value == null) return "";
        String s = value.trim();
        if (s.contains(",") || s.contains("\"") || s.contains("\n")) {
            // escape quotes by doubling them, and wrap in quotes
            s = s.replace("\"", "\"\"");
            return "\"" + s + "\"";
        }
        return s;
    }

    // ===================== Placeholder for Part 5 (runOneCycle) ======================
    @Override
    public void runOneCycle() {
        System.out.println("runOneCycle not implemented in this Ride version.");
    }

    // Expose rideHistory for tests (not required but convenient)
    public LinkedList<Visitor> getRideHistory() {
        return rideHistory;
    }
}