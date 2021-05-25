package callcenter;

public class Call {
	public Rank rank;
	public CallState callState;
	public Employee employee;
	public Call(Rank rank) {
		this.rank = rank;
		this.callState = CallState.READY;
		this.employee = null;
	}
}
