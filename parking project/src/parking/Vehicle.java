package parking;

public class Vehicle {

    private  String modelName;
    private  int modelYear;
    private String specialId;
    private int width;
    private int depth;
    private Ticket ticket;

    public Vehicle(String modelName, int modelYear, int width, int depth) {
        this.modelName = modelName;
        this.modelYear = modelYear;
        this.width = width;
        this.depth = depth;
        this.ticket = new Ticket();
    }

    public int getWidth() {
        return width;
    }

    public int getDepth() {
        return depth;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setId(String specialId) {
        this.specialId = specialId;
        this.ticket.setStartTime();
    }

}
