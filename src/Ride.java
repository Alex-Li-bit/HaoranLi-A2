public class Ride {
    private String rideName;
    private int durationSeconds;
    private Employee operator;

    public Ride() {
        this.rideName = "";
        this.durationSeconds = 0;
        this.operator = null; // 还未分配操作员
    }

    public Ride(String rideName, int durationSeconds, Employee operator) {
        this.rideName = rideName;
        this.durationSeconds = durationSeconds;
        this.operator = operator;
    }

    public String getRideName() {
        return rideName;
    }

    public void setRideName(String rideName) {
        this.rideName = rideName;
    }

    public int getDurationSeconds() {
        return durationSeconds;
    }

    public void setDurationSeconds(int durationSeconds) {
        this.durationSeconds = durationSeconds;
    }

    public Employee getOperator() {
        return operator;
    }

    public void setOperator(Employee operator) {
        this.operator = operator;
    }

    @Override
    public String toString() {
        String opName = (operator == null ? "No operator" : operator.getName());
        return "Ride[name=" + rideName + ", duration=" + durationSeconds + "s, operator=" + opName + "]";
    }
}