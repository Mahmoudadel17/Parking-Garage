package parking;


public class ParkingCtrl {

    private ParkingLot parkingLot;
    private Income income = Income.getIncome();
    private TotalCost cost;

    ParkingCtrl(int s) {

        parkingLot = new ParkingLot(s);
    }

    ParkingCtrl(int[][] arr, int s) {

        parkingLot = new ParkingLot(arr, s);

    }

    String parkIn(Context algo, String name, int year, int width, int len) {

        Vehicle vehicle = new Vehicle(name, year, width, len);

        Slot[] slots = parkingLot.getSlot();
        
        algo.slot = slots;
        
        algo.vehicle = vehicle;

        int index = algo.searchSlot();

        if (index == -1) {
            return null;
        } else if (index == -2) {
            return "f";
        } else
            return this.parkingLot.setSlot(index, vehicle);

    }

    Ticket parkOut(String id) {
    	
    	
        cost = new TotalCost();

        
        Vehicle vehicle = parkingLot.removeCar(id);

        if (vehicle == null)
            return null;


        Ticket ticket = vehicle.getTicket();

        ticket.setEndTime();

        int hours = ticket.totalHours();

        int fees = cost.getTotalCost(hours,5);

        ticket.setPayAmount(fees);
        
        income.addFees(fees);

        return ticket;

    }
    
    public int TotalIncome() {
    	return income.getTotalIncome();
    }


    public Slot[] slot() {
        return parkingLot.getSlot();
    }

    public int numberOfVehicles() {
        Slot[] slots = parkingLot.getSlot();
        int len = slots.length, count = 0;
        for (int i = 0; i < len; i++) {
            if (slots[i].getVehicle() != null) {
                count++;
            }
        }
        return count;
    }



}
