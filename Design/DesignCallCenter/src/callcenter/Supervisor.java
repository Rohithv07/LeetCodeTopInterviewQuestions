package callcenter;

/**
 * Supervisor class that extends Employee
 * @author vazha
 *
 */
public class Supervisor extends Employee {
	public Supervisor(String name, String address, String title, String gender, Rank rank) {
		super(name, address, title, gender, rank);
		this.rank = Rank.SUPERVISOR;
	}
	
	public void escalateCall() {
		// the call gets moved to higher level which is manager
		// this.call.level = Rank.MANAGER
		this.escalateCall();
	}
}
