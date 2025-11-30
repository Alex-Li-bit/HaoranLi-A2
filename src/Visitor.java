public class Visitor extends Person {
    private String ticketType;
    private double height;

    public Visitor() {}

    // Simple constructor used by import and many tests
    public Visitor(String name, int age) {
        super(name, age, "");
        this.ticketType = "";
        this.height = 0.0;
    }

    // Full constructor used in some tests
    public Visitor(String name, int age, String phone, String ticketType, double height) {
        super(name, age, phone);
        this.ticketType = ticketType;
        this.height = height;
    }

    public String getTicketType() { return ticketType; }
    public double getHeight() { return height; }

    public void setTicketType(String ticketType) { this.ticketType = ticketType; }
    public void setHeight(double height) { this.height = height; }
}