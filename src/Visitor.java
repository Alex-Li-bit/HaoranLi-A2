public class Visitor extends Person {
    private String ticketType;
    private double height; // 单位：米（或你选择的单位）

    public Visitor() {
        super();
        this.ticketType = "";
        this.height = 0.0;
    }

    public Visitor(String name, int age, String phoneNumber, String ticketType, double height) {
        super(name, age, phoneNumber);
        this.ticketType = ticketType;
        this.height = height;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Visitor[" + super.toString() + ", ticketType=" + ticketType + ", height=" + height + "]";
    }
}