package callcenter;

/**
 * Operator class which extends Employee
 * @author vazha
 *
 */
public class Operator extends Employee {
	private Call call;
	private CallState callState;
	public Operator(String name, String address, String title, String gender, Rank rank) {
		super(name, address, title, gender, rank);
		this.rank = Rank.OPERATOR;
	}
	public void escalateCall() {
		// here the logic to move the level of call to the supervisor
		// this.call.level = Rank.SUPERVISOR
		this.escalateCall();
	}
}
