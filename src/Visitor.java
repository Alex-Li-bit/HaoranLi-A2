public class Visitor extends Person {

    private String ticketType;
    private int height;

    public Visitor() {}

    public Visitor(String name, int age, String phone, String ticketType, int height) {
        super(name, age, phone);
        this.ticketType = ticketType;
        this.height = height;
    }

    public String getTicketType() { return ticketType; }
    public void setTicketType(String ticketType) { this.ticketType = ticketType; }

    public int getHeight() { return height; }
    public void setHeight(int height) { this.height = height; }
}