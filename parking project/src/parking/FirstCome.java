package parking;

public class FirstCome implements ISelection {


    @Override
    public int searchSlot(Slot[] slot, Vehicle vehicle) {
        /*
         * count = to check if no empty slots in park ,count number of vehicle in park
         * len is length of array slot
         */
        int count = 0,len = slot.length;
        for (int i = 0; i < len; i++) {
            // check if size of slot greater than  size of vehicle and slot is empty
            if ((slot[i].getWidth() >= vehicle.getWidth()) && (slot[i].getDepth() >= vehicle.getDepth()) && (slot[i].isEmpty())) {
                return i;  // stop function and return index
            }
            // count number of vehicle in garage
            else if (slot[i].getVehicle() != null) {
                count++;
            }
        }
        if (count != len)
            return -1; // if no fit slot
        else return -2; // if no empty slot
    }
}
