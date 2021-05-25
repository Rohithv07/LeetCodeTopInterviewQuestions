package callcenter;

/**
 * Here Operator takes the call first, if no operator or operator can't handle
 * the call then it moves to the supervisor and the same process for the manager
 * 
 * @author vazha
 *
 */
public enum Rank {
	OPERATOR, SUPERVISOR, MANAGER
}
