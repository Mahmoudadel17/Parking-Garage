package parking;

public class Context {
	protected ISelection current;
	
	public Slot[]slot;
	public Vehicle vehicle;
	
	public Context(ISelection newStratgey) {current = newStratgey;}
	
	public int searchSlot() {
		
		return current.searchSlot(this.slot, this.vehicle);
	}
	
}