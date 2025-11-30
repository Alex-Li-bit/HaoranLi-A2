public class AssignmentTwo {

    public static void main(String[] args) {
        // ===== Create employee and visitors =====
        Employee operator = new Employee("Alice", 30, "123456789", "Operator", 5000);

        Visitor v1 = new Visitor("Bob", 20, "987654321", "VIP", 160);
        Visitor v2 = new Visitor("Charlie", 25, "555666777", "Regular", 170);
        Visitor v3 = new Visitor("Diana", 18, "111222333", "VIP", 155);
        Visitor v4 = new Visitor("Ethan", 22, "444555666", "Regular", 165);
        Visitor v5 = new Visitor("Fiona", 19, "777888999", "VIP", 158);

        // ===== Create ride =====
        Ride ride = new Ride("ThunderRide", operator);

        // ===== Queue demo (Part 3) =====
        System.out.println("=== Adding visitors to queue ===");
        ride.addVisitorToQueue(v1);
        ride.addVisitorToQueue(v2);
        ride.addVisitorToQueue(v3);
        ride.addVisitorToQueue(v4);
        ride.addVisitorToQueue(v5);
        ride.printQueue();

        System.out.println("\n=== Removing one visitor from queue ===");
        ride.removeVisitorFromQueue();
        ride.printQueue();

        // ===== History demo (Part 4A) =====
        System.out.println("\n=== Adding visitors to ride history ===");
        // simulate that these visitors rode the ride
        ride.addVisitorToHistory(v1);
        ride.addVisitorToHistory(v2);
        ride.addVisitorToHistory(v3);
        ride.addVisitorToHistory(v4);
        ride.addVisitorToHistory(v5);

        System.out.println("\n=== Print ride history ===");
        ride.printRideHistory();

        // ===== (Optional) Sort demo if you have VisitorComparator =====
        // If you already have VisitorComparator class, uncomment to test:
        // VisitorComparator cmp = new VisitorComparator();
        // ride.sortRideHistory(cmp);
        // System.out.println("\n=== Sorted ride history ===");
        // ride.printRideHistory();

        // ===== Part 6: Export ride history to CSV =====
        System.out.println("\n=== Exporting ride history to CSV ===");
        String filename = "ride_history.csv"; // relative to project working dir
        ride.exportRideHistory(filename);

        System.out.println("\nProgram finished.");
    }
}