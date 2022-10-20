package parking;

import java.util.Random;

public class ParkingLot {

    private Slot[] slots;
    private int size;

    ParkingLot(int s) {
        size = s;
        Random rand = new Random();

        slots = new Slot[size]; // create size slot in garage
        /*
        array for length and width
         */
        double[][] len = new double[10][2];
        double[][] wi = new double[10][2];
        int start = 80;
        int start2 = 160;
        double c = 1;
        /*
        set dim for arrays
         */
        for (int i = 0; i < 10; i++) {
            len[i][0] = start;
            wi[i][0] = start2;
            len[i][1] = c + 0.5;
            wi[i][1] = c + 0.5;
            start += 5;
            start2 += 5;

            c++;
        }

         /*
          random number (index)
         */
        //instance of random class
        int int_random, r2;

        /*
        set dim ans name for slots
        */
        String fixedName = "PS-", name;
        for (int i = 0; i < size; i++) {

            slots[i] = new Slot();

            int_random = rand.nextInt(10);
            r2 = rand.nextInt(10);

            slots[i].setDim((int) (len[int_random][0]), (int) wi[r2][0]);


            name = fixedName + (i + 1);

            slots[i].setName(name);

        }
    }

    ParkingLot(int[][] arr, int size) {
        this.size = size;
        slots = new Slot[size]; // create size slot in garage
        String fixedName = "PS-", name;

        for (int i = 0; i < size; i++) {
            name = fixedName + (i + 1);
            slots[i] = new Slot(arr[i][0], arr[i][1], name);
        }
    }

    public Slot[] getSlot() {
        return this.slots;
    }

    public String setSlot(int i, Vehicle vehicle) {
        String name = slots[i].getName();
        this.slots[i].setVehicle(vehicle);
        return name;
    }

    public Vehicle removeCar(String id) {
        int i;
        int c = 0;
        for (i = 0; i < size; i++) {
            String ch = slots[i].getName();
            if (id.equals(ch) && slots[i].getVehicle() != null)
                break;
            c++;
        }
        if (c >= size)
            return null;

        Vehicle vehicle = slots[i].getVehicle();
        slots[i].reset();

        return vehicle;
    }


}
