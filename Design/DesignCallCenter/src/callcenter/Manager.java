package callcenter;

public class Manager extends Employee {
	public Manager(String name, String address, String title, String gender, Rank rank) {
		super(name, address, title, gender, rank);
		this.rank = Rank.MANAGER;
	}
	
	public void escalateCall() {
		// manager always do the answer
		System.err.println("Manager will do the answer and will not escalate"); 
	}
}
