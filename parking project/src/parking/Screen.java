package parking;

import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Screen {
    public ParkingCtrl garage;


    public static void openHomeScreen(){
        System.out.println("\n ________________ Open Home screen  _________________");
        System.out.println("                                                ");
        System.out.println(" welcome to, Parking Garage application         ");
        System.out.println(" select one way from two configurations Park-in ");
        System.out.println(" _______________________________________________");
        System.out.println("|                                               |");
        System.out.println("|           1- First Come.                      |");
        System.out.println("|           2- Best Fit.                        |");
        System.out.println("|_______________________________________________|\n");
    }

    // function to select who use system
    public static void firstHomeScreen() {
        System.out.println("\n ________________  First Home screen  _________________");
        System.out.println(" _______________________________________________");
        System.out.println("|                                               |");
        System.out.println("|           1- Admin.                           |");
        System.out.println("|           2- user.                            |");
        System.out.println("|           3- close system.                    |");
        System.out.println("|_______________________________________________|\n");
    }

    // function to show home screen
    public static void HomeScreen() {
        System.out.println("\n ________________  Home screen  _________________");
        System.out.println(" _______________________________________________");
        System.out.println("|                                               |");
        System.out.println("|           1- View slots.                      |");
        System.out.println("|           2- Park in.                         |");
        System.out.println("|           3- Park out.                        |");
        System.out.println("|           4- Exit                             |");
        System.out.println("|_______________________________________________|\n");

    }
    // function to show home screen
    public static void adminHomeScreen() {
        System.out.println("\n ________________ Admin Home screen  _________________");
        System.out.println(" _______________________________________________");
        System.out.println("|                                               |");
        System.out.println("|           1- View slots.                      |");
        System.out.println("|           2- Park in.                         |");
        System.out.println("|           3- Park out.                        |");
        System.out.println("|           4- View Total Income.               |");
        System.out.println("|           5- View Total Number Of Vehicle.    |");
        System.out.println("|           6- Exit                             |");
        System.out.println("|_______________________________________________|\n");

    }


    public void ticketScreen(Ticket ticket) {
        if (ticket == null) {
            System.out.println("\nslot is empty\n");
            return;
        }

        SimpleDateFormat Format = new SimpleDateFormat("dd/MM/yyyy hh:mm a");

        String start = Format.format(ticket.getStartTime());
        String end = Format.format(ticket.getEndTime());

        System.out.println("\n-----------------------    Ticket  -----------------------------");
        System.out.println("----------------------------------------------------------------");
        System.out.print("|     From: ");
        System.out.print(start + "   To: ");
        System.out.println(end + "       |");
        System.out.println("|     Total Hours: " + ticket.totalHours() + "                                            |");
        System.out.println("|     Total cost: " + ticket.getPayAmount() + " EGP                                       |");
        System.out.println("-----------------------------------------------------------------\n");
    }

    public void viewSlots(Slot[] slots) {
        int len = slots.length, width, depth;
        boolean ave;
        String name;
        for (int i = 0; i < len; i++) {
            width = slots[i].getWidth();
            depth = slots[i].getDepth();
            name = slots[i].getName();
            ave = slots[i].isEmpty();
            if (ave){
                System.out.println(
                        name + "\nwidth: " + width + "   Depth: " + depth
                );
            }
            else {
                System.out.println(
                        name + "\n (Not Available) "
                );
            }

        }
    }

    public void displayTotalIncome(int income) {
        System.out.println("\nTotal income: " + income);
    }

    public void displayTotalVehicle(int num) {
        System.out.println("\nNumber of vehicles: " + num);
    }



    public static void main(String[] args) {
        Screen screen = new Screen();

        int size, checkIn,Choice1,Choice2,Choice3;

        Scanner homeScan = new Scanner(System.in);

        String numberOfSlots;

        /*
          ------------ choose number slot
         */
        while (true) {
            try {
                System.out.print("Enter number of slots: ");
                numberOfSlots = homeScan.nextLine();
                size = Integer.parseInt(numberOfSlots);
                break;
            } catch (NumberFormatException nfe) {
                System.out.println("Invalid input");
            }
        }

        /*
        ------------------- check input
         */
        while (true) {
            try {
                System.out.println("1- Make system create slot with different dimensions.");
                System.out.println("2- Input dimensions.");
                System.out.print("choice: ");
                String s = homeScan.nextLine();
                checkIn = Integer.parseInt(s);
                if (checkIn != 1 && checkIn != 2) {
                    System.out.println("invalid input \n");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("invalid input " + e.getMessage() + "\n");
            }

        }

        /*
        take array from user
         */

        if (checkIn == 1)
            screen.garage = new ParkingCtrl(size);
        else {
            String ChWi, ChLe;
            int width, len;
            int[][] arr = new int[size][2];
            for (int i = 0; i < size; i++) {
                while (true) {
                    try {

                        System.out.print("Enter width of slot " + (i + 1) + ":");
                        ChWi = homeScan.nextLine();

                        System.out.print("Enter depth of slot " + (i + 1) + ":");
                        ChLe = homeScan.nextLine();


                        width = Integer.parseInt(ChWi);
                        len = Integer.parseInt(ChLe);


                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("invalid input " + e.getMessage() + "\n");
                    }
                }
                arr[i][0] = width;
                arr[i][1] = len;
            }

            screen.garage = new ParkingCtrl(arr, size);
        }

        openHomeScreen();

        int chAlog;
        while (true) {
            try {
                System.out.print("choice:");
                String input = homeScan.nextLine();
                chAlog = Integer.parseInt(input);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input\n");
            }
        }
        
        Context algo = new Context(null);
        
        if (chAlog == 1)
            algo.current = new FirstCome();
        else
            algo.current = new BestFit();



        boolean c1=true;
        while (c1){

            firstHomeScreen();
            //---------------- input
            while (true) {
                try {
                    System.out.print("choice: ");
                    String s = homeScan.nextLine();
                    Choice1 = Integer.parseInt(s);
                    if (Choice1 != 1 && Choice1 != 2 && Choice1 != 3) {
                        System.out.println("invalid input \n");
                        continue;
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("invalid input " + e.getMessage() + "\n");
                }

            }
            // -------------------
            boolean c2=true,c3=true;
            if ( Choice1==1){
                while (c2){

                    adminHomeScreen(); //show home screen
                    // ------------------- input
                    while (true) {
                        try {
                            System.out.print("choice: ");
                            String s = homeScan.nextLine();
                            Choice2 = Integer.parseInt(s);
                            if (Choice2 < 1 || Choice2 > 6) {
                                System.out.println("invalid input \n");
                                continue;
                            }
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("invalid input " + e.getMessage() + "\n");
                        }

                    }
                    // ---------------------

                    if (Choice2==1){
                        screen.viewSlots(screen.garage.slot());
                    }
                    else if (Choice2==2){
                        String modelName, modelYear, width, length;
                        int wi, len, year;

                        while (true) {

                            try {

                                System.out.print("Enter model name: ");
                                modelName = homeScan.nextLine();

                                System.out.print("Enter model year: ");
                                modelYear = homeScan.nextLine();

                                System.out.print("Enter width of car: ");
                                width = homeScan.nextLine();

                                System.out.print("Enter depth of car: ");

                                length = homeScan.nextLine();
                                year = Integer.parseInt(modelYear);
                                wi = Integer.parseInt(width);
                                len = Integer.parseInt(length);
                                break;
                            } catch (NumberFormatException e) {
                                System.out.print("\ninvalid data ");
                                System.out.println(e.getMessage());
                                System.out.println("please Enter data like (kia - 2002 - 120 - 200)\n");
                            }
                        }

                        String id = screen.garage.parkIn(algo, modelName, year, wi, len);

                        if (id == null) {
                            System.out.println("\nNo valid slot for your car\n");
                        } else if (id.equals("f")) {
                            System.out.println("\nNo empty slots in garage\n");
                        } else {
                            System.out.println("\npark in successfully, your id :" + id + "\n");
                        }

                    }
                    else if (Choice2==3){
                        System.out.print("Enter id:");
                        String id;
                        id = homeScan.nextLine();
                        screen.ticketScreen(screen.garage.parkOut(id));
                    }
                    else if (Choice2==4){
                        screen.displayTotalIncome(screen.garage.TotalIncome());
                    }
                    else if (Choice2==5){
                        screen.displayTotalVehicle(screen.garage.numberOfVehicles());
                    }
                    else {
                        System.out.println("Thanks, Have a nice day... :)");
                        c2 = false;
                    }


                }
            }
            else if (Choice1==2){
                while (c3){
                    HomeScreen();
                    // ------------------- input
                    while (true) {
                        try {
                            System.out.print("choice: ");
                            String s = homeScan.nextLine();
                            Choice3 = Integer.parseInt(s);
                            if (Choice3 < 1 || Choice3 > 4) {
                                System.out.println("invalid input \n");
                                continue;
                            }
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("invalid input " + e.getMessage() + "\n");
                        }

                    }
                    // ---------------------

                    if (Choice3==1){
                        screen.viewSlots(screen.garage.slot());
                    }
                    else if (Choice3==2){
                        String modelName, modelYear, width, length;
                        int wi, len, year;

                        while (true) {

                            try {

                                System.out.print("Enter model name: ");
                                modelName = homeScan.nextLine();

                                System.out.print("Enter model year: ");
                                modelYear = homeScan.nextLine();

                                System.out.print("Enter width of car: ");
                                width = homeScan.nextLine();

                                System.out.print("Enter depth of car: ");

                                length = homeScan.nextLine();
                                year = Integer.parseInt(modelYear);
                                wi = Integer.parseInt(width);
                                len = Integer.parseInt(length);
                                break;
                            } catch (NumberFormatException e) {
                                System.out.print("\ninvalid data ");
                                System.out.println(e.getMessage());
                                System.out.println("please Enter data like (kia - 2002 - 120 - 200)\n");
                            }
                        }

                        String id = screen.garage.parkIn(algo, modelName, year, wi, len);

                        if (id == null) {
                            System.out.println("\nNo valid slot for your car\n");
                        } else if (id.equals("f")) {
                            System.out.println("\nNo empty slots in garage\n");
                        } else {
                            System.out.println("\npark in successfully, your id :" + id + "\n");
                        }

                    }
                    else if (Choice3==3){
                        System.out.print("Enter id:");

                        String id;

                        id = homeScan.nextLine();
// delete cash
                        screen.ticketScreen(screen.garage.parkOut(id));
                    }
                    else{
                        System.out.println("Thanks, Have a nice day... :)");
                        c3 = false;
                    }
                }
            }
            else {
                System.out.println("Good By-_-");
                c1=false;
            }


        }


    }
}


