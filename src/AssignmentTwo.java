public class AssignmentTwo {

    public static void main(String[] args) {

        // ========== Create Employee (Operator) ==========
        Employee operator = new Employee("Alice", 30, "123456789", "Operator", 5000);

        // ========== Create Visitors ==========
        Visitor v1 = new Visitor("Bob", 20, "987654321", "VIP", 160);
        Visitor v2 = new Visitor("Charlie", 25, "555666777", "Regular", 170);
        Visitor v3 = new Visitor("Diana", 18, "111222333", "VIP", 155);
        Visitor v4 = new Visitor("Ethan", 22, "444555666", "Regular", 165);
        Visitor v5 = new Visitor("Fiona", 19, "777888999", "VIP", 158);

        // ========== Create Ride ==========
        Ride ride = new Ride("ThunderRide", operator);

        // ========== Part 3: Queue Test ==========
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

        // ========== Part 4A: Ride History Test ==========
        System.out.println("\n=== Adding visitors to ride history ===");
        ride.addVisitorToHistory(v1);
        ride.addVisitorToHistory(v2);
        ride.addVisitorToHistory(v3);
        ride.addVisitorToHistory(v4);
        ride.addVisitorToHistory(v5);

        System.out.println("\n=== Check if visitor exists in history ===");
        System.out.println("Is Diana in history? " + ride.checkVisitorFromHistory(v3));

        System.out.println("\n=== Number of visitors in history ===");
        System.out.println("Total visitors: " + ride.numberOfVisitors());

        System.out.println("\n=== Printing ride history ===");
        ride.printRideHistory();
    }
}