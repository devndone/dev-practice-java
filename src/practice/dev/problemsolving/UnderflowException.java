package practice.dev.problemsolving;

/**
 * Exception class for access in empty containers such as stacks, queues, and
 * priority queues.
 */
public class UnderflowException extends RuntimeException {

	/**
	 * Construct this exception object.
	 * 
	 * @param message
	 *            the error message.
	 */
	public UnderflowException(String message) {
		super(message);
	}
}
