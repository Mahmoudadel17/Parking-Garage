package parking;


/*
this library to get current date
 */

import java.util.Date;


public class Ticket {


    private Date startTime;
    private Date endTime;
    private int payAmount;

    Ticket() {
        startTime = new Date();
        endTime = new Date();
    }

    public void setStartTime() {
        startTime = new Date();
    }

    public void setEndTime() {
        endTime = new Date();
    }

    public Date getStartTime() {
        return startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public int totalHours() {

        long diffMs = endTime.getTime() - startTime.getTime();
        long diffSec = diffMs / 1000;
        long difMin = diffSec / 60;

        int totalHours = (int) difMin / 60;

        // check if there is a remainder
        if (difMin % 60 != 0) {
            totalHours++;
        }
        return totalHours;

    }

    public int getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(int payAmount) {
        this.payAmount = payAmount;
    }
}
