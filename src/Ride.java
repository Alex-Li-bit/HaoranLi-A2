import java.io.*;
import java.util.*;

public class Ride implements RideInterface {

    private String rideName;
    private Employee operator;

    private Queue<Visitor> queue = new LinkedList<>();
    private LinkedList<Visitor> rideHistory = new LinkedList<>();

    private int maxRiders = 3;
    private int numOfCycles = 0;

    public Ride(String rideName, Employee operator) {
        this.rideName = rideName;
        this.operator = operator;
    }

    // === Queue Methods ===
    @Override
    public void addVisitorToQueue(Visitor v) {
        queue.add(v);
    }

    // Now returns the removed Visitor (or null if empty)
    @Override
    public Visitor removeVisitorFromQueue() {
        Visitor removed = queue.poll();
        if (removed != null) {
            System.out.println("Removed from queue: " + removed.getName());
        } else {
            System.out.println("Queue is empty.");
        }
        return removed;
    }

    @Override
    public void printQueue() {
        System.out.println("Visitor Queue:");
        if (queue.isEmpty()) {
            System.out.println("(empty)");
            return;
        }
        for (Visitor v : queue) {
            System.out.println(v.getName() + " (" + v.getAge() + ")");
        }
    }

    // === History Methods ===
    @Override
    public void addVisitorToHistory(Visitor v) {
        if (v != null) rideHistory.add(v);
    }

    @Override
    public boolean checkVisitorFromHistory(Visitor v) {
        if (v == null) return false;
        for (Visitor visitor : rideHistory) {
            if (visitor.getName().equalsIgnoreCase(v.getName())
                    && visitor.getAge() == v.getAge()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int numberOfVisitors() {
        return rideHistory.size();
    }

    @Override
    public void printRideHistory() {
        System.out.println("Ride History:");
        Iterator<Visitor> it = rideHistory.iterator();
        while (it.hasNext()) {
            Visitor v = it.next();
            System.out.println(v.getName() + " (" + v.getAge() + ")");
        }
    }

    // === Part 4B Sort Method ===
    public void sortRideHistory(Comparator<Visitor> comparator) {
        Collections.sort(rideHistory, comparator);
    }

    // === Part 5 runOneCycle ===
    @Override
    public void runOneCycle() {
        if (operator == null) {
            System.out.println("No operator assigned. Cannot run cycle.");
            return;
        }
        if (queue.isEmpty()) {
            System.out.println("Queue is empty. Nothing to run.");
            return;
        }

        int riders = Math.min(maxRiders, queue.size());
        for (int i = 0; i < riders; i++) {
            Visitor v = queue.poll();
            if (v != null) {
                rideHistory.add(v);
            }
        }
        numOfCycles++;
        System.out.println("Cycle completed. Riders this cycle: " + riders + ". Total cycles: " + numOfCycles);
    }

    // === Part 6 Export CSV ===
    public void exportRideHistory(String filename) {
        if (rideHistory.isEmpty()) {
            System.out.println("No ride history to export.");
            return;
        }

        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Visitor v : rideHistory) {
                // Use name,age,phone,ticketType,height if available
                String phone = (v.getPhone() == null) ? "" : v.getPhone();
                String ticket = (v.getTicketType() == null) ? "" : v.getTicketType();
                String height = String.valueOf(v.getHeight());
                writer.println(escapeCsv(v.getName()) + "," + v.getAge() + "," + escapeCsv(phone) + "," + escapeCsv(ticket) + "," + height);
            }
            System.out.println("Ride history exported successfully to: " + filename);
        } catch (IOException e) {
            System.out.println("Error exporting: " + e.getMessage());
        }
    }

    // === Part 7 Import CSV ===
    public void importRideHistory(String filename) {
        rideHistory.clear();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Split on commas that are not inside quotes - simple approach assumes no commas in fields
                String[] parts = line.split(",");
                if (parts.length >= 2) {
                    String name = unescapeCsv(parts[0].trim());
                    int age = Integer.parseInt(parts[1].trim());

                    // if phone/ticket/height exist parse them, else use defaults
                    String phone = (parts.length > 2) ? unescapeCsv(parts[2].trim()) : "";
                    String ticket = (parts.length > 3) ? unescapeCsv(parts[3].trim()) : "";
                    double height = 0.0;
                    if (parts.length > 4) {
                        try {
                            height = Double.parseDouble(parts[4].trim());
                        } catch (NumberFormatException nfe) {
                            height = 0.0;
                        }
                    }
                    Visitor v = new Visitor(name, age, phone, ticket, height);
                    rideHistory.add(v);
                }
            }
            System.out.println("Ride history imported from: " + filename);
        } catch (FileNotFoundException fnf) {
            System.out.println("Import file not found: " + filename);
        } catch (IOException ioe) {
            System.out.println("Error importing: " + ioe.getMessage());
        } catch (NumberFormatException nfe) {
            System.out.println("Invalid number in CSV: " + nfe.getMessage());
        }
    }

    // simple CSV escape helpers
    private String escapeCsv(String value) {
        if (value == null) return "";
        String s = value;
        if (s.contains(",") || s.contains("\"") || s.contains("\n")) {
            s = s.replace("\"", "\"\"");
            s = "\"" + s + "\"";
        }
        return s;
    }

    private String unescapeCsv(String value) {
        if (value == null) return "";
        String s = value;
        s = s.trim();
        if (s.startsWith("\"") && s.endsWith("\"") && s.length() >= 2) {
            s = s.substring(1, s.length() - 1).replace("\"\"", "\"");
        }
        return s;
    }

    // Expose rideHistory if needed
    public LinkedList<Visitor> getRideHistory() {
        return rideHistory;
    }
}