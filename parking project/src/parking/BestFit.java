package parking;

public class BestFit implements ISelection {

    @Override
    public int searchSlot(Slot[] slot, Vehicle vehicle) {


        int vw = vehicle.getWidth(), vd = vehicle.getDepth();

        int sw, sd, sum, index = -1, len = slot.length, last = 1000000, count = 0;

        for (int i = 0; i < len; i++) {

            sw = slot[i].getWidth();
            sd = slot[i].getDepth();

            if ((sw >= vw) && (sd >= vd) && (slot[i]).isEmpty()) {

                sum = (sw - vw) + (sd - vd);

                if (sum < last) {

                    last = sum;

                    index = i;
                }

            } else if ((sw == vw) && (sd == vd) && (slot[i].isEmpty())) {

                return i;

            } else if (slot[i].getVehicle() != null) {
                count++;
            }
        }

        if (count == len)
            return -2; // if no fit slot
        else return index; // if no empty slot
    }

}
