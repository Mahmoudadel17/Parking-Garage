package parking;

public class Slot {

    private int width;
    private int depth;
    private String name;
    private Vehicle vehicle;
    private boolean available;


    public Slot() {
        available = true;
        vehicle = null;
    }

    public Slot(int width, int depth, String name) {
        available = true;
        this.width = width;
        this.depth = depth;
        this.name = name;
    }


    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.available = false;

        this.vehicle.setId(name);

    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public String getName() {
        return name;
    }

    public boolean isEmpty() {
        return available;
    }

    public void setDim(int width, int depth) {
        this.width = width;
        this.depth = depth;
    }

    public void reset() {
        vehicle = null;
        available = true;
    }


    public int getDepth() {
        return this.depth;
    }

    public int getWidth() {
        return this.width;
    }


    public void setName(String name) {
        this.name = name;
    }
}