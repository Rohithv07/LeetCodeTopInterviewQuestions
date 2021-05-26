package callcenter;

import java.util.LinkedList;
import java.util.Queue;

public class CallCenter {
	private Operator operator;
	private Supervisor supervisor;
	private Manager manager;
	private Queue<Call> queuedCall;
	private Rank rank;
	private Employee employee;

	public CallCenter(Operator operator, Supervisor supervisor, Manager manager) {
		this.operator = operator;
		this.supervisor = supervisor;
		this.manager = manager;
		queuedCall = new LinkedList<>();
	}

	public void dispatchCall(Call call) {
		if (call.rank != rank.OPERATOR && call.rank != rank.MANAGER && call.rank != rank.SUPERVISOR) {
			System.err.println("Not a valid call");
			return;
		}
		if (call.rank == rank.OPERATOR) {
			employee = dispatchCall(call, this.operator);
		} else if (call.rank == rank.SUPERVISOR) {
			employee = dispatchCall(call, this.supervisor);
		} else if (call.rank == rank.MANAGER) {
			employee = dispatchCall(call, this.manager);
		}
		if (employee == null) {
			queuedCall.offer(call);
		}
	}

	public Employee dispatchCall(Call call, Employee employees) {
		// this simply means, of all the available employee, if the employee could take
		// a call, then he takes the call and return that employee
		
		//  this is the code part irrespective of the error it may give.
//		for (Employee employee : employees) {
//			if (employee.call == null) {
//				employee.takeCall(call);
//				return employee;
//			}
//		}
		return null;
	}
}
