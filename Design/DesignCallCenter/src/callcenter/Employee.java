package callcenter;

/**
 * Parent class which will hold the basic details which is common for all other
 * classes and this will be inhertied by them
 * 
 * @author vazha
 *
 */
public class Employee {
	protected String name;
	protected String address;
	protected String title;
	protected String gender;
	protected Rank rank;
	private Call call;
	private CallState callState;

	public Employee(String name, String address, String title, String gender, Rank rank) {
		this.name = name;
		this.address = address;
		this.title = title;
		this.gender = gender;
		this.call = null;
		this.rank = rank;
	}

	/**
	 * Handles when a user takes a call Here the call state will be moved to
	 * in_progress A call is made, so call points to the call declared call.employee
	 * to the current employee
	 * 
	 * @param call
	 */
	public void takeCall(Call call) {
		this.call = call;
		this.call.employee = this;
		this.call.callState = CallState.IN_PROGRESS;
	}

	/**
	 * When we completed with a call
	 * 
	 */
	public void completedCall() {
		this.call.callState = CallState.COMPLETED;
		// then notify
	}

	/**
	 * When we escalate a call, the current employee compleges the call and the call
	 * moves to new employee
	 */
	public void escalateCall() {
		this.call.callState = CallState.COMPLETED;
		call = this.call;
		this.call = null;
		// then notify
	}
}
