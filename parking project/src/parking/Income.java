package parking;


public class Income {
    private int totalIncome = 0;
    
    
    private static Income instance = null;
    
    private Income() {}
    

    public static Income getIncome() {
		if (instance == null) {instance = new Income();}
		
		return instance;
    }

    public void addFees(int fees) {
        totalIncome += fees;
    }
    
    public int getTotalIncome() {
    	return totalIncome;
    }
}

