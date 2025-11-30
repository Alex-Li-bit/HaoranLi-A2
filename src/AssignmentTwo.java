public class AssignmentTwo {

    public static void main(String[] args) {

        Employee op = new Employee("John", 30, "111-222", "Operator", 4000);
        Ride ride = new Ride("Roller Coaster", op);

        Visitor v1 = new Visitor("Bob", 20, "987654321", "VIP", 160);
        Visitor v2 = new Visitor("Charlie", 25, "555666777", "Regular", 170);
        Visitor v3 = new Visitor("Diana", 18, "111222333", "VIP", 155);
        Visitor v4 = new Visitor("Ethan", 22, "444555666", "Regular", 165);
        Visitor v5 = new Visitor("Fiona", 19, "777888999", "VIP", 158);

        System.out.println("=== Adding visitors to queue ===");
        ride.addVisitorToQueue(v1);
        ride.addVisitorToQueue(v2);
        ride.addVisitorToQueue(v3);
        ride.addVisitorToQueue(v4);
        ride.addVisitorToQueue(v5);
        ride.printQueue();

        System.out.println("\n=== Removing one visitor from queue ===");
        Visitor removed = ride.removeVisitorFromQueue();
        if (removed != null) {
            System.out.println("Removed from queue (returned): " + removed.getName());
        }
        ride.printQueue();

        System.out.println("\n=== Running one cycle (moves up to maxRiders from queue -> history) ===");
        ride.runOneCycle();

        System.out.println("\n=== Print ride history ===");
        ride.printRideHistory();

        System.out.println("\n=== Exporting ride history to CSV ===");
        ride.exportRideHistory("ride_history.csv");

        System.out.println("\n=== Importing ride history from CSV into a new Ride instance ===");
        Ride imported = new Ride("Imported Ride", op);
        imported.importRideHistory("ride_history.csv");

        System.out.println("\n=== Imported History ===");
        imported.printRideHistory();

        System.out.println("\nProgram finished.");
    }
}